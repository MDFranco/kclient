package tech.mdelgado.kclient.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.mdelgado.kclient.bean.StatisticsData;
import tech.mdelgado.kclient.model.Client;
import tech.mdelgado.kclient.repository.KClientRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@Log4j2
public class KClientServiceImpl implements KClientService{

    @Autowired
    KClientRepository kClientRepository;

    @Override
    public StatisticsData getData() {
        Double average = 0.00;
        Double standardDeviation = 0.00;

        try {
            List<Client> clientList = kClientRepository.findAll();
            log.info("GetData : {}", clientList.toString());
            if (clientList.size() > 0) {
                average = Double.valueOf((clientList.stream().collect(Collectors.summingInt(value -> value.getAge()))
                        / clientList.size()));
                AtomicReference<Double> varianceAR = new AtomicReference<>(0.00);
                Double finalAverage = average;
                clientList.forEach(client -> {
                    varianceAR.updateAndGet(v -> v + Math.pow(client.getAge() - finalAverage, 2));
                });
                Double variance = (varianceAR.get() / (clientList.size() - 1));
                standardDeviation = Math.sqrt(variance);
            }
        } catch (Exception e) {
            log.error("Error getData: ", e);
        }

        return new StatisticsData(average, standardDeviation);
    }
}

package tech.mdelgado.kclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.mdelgado.kclient.bean.StatisticsData;
import tech.mdelgado.kclient.service.KClientService;

@RestController
public class KClientController {

    @Autowired
    KClientService kClientService;

    @GetMapping("/kpideclientes")
    public ResponseEntity<StatisticsData> getStatistics() {
        return ResponseEntity.ok(kClientService.getData());
    }
}

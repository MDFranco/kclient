package tech.mdelgado.kclient.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.mdelgado.kclient.model.Client;

public interface KClientRepository extends MongoRepository<Client, String> {
}

package com.silaichev.microservice.repository;

import com.silaichev.microservice.entity.MicroserviceCredential;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MicroserviceCredentialsRepository extends MongoRepository<MicroserviceCredential, String> {
}

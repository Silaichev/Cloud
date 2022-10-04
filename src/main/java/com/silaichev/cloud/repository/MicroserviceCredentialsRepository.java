package com.silaichev.cloud.repository;

import com.silaichev.cloud.entity.MicroserviceCredential;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MicroserviceCredentialsRepository extends MongoRepository<MicroserviceCredential, String> {
}

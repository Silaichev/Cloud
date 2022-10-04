package com.silaichev.cloud.repository;

import com.silaichev.cloud.entity.CloudCredential;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CloudCredentialRepository extends MongoRepository<CloudCredential,Long> {
}

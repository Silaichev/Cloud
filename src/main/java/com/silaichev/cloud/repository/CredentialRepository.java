package com.silaichev.cloud.repository;

import com.silaichev.cloud.entity.Credential;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CredentialRepository extends MongoRepository<Credential,Long> {
}

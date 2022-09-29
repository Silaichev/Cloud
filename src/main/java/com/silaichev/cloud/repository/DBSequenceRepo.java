package com.silaichev.cloud.repository;

import com.silaichev.cloud.entity.DBSequence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DBSequenceRepo extends MongoRepository<DBSequence, String> {
}

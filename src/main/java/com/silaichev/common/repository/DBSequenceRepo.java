package com.silaichev.common.repository;

import com.silaichev.common.entity.DBSequence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DBSequenceRepo extends MongoRepository<DBSequence, String> {
}

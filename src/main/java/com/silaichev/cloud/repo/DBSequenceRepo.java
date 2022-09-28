package com.silaichev.cloud.repo;

import com.silaichev.cloud.pojo.DBSequence;
import com.silaichev.cloud.pojo.Info;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DBSequenceRepo extends MongoRepository<DBSequence, String> {
}

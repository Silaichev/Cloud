package com.silaichev.cloud.repository;


import com.silaichev.cloud.entity.Info;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InfoRepo  extends MongoRepository<Info, Long> {

}

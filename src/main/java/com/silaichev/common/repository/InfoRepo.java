package com.silaichev.common.repository;


import com.silaichev.common.entity.Info;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InfoRepo  extends MongoRepository<Info, Long> {

}

package com.test.bulb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BulbRepo extends MongoRepository<Bulb, Long>{

}

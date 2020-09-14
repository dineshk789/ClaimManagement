package com.journaldev.bootifulmongodb.dal;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.journaldev.bootifulmongodb.model.Claims;


@Repository
public interface ClaimsRepository extends MongoRepository<Claims, String> {
}

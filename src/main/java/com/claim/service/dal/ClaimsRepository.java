package com.claim.service.dal;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.claim.service.model.Claims;


@Repository
public interface ClaimsRepository extends MongoRepository<Claims, String> {
}

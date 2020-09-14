package com.claim.service.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.claim.service.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}

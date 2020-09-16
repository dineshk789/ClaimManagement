package com.claim.service.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.claim.service.model.Claims;
import com.claim.service.model.User;

@Repository
public class UserDALImpl implements UserDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<User> getAllUsers() {
		return mongoTemplate.findAll(User.class);
	}
	
	@Override
	public List<Claims> getAllClaims() {
		return mongoTemplate.findAll(Claims.class);
	}
	
	@Override
	public Claims getCliamsById(String emp_id) {
		Query query = new Query();
		System.out.println("----------emp_id:"+emp_id+"---------------------------");
		query.addCriteria(Criteria.where("emp_id").is(emp_id));
		System.out.println("----------emp_id:"+emp_id+"---------------------------");
		return mongoTemplate.findOne(query, Claims.class);
	}

	@Override
	public User getUserById(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		return mongoTemplate.findOne(query, User.class);
	}
	
	@Override
	public Claims updateClaim(Claims claim){
        Query query = new Query();
        query.addCriteria(Criteria.where("emp_id").is(claim.getEmp_id()));
        Update update = new Update();
        update.set("emp_name", claim.getEmp_name());
        update.set("claim_number", claim.getClaim_number());
        update.set("claim_program", claim.getClaim_program());
        update.set("claim_type", claim.getClaim_type());
        return mongoTemplate.findAndModify(query, update, Claims.class);
    }

	@Override
	public User addNewUser(User user) {
		mongoTemplate.save(user);
		// Now, user object will contain the ID as well
		return user;
	}

	@Override
	public Object getAllUserSettings(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		User user = mongoTemplate.findOne(query, User.class);
		return user != null ? user.getUserSettings() : "User not found.";
	}

	@Override
	public String getUserSetting(String userId, String key) {
		Query query = new Query();
		query.fields().include("userSettings");
		query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("userSettings." + key).exists(true)));
		User user = mongoTemplate.findOne(query, User.class);
		return user != null ? user.getUserSettings().get(key) : "Not found.";
	}

	@Override
	public String addUserSetting(String userId, String key, String value) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		User user = mongoTemplate.findOne(query, User.class);
		if (user != null) {
			user.getUserSettings().put(key, value);
			mongoTemplate.save(user);
			return "Key added.";
		} else {
			return "User not found.";
		}
	}
}

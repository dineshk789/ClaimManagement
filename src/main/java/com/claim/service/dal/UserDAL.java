package com.claim.service.dal;

import java.util.List;

import com.claim.service.model.Claims;
import com.claim.service.model.User;

public interface UserDAL {

	List<User> getAllUsers();

	User getUserById(String userId);

	User addNewUser(User user);

	Object getAllUserSettings(String userId);

	String getUserSetting(String userId, String key);

	String addUserSetting(String userId, String key, String value);

	List<Claims> getAllClaims();

	Claims getCliamsById(String emp_id);

	Claims updateClaim(Claims claim);
}
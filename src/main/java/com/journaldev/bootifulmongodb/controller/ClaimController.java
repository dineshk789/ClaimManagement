package com.journaldev.bootifulmongodb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.bootifulmongodb.dal.ClaimsRepository;
import com.journaldev.bootifulmongodb.dal.UserDAL;
import com.journaldev.bootifulmongodb.model.Claims;


@RestController
@RequestMapping(value = "/claims")
public class ClaimController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final ClaimsRepository claimsRepository;

	private final UserDAL userDAL;

	public ClaimController(ClaimsRepository claimsRepository, UserDAL userDAL) {
		this.claimsRepository = claimsRepository;
		this.userDAL = userDAL;
	}

	@CrossOrigin
	@RequestMapping(value = "/getClaims", method = RequestMethod.GET)
	public List<Claims> getAllClaims() {
		LOG.info("Getting all users.");
		return claimsRepository.findAll();
	}

	@CrossOrigin
	@RequestMapping(value = "/getClaim/{emp_id}", method = RequestMethod.GET)
	public Claims getClaim(@PathVariable String emp_id) {
		LOG.info("Getting user with ID: {}.", emp_id);
		LOG.info("----------emp_id:"+emp_id+"---------------------------");
		return userDAL.getCliamsById(emp_id);
	}
	
	@CrossOrigin
	@PutMapping("/claim/{emp_id}")
    public Claims updateDept(@RequestBody Claims claim, @PathVariable String emp_id) {
		
		LOG.info("update----------------------------------");
		LOG.info("Getting user with ID: {}.", claim.getEmp_id());
		LOG.info("Getting user with ID: {}.", claim.getEmp_name()," ----",claim.getClaim_number());
		return userDAL.updateClaim(claim);
    }


}
package com.journaldev.bootifulmongodb.model;

import java.util.HashMap;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class Claims {

	@JsonIgnore
	@Id
	private String claim_id;
	public String getClaim_id() {
		return claim_id;
	}

	public void setClaim_id(String claim_id) {
		this.claim_id = claim_id;
	}

	private String emp_id;
	private String emp_name;
	private String claim_number;
	private String claim_type;
	private String claim_program;
	private String start_date;
	private String end_date;
	

	
	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getClaim_number() {
		return claim_number;
	}

	public void setClaim_number(String claim_number) {
		this.claim_number = claim_number;
	}

	public String getClaim_type() {
		return claim_type;
	}

	public void setClaim_type(String claim_type) {
		this.claim_type = claim_type;
	}

	public String getClaim_program() {
		return claim_program;
	}

	public void setClaim_program(String claim_program) {
		this.claim_program = claim_program;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

}

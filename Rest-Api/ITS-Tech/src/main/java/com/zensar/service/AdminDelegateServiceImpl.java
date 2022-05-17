package com.zensar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AdminDelegateServiceImpl implements AdminServiceDelegate {
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public boolean isDeleteSuccessful(int id) {
		HttpEntity<Integer> entity = new HttpEntity<>(id);

		ResponseEntity<Boolean> response=this.restTemplate.exchange("http://API-GATEWAY/its-admin/panel/tech/{id}", HttpMethod.DELETE, entity, Boolean.class,id);
		return response.getBody();
	}
	
	

}

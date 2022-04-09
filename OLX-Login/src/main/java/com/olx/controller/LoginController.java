package com.olx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.User;
import com.olx.service.LoginService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/olx/login")
@CrossOrigin(origins = "*")

public class LoginController {
	@Autowired
	LoginService loginService;

	@PostMapping(value = "/user/authenticate", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Reads specific stock", notes = "This REST API returns list the stock of given id")

	public String authenticate(@RequestBody User user) {
		return loginService.authenticate(user);
	}

	@DeleteMapping(value = "/user/logout")
	@ApiOperation(value = "Reads specific stock", notes = "This REST API returns list the stock of given id")

	public boolean logout(@RequestHeader("auth-token") String authToken) {
		return loginService.logout(authToken);
	}

	@PostMapping(value = "/user", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Reads specific stock", notes = "This REST API returns list the stock of given id")

	public User registerUser(@RequestBody User user) {
		return loginService.registerUser(user);
	}

	@ApiOperation(value = "Reads specific stock", notes = "This REST API returns list the stock of given id")

	@GetMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public User getUser(User user) {
		return loginService.getUser(user);
	}

	@GetMapping(value = "/token/validate", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Reads specific stock", notes = "This REST API returns list the stock of given id")

	public String validateToken(String authToken) {
		return loginService.validateToken(authToken);

	}
}

package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.DBConfig;

@RestController
public class TestController {

    @Autowired
    DBConfig dbConfig;

    @Value("@{spring.application.name}")
    private String appName;

    @GetMapping(value = "/1")
    public String getAppName() {
	return this.appName;
    }

    @GetMapping(value = "/2")
    public String getDbConfig() {
	return this.dbConfig.toString();
    }
}

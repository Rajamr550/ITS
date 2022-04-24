package com.zensar.controller;

import java.security.Principal;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

    @GetMapping(value = "/")
    public String show(Principal principal) {

	OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) principal;
	return "Hello " + oAuth2AuthenticationToken.getPrincipal().getAttribute("login");
    }

    @GetMapping(value = "/hi")
    public String sayHi() {
	return "Hi Rutuja";
    }
}

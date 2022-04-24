package com.zensar.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController

public class ContactController {
    @GetMapping(value = "/api/contact", produces = MediaType.APPLICATION_JSON_VALUE)

    public Contact getc() {
	return new Contact("jdfg", 12);

    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Contact {
    String nameString;
    int mobile;
}

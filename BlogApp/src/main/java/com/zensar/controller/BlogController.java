package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.BlogDto;
import com.zensar.service.BlogService;

@RestController
@RequestMapping("/blog")
@CrossOrigin(origins = "*")

public class BlogController {
    @Autowired
    BlogService blogService;

    @PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

    public ResponseEntity<BlogDto> createNewBlog(@RequestBody BlogDto blogDto) {
	return new ResponseEntity<BlogDto>(blogService.createNewBlog(blogDto), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

    public ResponseEntity<BlogDto> readBlogById(@PathVariable("id") int id) {
	return new ResponseEntity<BlogDto>(blogService.readBlogById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<BlogDto> updateBlogById(@PathVariable("id") int id, @RequestBody BlogDto blogDto) {
	return new ResponseEntity<BlogDto>(blogService.updateBlogById(id, blogDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") int id) {
	return new ResponseEntity<Boolean>(blogService.deleteById(id), HttpStatus.OK);
    }

}

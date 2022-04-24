package com.zensar.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zensar.entity.BlogDocument;

public interface BlogRepo extends MongoRepository<BlogDocument, Integer> {

}
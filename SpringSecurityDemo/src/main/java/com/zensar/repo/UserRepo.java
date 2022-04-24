package com.zensar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.*;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    public List<UserEntity> findByName(String name);

}
package com.zensar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {

}
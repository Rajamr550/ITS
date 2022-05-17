/*
 * 
 * idEmp
 * name
 * type-hr or tech
 * location
 * 
 * 
 * 
 * 
 * 
 */

package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    private Integer employeeId;
    private String name;
    private String type;
    private String location;

    public EmployeeEntity(Integer employeeId, String name, String type, String location) {
	super();
	this.employeeId = employeeId;
	this.name = name;
	this.type = type;
	this.location = location;
    }

    public EmployeeEntity() {
	super();
    }

    public Integer getEmployeeId() {
	return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
	this.employeeId = employeeId;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getLocation() {
	return location;
    }

    public void setLocation(String location) {
	this.location = location;
    }

    @Override
    public String toString() {
	return "EmployeeEntity [employeeId=" + employeeId + ", name=" + name + ", type=" + type + ", location="
		+ location + "]";
    }

}
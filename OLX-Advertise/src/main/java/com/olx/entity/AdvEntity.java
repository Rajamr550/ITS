package com.olx.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "advertisements")
public class AdvEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String title;
    private String description;
    private double price;
    private long category;
    @Column(name = "created_date")
    private LocalDate createdDate;
    @Column(name = "modified_date")
    private LocalDate modifiedDate;
    private String active;
    @Column(name = "username")
    private String username;
}
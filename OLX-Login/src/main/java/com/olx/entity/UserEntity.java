package com.olx.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")

public class UserEntity {
    private String fName;
    private String lName;
    private String userName;
    private String pass;
    private String email;
    private long phoneNum;

}

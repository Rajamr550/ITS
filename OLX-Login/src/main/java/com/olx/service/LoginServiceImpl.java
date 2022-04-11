package com.olx.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.dto.User;
import com.olx.entity.UserEntity;
import com.olx.repository.UserRepo;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public String authenticate(User user) {
	return "kjf34t";

    }

    @Override
    public boolean logout(String authToken) {
	return true;

    }

    @Override
    public User registerUser(User user) {
	UserEntity userEntity = convertDTOIntoEntity(user);
	userEntity = userRepo.save(userEntity);
	return convertEntityIntoDTO(userEntity);
    }

//    @Override
//    public List<User> getUserDetails(String authToken) {
//	List<UserEntity> userEntity = userRepo.findAll();
//	List<UserDetails> userDto = convertEntityListIntoDTOList(userEntity);
//	return userDto;
//    }

    // get a user
    @Override
    public User getUser(int id) {
	UserEntity uEntity = userRepo.getById(id);
	return convertEntityIntoDTO(uEntity);

    }

    @Override
    public String validateToken(String authToken) {
	return authToken;
    }

    private UserEntity convertDTOIntoEntity(User user) {
	TypeMap<User, UserEntity> tMap = modelMapper.typeMap(User.class, UserEntity.class);
	UserEntity userEntity = modelMapper.map(user, UserEntity.class);
	return userEntity;
    }

    private User convertEntityIntoDTO(UserEntity userEntity) {
	TypeMap<UserEntity, User> tMap = modelMapper.typeMap(UserEntity.class, User.class);
	User user = modelMapper.map(userEntity, User.class);
	return user;
    }

//  @Override
//  public User getUser() {
//	List<UserEntity> userEntityList = userRepo.findByName
//	List<User> userDtoList = new ArrayList<User>();
//	for (UserEntity userEntity : userEntityList) {
//	    User user = convertEntityIntoDTO(userEntity);
//	    userDtoList.add(user);
//	}
//	return user;
//  }

}
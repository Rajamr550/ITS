package com.olx.service;

import java.util.ArrayList;
import java.util.List;

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
//    public User getUser(String uName) {
//	List<UserEntity> userEntityList = userRepo.findByName
//	List<User> userDtoList = new ArrayList<User>();
//	for (UserEntity userEntity : userEntityList) {
//	    User user = convertEntityIntoDTO(userEntity);
//	    userDtoList.add(user);
//	}
//	return user;
//    }

  @Override
  public User getUser(User user) {

      user.setEmail(null);
      user.
	return user;
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

}

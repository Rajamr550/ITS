package com.olx.service;

import com.olx.dto.User;
import java.util.List;

public interface LoginService {
    public String authenticate(User user);

    public boolean logout(String authToken);

    public User registerUser(User user);

    public User getUser(int id);

    public String validateToken(String authToken);

}

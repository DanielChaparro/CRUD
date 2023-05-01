package com.vass.crud.service;

import com.vass.crud.controller.request.UserRequest;
import com.vass.crud.model.User;
import java.util.List;

public interface UserService {

    User saveUser(UserRequest userRequest);
    User updateUser(Long id , String password);
    List<User> listUser();
    User findUserName(String username);
    void deleteUser(Long id);
}

package com.vass.crud.service.impl;

import com.vass.crud.controller.request.UserRequest;
import com.vass.crud.exception.UserNotFoundException;
import com.vass.crud.model.Role;
import com.vass.crud.model.User;
import com.vass.crud.repository.RoleRepository;
import com.vass.crud.repository.UserRepository;
import com.vass.crud.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public User saveUser(UserRequest userRequest) {
        if(Objects.isNull(userRequest)){
            throw new UserNotFoundException("Error create user");
        }else{
            User user = modelMapper.map(userRequest, User.class);
            user.setRoles( roleRepository.findByName(userRequest.getRole()));
            return userRepository.save(user);
        }
    }

    @Override
    @Transactional
    public User updateUser(Long id, String password) {
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found"));
        user.setPassword(password);
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserName(String username) {
        User user =  userRepository.findByUsername(username);
        if(Objects.isNull(user)){
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

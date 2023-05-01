package com.vass.crud.service.impl;

import com.vass.crud.controller.request.RoleRequest;
import com.vass.crud.exception.RoleNotFoundException;
import com.vass.crud.model.Role;
import com.vass.crud.repository.RoleRepository;
import com.vass.crud.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RoleServiceImpl implements RoleService {


    private RoleRepository roleRepository;
    private ModelMapper modelMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Role saveRole(RoleRequest roleRequest) {
        if(Objects.isNull(roleRequest)){
            throw new RoleNotFoundException("Error create role");
        }else{
            Role role = modelMapper.map(roleRequest, Role.class);
            return roleRepository.save(role);
        }
    }

    @Override
    public Role updateRole(Long id, String newName) {
        Role role = roleRepository.findById(id).orElseThrow(()-> new RoleNotFoundException("Role not found"));
        role.setName(newName);
        return roleRepository.save(role);
    }

    @Override
    public List<Role> listRole() {
        return roleRepository.findAll();
    }

    @Override
    public Role findRoleName(String name) {
        Role role = roleRepository.findByName(name);
        if(Objects.isNull(role)){
            throw new RoleNotFoundException("Role not found");
        }
        return role;
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}

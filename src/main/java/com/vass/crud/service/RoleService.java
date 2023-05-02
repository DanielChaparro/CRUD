package com.vass.crud.service;

import com.vass.crud.controller.request.RoleRequest;
import com.vass.crud.model.Role;

import java.util.List;

public interface RoleService {

    Role saveRole(RoleRequest roleRequest);
    Role updateRole(Long id, String newName);
    List<Role> listRole();
    List<Role> findRoleName(String name);
    void deleteRole(Long id);

}

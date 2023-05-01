package com.vass.crud.controller;

import com.vass.crud.controller.request.RoleRequest;
import com.vass.crud.exception.RoleNotFoundException;
import com.vass.crud.model.Role;
import com.vass.crud.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/save_role")
    public ResponseEntity<Role> saveRole(@RequestBody RoleRequest roleRequest){
        Role role = roleService.saveRole(roleRequest);
        return ResponseEntity
                .ok()
                .body(role);
    }

    @PutMapping(value = "/update_role/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody String name) {
        Role role = roleService.updateRole(id,name);
        return ResponseEntity
                .ok()
                .header("Update Role", role.getName())
                .body(role);

    }

    @GetMapping(value = "/list_role")
    private ResponseEntity<List<Role>> listRole(){
        List<Role> roles = roleService.listRole();
        return ResponseEntity
                .ok()
                .header("List Role","Values")
                .body(roles);
    }



    @DeleteMapping(value = "/delete_role/{id}")
    private ResponseEntity<String> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return ResponseEntity
                .ok("Role with id " + id + "deleted successfully");
    }

    @GetMapping(value = "/find_role/{name}")
    private ResponseEntity<Role> findRoleName(@PathVariable String name) throws RoleNotFoundException {
        Role role = roleService.findRoleName(name);
        return  ResponseEntity
                .ok()
                .header("Find Role")
                .body(role);
    }

}

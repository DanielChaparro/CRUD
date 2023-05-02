package com.vass.crud.repository;

import com.vass.crud.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    List<Role> findByName(String name);
}

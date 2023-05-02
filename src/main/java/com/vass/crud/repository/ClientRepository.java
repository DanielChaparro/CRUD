package com.vass.crud.repository;

import com.vass.crud.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
    void deleteByIdentification(String identification);
}

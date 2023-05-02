package com.vass.crud.service;

import com.vass.crud.controller.request.ClientRequest;
import com.vass.crud.model.Client;

import java.util.Date;
import java.util.List;

public interface ClientService {

    Client saveClient(ClientRequest clientRequest);
    Client updateClient(Client client);
    List<Client> listClient();
    List<Client> findClient(String name, String lastName, String identification, String email, Date birthDate);
    void deleteClient(String identification);
}

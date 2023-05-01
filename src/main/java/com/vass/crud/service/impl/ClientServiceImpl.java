package com.vass.crud.service.impl;

import com.vass.crud.controller.request.ClientRequest;
import com.vass.crud.exception.ClientNotFoundException;
import com.vass.crud.model.Client;
import com.vass.crud.repository.ClientRepository;
import com.vass.crud.repository.UserRepository;
import com.vass.crud.service.ClientService;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Client saveClient(ClientRequest clientRequest) {
        if(Objects.isNull(clientRequest)){
            throw new ClientNotFoundException("Error created cliente");
        }
        Client client =  modelMapper.map(clientRequest, Client.class);
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client clientRequest) {
        Client client = clientRepository.findById(clientRequest.getId()).orElseThrow(()-> new ClientNotFoundException("Client not found"));
        client = modelMapper.map(clientRequest, Client.class);
        return clientRepository.save(client);
    }

    @Override
    public List<Client> listClient() {
        return clientRepository.findAll();
    }


    private List<Predicate<Client>> addFilter(Predicate<Client> filter){
        List<Predicate<Client>> filters = new ArrayList<>();
        filters.add(filter);
        return filters;
    }
    @Override
    public List<Client> findClient(String name, String lastName, String identification, String email, Date birthDate) {
        List<Client> clients =  clientRepository.findAll();
        Predicate<Client> namePredicate = client -> StringUtils.isEmpty(name) || client.getName().contains(name);
        Predicate<Client> lastNamePredicate = client -> StringUtils.isEmpty(lastName) || client.getLastName().contains(lastName.toLowerCase());
        Predicate<Client> identificationPredicate = client -> StringUtils.isEmpty(identification) || client.getIdentification().contains(identification);
        Predicate<Client> emailPredicate = client -> StringUtils.isEmpty(email) || client.getEmail().contains(email);
        Predicate<Client> birthDatePredicate = client -> Objects.isNull(birthDate) || client.getBirthDate().equals(birthDate);

        /*                .filter(client -> Objects.isNull(name) || client.getName().equalsIgnoreCase(name))
                .filter(client -> Objects.isNull(lastName) || client.getLastName().equalsIgnoreCase(lastName))
                .filter(client -> Objects.isNull(email) || client.getEmail().equalsIgnoreCase(email))
                .filter(client -> Objects.isNull(birthDate) || client.getBirthDate().equals(birthDate))
                .collect(Collectors.toList());*/
        return  clients.stream()
                .filter(namePredicate.and(lastNamePredicate).and(identificationPredicate).and(identificationPredicate).and(emailPredicate).and(birthDatePredicate))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteClient(String identification) {
        clientRepository.deleteByIdentification(identification);
    }
}

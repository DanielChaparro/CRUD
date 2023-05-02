package com.vass.crud.controller;

import com.vass.crud.controller.request.ClientRequest;
import com.vass.crud.model.Client;
import com.vass.crud.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(value = "/save_client")
    public ResponseEntity<Client> saveClient(@RequestBody ClientRequest clientRequest){
        Client client = clientService.saveClient(clientRequest);
        return ResponseEntity
                .ok()
                .body(client);
    }

    @PutMapping(value = "/update_client")
    public ResponseEntity<Client> updateClient(@RequestBody Client clientRequest){
        Client client = clientService.updateClient(clientRequest);
        return ResponseEntity
                .ok()
                .body(client);
    }

    @GetMapping(value = "/list_client")
    public ResponseEntity<List<Client>> listClient(){
        List<Client> clients = clientService.listClient();
        return ResponseEntity
                .ok()
                .body(clients);
    }

    @DeleteMapping(value = "/delete_client/{identification}")
    public ResponseEntity<String> deleteClient(@RequestParam String identification){
        clientService.deleteClient(identification);
        return ResponseEntity
                .ok("Client with id " + identification + "deleted successfully");
    }

    @GetMapping(value = "/filter_client")
    public ResponseEntity<List<Client>> filterClient(@RequestParam(required = false) String name,
                                                     @RequestParam(name="lastname",required = false) String lastName,
                                                     @RequestParam(required = false) String identification,
                                                     @RequestParam(required = false) String email,
                                                     @RequestParam(name = "birthdate",required = false) Date birthDate){
        List<Client> clients = clientService.findClient(name, lastName, identification, email, birthDate);
        return ResponseEntity
                .ok()
                .body(clients) ;
    }
}

package org.yassinmk.clientcrud.service;

import org.yassinmk.clientcrud.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
     List<Client> findAllClient();
     Optional<Client> findClientById(Long id);
    Client creatClient(Client client);
    Optional<Client> updateClient(Long id, Client client);
     void deleteClientById(Long id);
}

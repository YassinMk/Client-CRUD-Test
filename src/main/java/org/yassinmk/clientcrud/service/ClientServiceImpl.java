package org.yassinmk.clientcrud.service;

import org.springframework.stereotype.Service;
import org.yassinmk.clientcrud.entities.Client;
import org.yassinmk.clientcrud.repository.ClientRepository;

import java.util.List;
import java.util.Optional;
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;

    }

    @Override
    public List<Client> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findClientById(Long id) {
        return Optional.ofNullable(clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found")));
    }

    @Override
    public Client creatClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> updateClient(Long id, Client client) {
        return findClientById(id).map(client1 -> {
            client1.setName(client.getName());
            client1.setEmail(client.getEmail());
            client1.setPhone(client.getPhone());
            return clientRepository.save(client1);
        });

    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }
}

package com.example.wsclients.services;

import com.example.wsclients.models.Client;

import java.util.List;

public interface ClientService {
    public Client save(Client product);
    public Client findByClientId(Long id);

    public void deleteById(Long id);
    public Client update(Long id, Client client);

    public List<Client> findAll();



}

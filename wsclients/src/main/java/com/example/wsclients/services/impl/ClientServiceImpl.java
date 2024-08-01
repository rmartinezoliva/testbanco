package com.example.wsclients.services.impl;

import com.example.wsclients.exceptions.ClientNotFoundExcepcion;
import com.example.wsclients.mappers.ClientMapper;
import com.example.wsclients.models.Client;
import com.example.wsclients.repositories.ClientRepository;
import com.example.wsclients.services.ClientService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@NoArgsConstructor
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper mapper;

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findByClientId(Long id){
        Client client =clientRepository.findByClienteid(id).orElse(null);
        if(client == null){
            throw new ClientNotFoundExcepcion("Client ["+id+"] not found");
        }
        return client;
    }

    @Override
    public void deleteById(Long id) {
        Client client =clientRepository.findByClienteid(id).orElse(null);
        if(client == null){
            throw new ClientNotFoundExcepcion("Client ["+id+"] not found");
        }
        clientRepository.deleteById(id);
    }

    @Override
    public Client update(Long id, Client clientAux) {
        Client client =clientRepository.findByClienteid(id).orElse(null);
        if(client == null){
            throw new ClientNotFoundExcepcion("Client ["+id+"] not found");
        }

        client = mapper.updateClientFromClientAux(clientAux,client);

        clientRepository.save(client);
        return client;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }


}

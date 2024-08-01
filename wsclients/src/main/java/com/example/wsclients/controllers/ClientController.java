package com.example.wsclients.controllers;

import com.example.wsclients.dtos.request.ClientCreateRequest;
import com.example.wsclients.dtos.request.ClientUpdatePartialRequest;
import com.example.wsclients.dtos.request.ClientUpdateRequest;
import com.example.wsclients.dtos.response.ClientResponse;
import com.example.wsclients.mappers.ClientMapper;
import com.example.wsclients.services.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Api cliente V1", description = "Api cliente V1")
@CrossOrigin(origins = "*")
@RestController("/clientes.v1.crud")
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientMapper mapper;

    @PostMapping
    public ResponseEntity<ClientResponse> create(@Valid @RequestBody ClientCreateRequest clientCreateRequest) {
           return new ResponseEntity<>(mapper.toResponse(clientService.save(mapper.toModel(clientCreateRequest))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> findAll() {
            return new ResponseEntity<>(mapper.toResponseList(clientService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientResponse> findByIdAll( @PathVariable Long clientId){
            return new ResponseEntity<>(mapper.toResponse(clientService.findByClientId(clientId)), HttpStatus.CREATED);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long clientId) {
        clientService.deleteById(clientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<ClientResponse> update(@PathVariable Long clientId, @Valid @RequestBody ClientUpdateRequest clientUpdateRequest) {
        return new ResponseEntity<>(mapper.toResponse(clientService.update(clientId, mapper.toUpdateModel(clientUpdateRequest))), HttpStatus.OK);
    }

    @PatchMapping("/{clientId}")
    public ResponseEntity<ClientResponse> updatePartial(@PathVariable Long clientId, @Valid @RequestBody ClientUpdatePartialRequest clientUpdatePartialRequest) {
        return new ResponseEntity<>(mapper.toResponse(clientService.update(clientId, mapper.toUpdatePartialModel(clientUpdatePartialRequest))), HttpStatus.OK);
    }
}

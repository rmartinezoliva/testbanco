package com.example.wsclients.controllers;

import com.example.wsclients.data.TestDataFactory;
import com.example.wsclients.dtos.request.ClientCreateRequest;
import com.example.wsclients.dtos.response.ClientResponse;
import com.example.wsclients.mappers.ClientMapper;
import com.example.wsclients.models.Client;
import com.example.wsclients.services.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;

@WebMvcTest(ClientController.class)
class ClientControllerTest {

    private String uri = "/clientes";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService service;

    @MockBean
    private ClientMapper mapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateClientSuccess() throws Exception {

        ClientCreateRequest request = new TestDataFactory().createClientCreateRequest();

        ClientResponse response = new TestDataFactory().createClientResponse();

        Client client = new TestDataFactory().createClient();

        when(mapper.toModel(request)).thenReturn(client);
        when(service.save(client)).thenReturn(client);
        when(mapper.toResponse(client)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request))
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.clienteid").value(client.getClienteid().toString()));
    }

}
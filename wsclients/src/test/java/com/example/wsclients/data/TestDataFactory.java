package com.example.wsclients.data;

import com.example.wsclients.dtos.request.ClientCreateRequest;
import com.example.wsclients.dtos.response.ClientResponse;
import com.example.wsclients.models.Client;
import net.datafaker.Faker;

import java.util.UUID;

public class TestDataFactory {
    private static Faker faker = new Faker();

    public static ClientCreateRequest createClientCreateRequest() {
        ClientCreateRequest request = new ClientCreateRequest();
        request.setNombre(faker.name().fullName());
        request.setDireccion(faker.address().fullAddress());
        request.setTelefono(faker.phoneNumber().cellPhone());
        request.setEdad(faker.number().numberBetween(18, 100));
        request.setGenero(faker.options().option("M", "F"));
        request.setIdentificacion(faker.idNumber().valid());
        request.setEstado(faker.options().option(true, false));
        request.setContrasenna(faker.internet().password());

        return request;
    }

    public static ClientCreateRequest createClientBadRequest() {
        ClientCreateRequest request = new ClientCreateRequest();
        request.setNombre(faker.name().fullName());
        request.setDireccion(faker.address().fullAddress());
        return request;
    }

    public static ClientResponse createClientResponse() {
        ClientResponse response = new ClientResponse();

        response.setNombre(faker.name().fullName());
        response.setDireccion(faker.address().fullAddress());
        response.setTelefono(faker.phoneNumber().cellPhone());
        response.setEdad(faker.number().numberBetween(18, 100));
        response.setGenero(faker.options().option("M", "F"));
        response.setIdentificacion(faker.idNumber().valid());
        response.setEstado(faker.options().option(true, false));
        response.setContrasenna(faker.internet().password());
        response.setClienteid(2L);
        response.setId(UUID.randomUUID().toString());

        return response;
    }

       public static Client createClient() {
            Client client = new Client();

           client.setNombre(faker.name().fullName());
           client.setDireccion(faker.address().fullAddress());
           client.setTelefono(faker.phoneNumber().cellPhone());
           client.setEdad(faker.number().numberBetween(18, 100));
           client.setGenero(faker.options().option("M", "F"));
           client.setIdentificacion(faker.idNumber().valid());
           client.setEstado(faker.options().option(true, false));
           client.setContrasenna(faker.internet().password());
           client.setClienteid(2l);
           client.setId(UUID.randomUUID());

           return client;
        }

}
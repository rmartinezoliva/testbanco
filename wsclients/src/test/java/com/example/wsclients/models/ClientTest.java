package com.example.wsclients.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {


    @Test
    void testClientFields() {
        // Crear una instancia de Client
        Client client = new Client();

        // Establecer valores en los campos
        client.setClienteid(1L);
        client.setContrasenna("password123");
        client.setEstado(true);

        // Verificar que los campos se han establecido correctamente
        assertEquals(1L, client.getClienteid());
        assertEquals("password123", client.getContrasenna());
        assertTrue(client.getEstado());

        // Cambiar los valores y verificar
        client.setClienteid(2L);
        client.setContrasenna("newpassword456");
        client.setEstado(false);

        assertEquals(2L, client.getClienteid());
        assertEquals("newpassword456", client.getContrasenna());
        assertFalse(client.getEstado());
    }

}
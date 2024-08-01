# Test Banco

Este proyecto es una prueba técnica que implementa un sistema bancario básico utilizando microservicios.

## Estructura del Proyecto

El repositorio está dividido en los siguientes microservicios:

- **wsaccount**: Microservicio que maneja las operaciones relacionadas con las cuentas.
- **wsclients**: Microservicio que maneja las operaciones relacionadas con los clientes.

## Prerrequisitos

- Java 11
- Gradle
- Docker (opcional, para pruebas de integración)

## Instalación

1. Clona el repositorio:
    ```sh
    git clone https://github.com/rmartinezoliva/testbanco.git
    cd testbanco
    ```

2. Construye los microservicios con Gradle:
    ```sh
    ./gradlew build
    ```

## Ejecución

Para ejecutar los microservicios localmente:

1. Navega a cada microservicio (`wsaccount` y `wsclients`) y ejecuta:
    ```sh
    ./gradlew bootRun
    ```

## Colección de Postman

Una colección de Postman está disponible para probar los endpoints. Importa el archivo `PruebaTecnica.postman_collection.json` en Postman.



## Contribución

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -am 'Agrega nueva funcionalidad'`).
4. Sube tus cambios (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

## Licencia
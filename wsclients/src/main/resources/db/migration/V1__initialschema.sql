

CREATE TABLE client (
                               edad int4 NULL,
                               estado bool NULL,
                               clienteid bigserial NOT NULL,
                               id uuid NULL,
                               contrasenna varchar(255) NULL,
                               direccion varchar(255) NULL,
                               genero varchar(255) NULL,
                               identificacion varchar(255) NULL,
                               nombre varchar(255) NULL,
                               telefono varchar(255) NULL,
                               CONSTRAINT client_id_key UNIQUE (id),
                               CONSTRAINT client_identificacion_key UNIQUE (identificacion),
                               CONSTRAINT client_pkey PRIMARY KEY (clienteid)
);
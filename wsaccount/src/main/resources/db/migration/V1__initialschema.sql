CREATE TABLE public.account (
                                clienteid int4 NOT NULL,
                                estado bool NULL,
                                saldo_inicial float8 NULL,
                                id uuid NOT NULL,
                                cliente_nombre varchar(255) NULL,
                                entidad varchar(255) NULL,
                                numero_cuenta varchar(255) NULL,
                                tipo_cuenta varchar(255) NULL,
                                CONSTRAINT account_pkey PRIMARY KEY (id)
);





CREATE TABLE public.movement (
                                 saldo float8 NULL,
                                 valor float8 NULL,
                                 fecha timestamp(6) NULL,
                                 account_id uuid NULL,
                                 id uuid NOT NULL,
                                 entidad varchar(255) NULL,
                                 tipo_movimiento varchar(255) NULL,
                                 CONSTRAINT movement_pkey PRIMARY KEY (id)
);

ALTER TABLE public.movement ADD CONSTRAINT fkoemeananv9w9qnbcoccbl70a0 FOREIGN KEY (account_id) REFERENCES public.account(id);
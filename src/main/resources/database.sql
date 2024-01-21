-- Table: public.account

-- DROP TABLE IF EXISTS public.account;

CREATE TABLE IF NOT EXISTS public.account
(
    account_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    iban text COLLATE pg_catalog."default",
    bic_swift text COLLATE pg_catalog."default",
    client_id integer,
    CONSTRAINT account_pkey PRIMARY KEY (account_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.account
    OWNER to postgres;


-- Table: public.card

-- DROP TABLE IF EXISTS public.card;

CREATE TABLE IF NOT EXISTS public.card
(
    card_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    card_alias text COLLATE pg_catalog."default",
    account_id integer,
    card_type text COLLATE pg_catalog."default",
    CONSTRAINT card_pkey PRIMARY KEY (card_id),
    CONSTRAINT account_foreign_key FOREIGN KEY (account_id)
        REFERENCES public.account (account_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.card
    OWNER to postgres;


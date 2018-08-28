CREATE TABLE uzer
(
  id bigint NOT NULL,
  role character varying(255) NOT NULL,
  email character varying(255),
  encr_pass character varying(255) NOT NULL,
  is_telegram_notify boolean,
  login character varying(255) NOT NULL,
  telegram_id character varying(255),
  CONSTRAINT uzer_pkey PRIMARY KEY (id)
)

CREATE TABLE film
(
  id bigint NOT NULL,
  dvd_date date,
  imdb_id character varying(255),
  release_date date,
  title character varying(255),
  uzer_id bigint,
  CONSTRAINT film_pkey PRIMARY KEY (id),
  CONSTRAINT fk90pi838sqdyx1p7uop0eh5mp9 FOREIGN KEY (uzer_id)
      REFERENCES uzer (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
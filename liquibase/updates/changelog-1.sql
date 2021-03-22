--liquibase formatted sql

--changeset dmi:1
CREATE SEQUENCE global_seq START 100000 INCREMENT 100;
--changeset dmi:2
CREATE TABLE task
(
  id            BIGINT PRIMARY KEY DEFAULT nextval('global_seq'),
  name          VARCHAR(64) UNIQUE NOT NULL,
  description   VARCHAR(255),
  task_id        VARCHAR(36) UNIQUE NOT NULL,
  parent_id      VARCHAR(36)
);
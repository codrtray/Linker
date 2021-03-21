--liquibase formatted sql

--changeset dmi:1
CREATE TABLE task
(
  id            BIGINT PRIMARY KEY ,
  name          VARCHAR(64) UNIQUE NOT NULL,
  description   VARCHAR(256),
  taskId        VARCHAR(36) UNIQUE NOT NULL,
  parentId      VARCHAR(36)
);
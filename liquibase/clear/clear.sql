-- noinspection SqlWithoutWhereForFile

--liquibase formatted sql

--changeset dmi:1 runAlways:true
DROP TABLE IF EXISTS task;
--changeset dmi:2 runAlways:true
DELETE FROM databasechangelog;
--changeset dmi:3 runAlways:true
DROP SEQUENCE IF EXISTS global_seq;

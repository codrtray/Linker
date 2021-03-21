-- noinspection SqlWithoutWhereForFile

--liquibase formatted sql

--changeset dmi:1 runAlways:true
drop table task;
--changeset dmi:2 runAlways:true
delete from databasechangelog;
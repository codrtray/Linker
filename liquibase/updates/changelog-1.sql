CREATE SEQUENCE task_seq START 100000 INCREMENT 10;
CREATE TABLE task
(
  id            BIGINT PRIMARY KEY DEFAULT nextval('task_seq'),
  name          VARCHAR(64) UNIQUE NOT NULL,
  description   VARCHAR(255),
  task_id       VARCHAR(36) UNIQUE NOT NULL,
  parent_id     VARCHAR(36)
);
CREATE SEQUENCE page_seq START 100000 INCREMENT 10;
CREATE TABLE page
(
  id            BIGINT PRIMARY KEY DEFAULT nextval('page_seq'),
  page_id       VARCHAR(36),
  url           VARCHAR(2048),
  created       TIMESTAMP WITH TIME ZONE NOT NULL,
  task_id       VARCHAR(36),
  note_id       VARCHAR(36)
);

INSERT INTO task(name, description, task_id, parent_id)
VALUES ('task1', 'Mega task', '0f33845e-43aa-44e3-bf8b-a2e4c2c52479', null);
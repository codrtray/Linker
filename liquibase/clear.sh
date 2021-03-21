#!/bin/bash
echo "Start update schema by liquibase. Work dir="$PWD

#It is rollback and clear databasechangelog !!!
java -jar lib/liquibase.jar --changeLogFile=clear.sql update

echo "End of update schema"
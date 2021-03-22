#!/bin/bash
echo "Start rollback schema by liquibase. Work dir="$PWD
java -jar lib/liquibase.jar --changeLogFile=updates/changelog.yml rollback 0.0.1
echo "End of rollback schema"
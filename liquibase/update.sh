#!/bin/bash
echo "Start update schema by liquibase. Work dir="$PWD
java -jar lib/liquibase.jar --changeLogFile=updates/changelog.xml update
echo "End of update schema"

#!/bin/bash
echo "Start update schema by liquibase. Work dir="$PWD
java -jar lib/liquibase.jar update
echo "End of update schema"

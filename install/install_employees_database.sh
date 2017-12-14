#!/usr/bin/env bash
unzip test_db-master.zip
cd test_db-master/
mysql -t < employees.sql
#!/bin/bash
exec java -jar \
  -Dspring.profiles.active=local \
  ./build/libs/gradle-labs-0.0.1-SNAPSHOT.jar

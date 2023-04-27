#!/bin/bash
jar -cmvf \
  ./build/tmp/jar/MANIFEST.MF \
  ./build/libs/gradle-labs-0.0.1-SNAPSHOT.jar \
  ./build/classes/java/main/org/squidmin/gradlelabs/GradleLabsApplication.class

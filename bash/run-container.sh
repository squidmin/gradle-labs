#!/bin/bash
docker run --rm -it \
  -v $HOME/.config/gcloud:/root/.config/gcloud \
  -v $HOME/.m2:/root/.m2 \
  gradle-labs

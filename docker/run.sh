#!/bin/sh

docker network ls|grep synth-net > /dev/null || docker network create --driver bridge synth-net

docker compose up -d
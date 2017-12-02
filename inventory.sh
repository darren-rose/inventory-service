#!/bin/bash

echo $@ >> inventory.log

if [ $1 == "--list" ]; then
	curl localhost:8080/list
fi

if [ $1 == "--host" ]; then
	curl localhost:8080/host/$2
fi

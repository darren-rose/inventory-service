#!/bin/bash
echo $@ >> inventory.log
if [ $1 == "--list" ]; then
	curl $INVENTORY_HOST:$INVENTORY_PORT/hosts
fi
if [ $1 == "--host" ]; then
	curl $INVENTORY_HOST:$INVENTORY_PORT/hosts/$2
fi
#!/bin/bash
echo $@ >> inventory.log
if [ $1 == "--list" ]; then
	curl $INVENTORY_HOST:$INVENTORY_PORT/list
fi
if [ $1 == "--host" ]; then
	curl $INVENTORY_HOST:$INVENTORY_PORT/host/$2
fi
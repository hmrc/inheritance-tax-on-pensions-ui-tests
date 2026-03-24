#!/usr/bin/env bash

BROWSER=${1:-chrome}
ENVIRONMENT=${2:-IHTP UI Tests}

sbt clean -Dbrowser="${BROWSER:=chrome}" -Denvironment="${ENVIRONMENT:=local}" test testReport

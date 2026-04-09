#!/usr/bin/env bash

BROWSER=${1:-chrome}
JOURNEY=${2:-inheritance-tax-on-pensions-ui tests}

echo "Running browser tests..."
echo "=========================================="
echo "Browser:              ${BROWSER}"
echo "Env:                  local"
echo "Journey:              ${JOURNEY}"
echo "=========================================="
sbt clean -Dbrowser="${BROWSER}" -Denvironment=local "testOnly specs.* -- -n WIP" testReport

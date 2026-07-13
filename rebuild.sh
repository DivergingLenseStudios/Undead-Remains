#!/bin/bash

# This script builds everything from ground up, so don't recommend for simple code changes.
# Use this only when the mod files are not being generated properly.

set -e
set -x

echo "=== Cleaning previous builds ==="
./gradlew clean

echo "=== Generating data assets (BlockStates, Models, Loot Tables, Recipes, Tags) ==="
./gradlew runData

echo "=== Building mod jar ==="
./gradlew build

echo "=== Rebuild complete! ==="

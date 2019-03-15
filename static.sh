#!/bin/bash

( cd frontend && npm run build )
rm -r backend/src/main/resources/public/*
cp -r frontend/target/dist/* backend/src/main/resources/public

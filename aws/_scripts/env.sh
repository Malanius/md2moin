#!/usr/bin/env bash

ENV=${1}

# TODO : change to your AWS profile for specified env!
if [[ ${ENV} == "dev" ]] || [[ ${ENV} == "int" ]] ; then
    export AWS_PROFILE=ren-int
    export DEPLOY_ENV=int
else
    export AWS_PROFILE=ren-ope
    export DEPLOY_ENV=ope
fi

export OWNER=malanius.privierre
export APP_NAME=md2moin
export APP_IMAGE=md2moin-web
export APP_ENV=${ENV}

#!/usr/bin/env bash

ENV=${1}
if [[ ${ENV} == "dev" ]] || [[ ${ENV} == "int" ]] || [[ ${ENV} == "ope" ]]; then
        echo "Creating stack with ${ENV^^} configuration...";
        . ../_scripts/env.sh ${ENV}
         aws cloudformation create-stack \
            --template-body "file://beanstalk-app.yaml" \
            --stack-name "${APP_NAME}-${APP_ENV}-beanstalk-app" \
            --tags \
                "Key=Env,Value=${APP_ENV^^}" \
                "Key=tf:owner,Value=${OWNER}" \
                "Key=App,Value=${APP_NAME}" \
            --parameters \
                "ParameterKey=AppName,ParameterValue=${APP_NAME}" \
            --profile "${AWS_PROFILE}"
         if [[ ${?} -eq 0 ]]; then
            echo "Stack created."
         else
            echo "Something went wrong during stack creation!"
         fi
    else
        echo "Wrong environment specified, not executing deploy goal!"
fi

. ../_scripts/reset.sh

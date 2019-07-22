#!/usr/bin/env bash

ENV=${1}
if [[ ${ENV} == "dev" ]] || [[ ${ENV} == "int" ]] || [[ ${ENV} == "ope" ]]; then
        echo "Updating stack with ${ENV^^} configuration...";
        . ../_scripts/env.sh ${ENV}
         aws cloudformation update-stack \
            --template-body "file://deploy.yaml" \
            --stack-name "${APP_NAME}-${APP_ENV}-deploy" \
            --tags \
                "Key=Env,Value=${APP_ENV^^}" \
                "Key=tf:owner,Value=${OWNER}" \
            --parameters \
                "ParameterKey=AppName,ParameterValue=${APP_NAME}" \
                "ParameterKey=AppEnv,ParameterValue=${APP_ENV}" \
                "ParameterKey=DeployEnv,ParameterValue=${DEPLOY_ENV}" \
            --capabilities CAPABILITY_NAMED_IAM \
            --profile "${AWS_PROFILE}"
         if [[ ${?} -eq 0 ]]; then
            echo "Stack updated."
         else
            echo "Something went wrong during stack update!"
         fi
    else
        echo "Wrong environment specified, not executing update goal!"
fi

. ../_scripts/reset.sh
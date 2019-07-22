#!/usr/bin/env bash

ENV=${1}
if [[ ${ENV} == "dev" ]] || [[ ${ENV} == "int" ]] || [[ ${ENV} == "ope" ]]; then
        echo "Updating stack with ${ENV^^} configuration...";
        . ../_scripts/env.sh ${ENV}
         aws cloudformation update-stack \
            --template-body "file://beanstalk.yaml" \
            --stack-name "${APP_NAME}-${APP_ENV}-beanstalk" \
            --tags \
                "Key=Env,Value=${APP_ENV^^}" \
                "Key=tf:owner,Value=${OWNER}" \
                "Key=App,Value=${APP_NAME}" \
            --parameters \
                "ParameterKey=AppName,ParameterValue=${APP_NAME}" \
                "ParameterKey=AppEnv,ParameterValue=${APP_ENV}" \
                "ParameterKey=DeployEnv,ParameterValue=${DEPLOY_ENV}" \
                "ParameterKey=NetworkStack,ParameterValue=vpc-info" \
            --capabilities CAPABILITY_NAMED_IAM \
            --profile "${AWS_PROFILE}"
         if [[ ${?} -eq 0 ]]; then
            echo "Stack updated."
         else
            echo "Something went wrong during stack creation!"
         fi
    else
        echo "Wrong environment specified, not executing update goal!"
fi

. ../_scripts/reset.sh

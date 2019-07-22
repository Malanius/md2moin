#!/usr/bin/env bash

ENV=${1}
if [[ ${ENV} == "dev" ]] || [[ ${ENV} == "int" ]] || [[ ${ENV} == "ope" ]]; then
        . ../_scripts/env.sh ${ENV}
        echo "Tagging ECR user..."
        aws iam tag-user \
            --user-name "${APP_NAME}-${APP_ENV}-ecr" \
            --profile ${AWS_PROFILE} \
            --tags \
                Key=App,Value=${APP_NAME} \
                Key=Env,Value=${APP_ENV^^} \
                Key=tf:owner,Value=${OWNER}
        echo "Tagging user completed."
        if [[ ${?} -eq 0 ]]; then
            echo "Tags created."
        else
            echo "Something went wrong during tagging!"
        fi
    else
        echo "Wrong environment specified, not executing tag goal!"
fi

. ../_scripts/reset.sh



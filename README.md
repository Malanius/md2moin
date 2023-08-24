# MarkDown to Moin converter

This simple tool can be used to convert markdown written text to (MoinMoin)[https://moinmo.in/] wiki syntax. 

## build
Running the following will create a docker container tagged `malanius/md2moin-web:latest`:
```
mvn clean package
```
A .jar containing the application (for deployment with tomcat/catalina) resides in
```
md2moin-web/target/md2moin-web-1.0-SNAPSHOT.jar
```

## AWS

Application currently runs on AWS Elastic Beanstalk environment with Docker.

### AWS infrastructure templates

In directory `./aws`, there are CloudFormation templates required for infrastructure preparation.
All templates have scripts for creating/updating corresponding stacks. Usage is (from th directory they reside in):

```bash
. create-*.sh ${ENV}
# or
. update-*.sh ${ENV}
``` 

Where `${ENV}` is environment of the application, supported values are `dev`, `int`, `ope`.
Before using the scripts, update `_scripts/env.sh` to set correct AWS CLI profile for specified environments.

The order of creating the stacks is as follows:

1. ECR
1. Beanstalk app
1. Beanstalk env
1. Deploy

For `Beanstalk` there are some required dependencies on other templates to import value from - VPC info of VPC the Beanstalk environment is created in and bastion template from where the bastion's security group is used.

## Deploy

The project is using GitLab CI/CD pipeline to build and deploy the application to Beanstalk. Following CI/CD variables have to be set:

- proxy
  - `BUILD_PROXY_HOST` - proxy for maven
  - `BUILD_PROXY_PORT` - proxy for maven
  - `PROXY_STRING` - proxy for Docker, the concat of the previous seems not to work in the pipeline as the port number is prepended by `//`
- ECR - all values can be found in outputs of ECR stack
  - for DEV environment
    - `DEV_ECR_REPO` - name of the ECR repository
    - `DEV_ECR_ACCESS_KEY` - CLI access key of ECR user
    - `DEV_ECR_SECRET_KEY` - CLI secret access key of ECR user
  - for INT environment
    - `INT_ECR_REPO` - name of the ECR repository
    - `INT_ECR_ACCESS_KEY` - CLI access key of ECR user
    - `INT_ECR_SECRET_KEY` - CLI secret access key of ECR user
  - for OPE environment
    - `OPE_ECR_REPO` - name of the ECR repository
    - `OPE_ECR_ACCESS_KEY` - CLI access key of ECR user
    - `OPE_ECR_SECRET_KEY` - CLI secret access key of ECR user
- Beanstalk bundle upload - all values can be found in Deploy stack outputs
  - for DEV environment
    - `DEV_S3_DEPLOY` - deploy bucket name where bundle will be uploaded
    - `DEV_DEPLOY_ACCESS_KEY` - deploy user AWS CLI access key
    - `DEV_DEPLOY_SECRET_KEY` - deploy user AWS CLI secret access key
  - for INT environment
      - `INT_S3_DEPLOY` - deploy bucket name where bundle will be uploaded
      - `INT_DEPLOY_ACCESS_KEY` - deploy user AWS CLI access key
      - `INT_DEPLOY_SECRET_KEY` - deploy user AWS CLI secret access key
  - for OPE environment
      - `OPE_S3_DEPLOY` - deploy bucket name where bundle will be uploaded
      - `OPE_DEPLOY_ACCESS_KEY` - deploy user AWS CLI access key
      - `OPE_DEPLOY_SECRET_KEY` - deploy user AWS CLI secret access key
- Beanstalk deployment - all values can be found in Beanstalk and Deploy stacks outputs
  - all of the previous for bundle upload plus
  - for DEV environment
    - `DEV_EB_APP_NAME` - name of the Beanstalk application
  - for INT environment
      - `INT_EB_APP_NAME` - name of the Beanstalk application
  - for OPE environment
      - `OPE_EB_APP_NAME` - name of the Beanstalk application 

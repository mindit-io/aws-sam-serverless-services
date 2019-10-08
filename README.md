# Sample REST deployments using AWS Serverless Application Model 

[AWS SAM](https://github.com/awslabs/serverless-application-model) it's a great framework to start building [serverless applications](https://martinfowler.com/articles/serverless.html). With just a few lines of configuration, you can define the application you want and deploy it.

[AWS SAM](https://github.com/awslabs/serverless-application-model) hides all the boilerplate configurations needed if building directly using [AWS CloudFormation](https://aws.amazon.com/cloudformation/) resources and properties. 

While this is great for a quick start, it can become very quickly frustrating when you want to implement slightly more complex functionalities, such as validation, authorization, trasnformation, etc.

This repository is intended as a storage for various AWS SAM templates, covering different deploymens scenarios. 

Currently it holds sample templates for:

| Deployment Scenario | SAM AWS template |
| ------------------- | ---------------- |
| Lambda Proxy Integration | [template-lpi.yaml](template-lpi.yaml)
| Lambda Proxy Integration with HTTP catch all | [template-lpi-catch-all.yaml](template-catch-all.yaml)
| Lambda Proxy Integration with body content validation | [template-lpi-validate.yaml](template-lpi-validate.yaml)
| Lambda Custom Integration | [template-li.yaml](template-lpi.yaml)
| Lambda Custom Integration with body content validation| [template-li-validate.yaml](template-lpi.yaml)

In the future the list of sample templates will be extended with new deployment scenarios (incl transformation, authorization, etc).  

Please refer to the following AWS documentation articles in order to understand the referenced concepts:
* [Lambda Proxy Integration](https://docs.aws.amazon.com/apigateway/latest/developerguide/set-up-lambda-proxy-integrations.html#api-gateway-create-api-as-simple-proxy)
* [Lambda Custom Integration](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-getting-started-with-rest-apis.html)
* [Validation in API Gateway](https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-method-request-validation.html)


## Prerequisites 
In order to run those examples you need to have [SAM CLI](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-reference.html#serverless-sam-cli) installed and configured.

Please follow your platform specific [installation instructions](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install.html). 

Following those installations instructions you will end-up with:
* an AWS account 
* AWS / SAM CLI installed and configured locally using the above account 
* an AWS S3 bucket which will be used during the deployment process

## Deployment 

Any of the examples can be deployed using the following commands:
``` bash
sam build -t template.yaml  
sam package     --template-file template.yaml --output-template-file packaged.yaml     --s3-bucket mindit.io 
sam deploy     --template-file packaged.yaml     --stack-name api-echo     --capabilities CAPABILITY_IAM

```
where:
* **template.yaml** can be replaced with any of the sample templates file names
* **api-echo** can be replaced with any name that you want to be assigned to the deployed API  

## API Functionality

All RESTs created by the sample templates are simple echo services. In general, they return the same information that is passeed in the body request. Particular implementation details are mentioned for each scenario. 

APIs are powered by lambda functions. By default the runtime of lambda functions is **nodejs10.x**. 

If you want to run the same examples using Java, just replace in the template the following configuration:   
``` yaml
        FunctionName: echo-lpi
        CodeUri: EchoFunctionJS
        Handler: app.lambdaHandler
        Runtime: nodejs10.x
```
with:
``` yaml
        CodeUri: EchoFunction
        Handler: io.mindit.aws.handler.EchoHandler::handleRequest
        Runtime: java8
        MemorySize: 256
``` 

## Lambda Proxy Integration 
Template file: [template-lpi.yaml](template-lpi.yaml)

## Lambda Proxy Integration with HTTP catch all 
Template file: [template-lpi-catch-all.yaml](template-catch-all.yaml)

## Lambda Proxy Integration with body content validation 
Template file: [template-lpi-validate.yaml](template-lpi-validate.yaml)

## Lambda Custom Integration 
Template file: [template-li.yaml](template-lpi.yaml)

## Lambda Custom Integration with body content validation
Template file: [template-li-validate.yaml](template-lpi.yaml)
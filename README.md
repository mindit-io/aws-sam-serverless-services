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
| Lambda Integration | [template-li.yaml](template-lpi.yaml)
| Lambda Integration with body content validation| [template-li-validate.yaml](template-lpi.yaml)

In the future the list of sample templates will be extended with new deployment scenarios.  

It is recommened to understand 


## Prerequisites 



## How to deploy 
### Prerequisites 

#### AWS 

#### Bucket 

#### Deployment

Java vs JavaScript 

        FunctionName: echo-lpi
        CodeUri: EchoFunctionJS
        Handler: app.lambdaHandler
        Runtime: nodejs10.x
        # If you need a Java function (should replace in other configs as well)
        # CodeUri: EchoFunction
        # Handler: io.mindit.aws.handler.EchoHandler::handleRequest
        # Runtime: java8
        # MemorySize: 256

Deploy the stack 

sam build -t template-lpi.yaml 
sam package     --template-file template-lpi.yaml --output-template-file packaged.yaml     --s3-bucket mindit.io 
sam deploy     --template-file packaged.yaml     --stack-name echo-lpi     --capabilities CAPABILITY_IAM



Testing 

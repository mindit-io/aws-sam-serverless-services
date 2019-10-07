# aws-sam-serverless-services
Different options for implementing REST services using AWS Serverless Application Model.

## Overview 
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

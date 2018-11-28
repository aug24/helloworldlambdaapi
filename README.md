# Create a simple Hello World REST API.

## Create project
mvn archetype:generate -DgroupId=example -DartifactId=example -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

## Import Source 
https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-create-api-as-simple-proxy-for-lambda.html

## Add Maven dependencies

 * junit junit 3.8.1 (test)
 * com.googlecode.json-simple json-simple 1.1.1
 * com.amazonaws aws-lambda-java-core 1.1.0

## Add Maven shade plugin

  * org.apache.maven.plugins maven-shade-plugin 2.3

Configure to run during package phase

## Package

You should now have a example-VERSION-SHAPSHOT.jar in the target directory.

# Iterate features

## Add tests

## Implement features to fulfil tests

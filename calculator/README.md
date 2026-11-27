# Setup

New project based on https://start.jakarta.ee/

or mvn archetype

```
mvn archetype:generate
   -DarchetypeGroupId=org.eclipse.starter
   -DarchetypeArtifactId=jakarta-starter
   -DarchetypeVersion=2.7.0
   -DjakartaVersion=10
   -Dprofile=core
   -Druntime=none
   -DjavaVersion=17
   -DgroupId=de.thws
   -DartifactId=calculator
   -DinteractiveMode=false
```

Copy _war_ via CLI

    ~/devl/thws/thws-cnej2627/calculator$ cp target/calculator.war ~/devl/thws/server/wildfly/wildfly-42.0.0.Final/standalone/deployments/.

Run server

    ~/devl/thws/server/wildfly/wildfly-42.0.0.Final/bin$ ./standalone.sh

Testing URLs

- http://localhost:8080/calculator/rest/hello?name=thws
- http://localhost:8080/calculator/rest/calc

Build and run with Docker

    docker build -t calculator:v1 .
    docker run -it --rm -p 8080:8080 calculator:v1

# Hosting

## Registration at AWS

- Create AWS account
- Create AWS ECR (Container Registry)

Commands for bulding and pushing (example URLs)

```shell
mvnw clean package
docker build -t thws/calculator:v4 .
docker tag thws/calculator:v4 227331280130.dkr.ecr.eu-north-1.amazonaws.com/thws/calculator:v4
docker push 227331280130.dkr.ecr.eu-north-1.amazonaws.com/thws/calculator:v4
```

## Hetzner

https://www.hetzner.com

- Create account
- Create instance (e.g. cpx22) (e.g. ubuntu)
- Server hardening

Setup

- Install docker (https://docs.docker.com/engine/install/ubuntu/)
- Install AWS CLI
- Login to AWS
- Push & run App:  
  `docker run -d --name calculator --restart unless-stopped -p 8080:8080   227331280130.dkr.ecr.eu-north-1.amazonaws.com/thws/calculator:v4`

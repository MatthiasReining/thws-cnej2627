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

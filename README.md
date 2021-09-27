# Readme

## Pull down and install

* git clone https://gitlab.com/aceracerff/swiss-tournament.git
* cd swiss-tournament
* ```mvn install```

## Setup Test Environment

### To startup backend

* cd to swiss-tournament
* ``` mvn exec:java -Dexec.mainClass="SwissTournamentApplication" ```

### To startup frontend

* cd to src/app
* ```npm run serve```

## Build for Production

* cd to root
* ```mvn clean package```
* this creates your deployable .jar in /target
* run this .jar with ```java -jar /target/[filename].jar```

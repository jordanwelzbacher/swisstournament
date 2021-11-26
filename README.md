# Swiss Tournament .org

_Duration: Three months_

# Description

Tournament management platform. Similar examples include challonge.com, smash.gg, and tabletop.to.

Other platforms cater to specific games or platforms, or are very broad and are lacking in advanced features and configurations.
SwissTournament's niche will be a specific tournament format: Swiss! It will contain all of the necessary features and configurations for enabling any competition type to use the Swiss format: from Bocce Ball in your backyard, to large Chess, Esports, or Trading Card Game tournaments!

### Resources

This project was my first using both Vue and Spring. I found the following resources to be very helpful:

[Full Stack Java Development With Spring Boot and VueJS](https://www.danvega.dev/blog/2021/01/22/full-stack-java-vue/)\
by [Dan Vega](https://github.com/danvega)

[Vue Authentication](https://www.youtube.com/watch?v=Vd1YwbHrY1Q&list=PLfdtiltiRHWF1jqLcNO_2jWJXj9RuSDvY)\
by [Codecourse](https://www.youtube.com/channel/UCpOIUW62tnJTtpWFABxWZ8g)

[Vue JS Crash Course 2021](https://www.youtube.com/watch?v=qZXt1Aom3Cs)\
by [Brad Traversy](https://github.com/bradtraversy) / [Traversy Media](https://www.youtube.com/channel/UC29ju8bIPH5as8OGnQzwJyA)

[Spring Boot - REST API using PostgreSQL and JWT](https://www.youtube.com/watch?v=fVq9aPNGLAg&list=PLWieu6NbbqTwwYwylgXmmKVX1ZWsUVx8m)\
by [Pair Learning](https://www.youtube.com/channel/UCLCn3zEnB0h0Y2GVhTLtHkg/featured)

### Lessons Learned
- The Vuex store can be used for more than just data needed _everywhere_, I was emitting an event and passing props down two levels for some data that could have just been put in the store
- The Composition API vs Options API (Vue 2 vs Vue 3), I have "frankenstein" components using both

### Lessons Yet to Learn
- How to handle derived properties in models such that I do not need to create extra Data Transfer Objects
- More about JPA/Hibernate and how they interact directly with table relations (I do not use @OneToMany or any such similar annotation in the project, instead leaning heavier into native queries)
- More about JPA/Hibernate/Spring in general
- How I go from protecting a route to having access to a HttpServeltRequest (that contains the JWT claims) is the last piece of outstanding "magic"

### Tech Used

Vue 3\
Java | Spring Boot\
JPA | Hibernate\
PostgreSQL\
[Material Design for Bootstrap](https://mdbootstrap.com/)\
AWS Beanstalk

## Feature List

### Create Tournament

Users can create tournaments. Swiss Tournament's key feature is fully customizable Scoring & Tiebreakers.\
Additionally, the tournament can be configured to allow or prohibit player-submitted results, and to allow or prohibit open sign-up.

![Create Tournament](https://github.com/jordanwelzbacher/swisstournament/blob/main/design/create.png?raw=true)

### Participate

Users can join tournaments and enter their results (if enabled).
The platform also supports admin-only results entry, and Swiss Tournament supports this by generating printable match-slips.

![Round](https://github.com/jordanwelzbacher/swisstournament/blob/main/design/round.png?raw=true)

### Administer

The tournament owner and administrators can run a tournament by adding players & admins, creating rounds, and so on.

![Admin](https://github.com/jordanwelzbacher/swisstournament/blob/main/design/admin.png?raw=true)

# Setup & Deployment

## Prerequisits
[npm](https://www.npmjs.com/)\
[Maven](https://maven.apache.org/)\
[PostgreSQL](https://www.postgresql.org/)

## Setup
### Pull down and install

* git clone https://gitlab.com/aceracerff/swiss-tournament.git
* cd to swiss-tournament
* ```mvn install```

### Setup Test Environment

#### To startup backend

* cd to swiss-tournament
* ``` mvn exec:java -Dexec.mainClass="SwissTournamentApplication" ```

#### To startup frontend

* cd to src/app
* ```npm run serve```

#### To setup database

 * Create a new database and run the SQL from the ```swisstournament_db.sql``` file to initialize the database

 >If you want to add some dummy test data, you may optionally run the ```swisstournament_sample_data.sql``` file. This file assumes at least two user accounts already exist, so use the frontend or Postman to register 2 users before running this file.

## Build for Production

* cd to root
* ```mvn clean package```
* this creates your deployable .jar in /target
* run this .jar with ```java -jar /target/[filename].jar```
* //TODO explain environment variables


## Acknowledgements
Thanks to [Tech Elevator](https://www.techelevator.com/) and [Mary Mosman](https://github.com/mbMosman)


## License


[LICENSE TYPE](LICENSE)

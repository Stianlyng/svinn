# svinn
An online marketplace

## By: Stian Lyng Stræte
Since im a first year student, i did not know many candidates in class to collaborate on this project.
I decided to give it a try anyways, and i am glad i did. I have learned a lot during the process. 

I dedicated every waking minute this week to this project, but still i did not manage to finish all the features i wanted to implement. I ended up using H2 for the database as a result of the time constaints. 



## ER
![ER](/assets/img/ER.png?raw=true)

## Run

#### backend
- cd into backend folder
- `mvn clean install`
- `mvn spring-boot:run`

### frontend
- cd into frontend folder
- setup: `npm install`
- for development: `npm run dev`
- for production: `npm run build`
- tests: `npm run test:unit
- npm run test:e2e:dev
- linting: `npm run lint`


## H2 console
Database for development is H2. To access the console, go to:
- `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE`

## Demo

## API Documentation
- OpenAPI (json filepaths): http://localhost:8080/v3/api-docs
- Swagger UI: http://localhost:8080/swagger-ui.html

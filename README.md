# svinn
An online marketplace

## By: Stian Lyng Stræte
Since im a first year student, i did not know many candidates in class to collaborate on this project.
I decided to give it a try anyways, and i am glad i did. I have learned a lot during the process. 

## ER
![ER](/assets/img/ER.png?raw=true)

## Run
`mvn spring-boot:run`

## H2 console
Database for development is H2. To access the console, go to:
- `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE`

## Demo
- Get demo table `curl http://localhost:8080/demo/all` 
- Add demo entry: `curl -X POST -d "name=First" http://localhost:8080/demo/add`

## API Documentation
- Found inspiration on this site: https://springdoc.org/v2/
- OpenAPI description: http://localhost:8080/v3/api-docs
- Swagger UI: http://localhost:8080/swagger-ui.html

# to-do
- [ ] Tilgang til ting bare din bruker har tilgang til
- [ ] fix swagger
- [ ] CI/CD
- [ ] database i docker

# Frontend
`npm install`
`npm run format`
`npm run dev`

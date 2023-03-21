# svinn
An online marketplace

## By: Stian Lyng Stræte
Since im a first year student, i did not know many candidates in class to collaborate on this project.
I decided to give it a try anyways, and i am glad i did. I have learned a lot during the process. 

## Run
`mvn spring-boot:run`

## H2 console
Database for development is H2. To access the console, go to:
- `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE`

## Test app
- Get all users `curl http://localhost:8080/demo/all` 
- Add user: `curl -X POST -d "name=First" -d "email=first@example.com" http://localhost:8080/demo/add`

# to-do
- 
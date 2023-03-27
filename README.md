# Voluntary project in Full Stack IDATT2105 - 2023

## By: Stian Lyng Stræte
Since im a first year student, i did not know many candidates in this class (2. year) to collaborate on this project.
I decided to give it a try anyways, and i am glad i did. I have learned a lot during the process. 

I dedicated every waking minute this week to this project, but still i did not manage to finish all the features i wanted to implement. I ended up using H2 for the database as a result of the time constaints. 

The frontend is not as polished as i would like, as i had to prioritize the backend, especially the security as i think this has to be one of the most important for assesing my project. 

## missing due to time constraints:
- Alot of documentation
- More tests
- More error handling
- More validation

# Project
An online marketplace build with a Vue 3 frontend and a spring boot backend. 


### Structure
The project is structured as follows:
- backend: spring boot project
- frontend: vue 3 project
- assets: images and other assets for the readme

## Api

> NB: The JWt bearer token should be added to the header, when using postman or similar tools.
> The token is integrated in the frontend, using the pinia store and custom axios instance.

- User can create an account
    - POST: http://localhost:8080/api/v1/auth/register
    - Body: { "firstname": "donaldo", "lastname": "trump", "email": "a@b.c", "password": "pwd" }
- User can login
    - POST: http://localhost:8080/api/v1/auth/login
    - Body: { "email": "a@b.c", "password": "pwd" }
- User can create a listing
    - POST: http://localhost:8080/api/v1/items
    - Body: { "briefDescription": "title", "fullDescription": "description", "price": 100, "categoryId": 1,"locationId": 1 }
- User can view listings
    - GET: http://localhost:8080/api/v1/items
- User can view a listing he has created
    - GET: http://localhost:8080/api/v1/items/user
- User can edit a listing he has created based on the id
    - PUT: http://localhost:8080/api/v1/items/{id}
    - Body: { "briefDescription": "title", "fullDescription": "description", "price": 100, "categoryId": 1,"locationId": 1 }
- User can delete a listing he has created based on the id
    - DELETE: http://localhost:8080/api/v1/items/{id}

## Database
I used H2 for the database, as i did not have time to set up a postgres database.
The database is populated with data from the dataLoader file, which is located in the config folder.

### ER
![ER](/assets/img/ER.png?raw=true)

- Users
    - id (Primary Key)
    - firstname
    - lastname
    - email (Unique)
    - password
    - role (Enum: Normal User, Administrator)

- Categories
    - id (Primary Key)
    - name
    - description

- Locations
    - id (Primary Key)
    - name
    - latitude
    - longitude

- Items
    - id (Primary Key)
    - brief_description
    - full_description
    - category_id (Foreign Key: Categories)
    - location_id (Foreign Key: Locations)
    - price
    - user_id (Foreign Key: Users)
    - created_at
    - updated_at

- Bookmarks
    - id (Primary Key)
    - user_id (Foreign Key: Users)
    - item_id (Foreign Key: Items)

- Messages
    - id (Primary Key)
    - sender_id (Foreign Key: Users)
    - receiver_id (Foreign Key: Users)
    - item_id (Foreign Key: Items)
    - content
    - created_at

- Tokens
    - id (Primary Key)
    - token (Unique)
    - tokenType
    - revoked
    - expired
    - user_id (Foreign Key: Users)

Relationships

- Users (1) - (Many) Items: One user can list many items.
- Users (1) - (Many) Bookmarks: One user can bookmark many items.
- Users (1) - (Many) Messages (Sender): One user can send many messages.
- Users (1) - (Many) Messages (Receiver): One user can receive many messages.
- Users (1) - (Many) Tokens: One user can have many tokens.
- Categories (1) - (Many) Items: One category can have many items.
- Locations (1) - (Many) Items: One location can have many items.
- Items (1) - (Many) Bookmarks: One item can be bookmarked by many users.
- Items (1) - (Many) Messages: One item can have many associated messages.

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

## Sources
Places of inspiration for my code:
- https://www.vuemastery.com
- Material from the course (Blackboard)
- https://www.youtube.com/watch?v=KxqlJblhzfI&t=5984s
- https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/
- stackoverflow, github, google, etc.
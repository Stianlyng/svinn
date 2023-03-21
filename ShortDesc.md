# Semester Project - 2023
## IDATT2105 Full-stack application development

The requirement is to implement a full-stack web application including  
- A frontend using Vuejs (v3) related framework and libraries
- A backend using Java (v17) and Spring boot framework (v3) / Spring framework (v5 (or v6))  
- A database using MySQL (v8) and/or H2  

# General Requirements
## Technical requirements  
1. Clean CSS. No use of CSS frameworks like Tailwind
2. Spring Boot/REST based backend. Each endpoint should have proper authentication/authorization, 
	1. for example based on JWT and Spring Security.  
3. Database communication using plain JDBC or Spring JDBC / JPA  
4. The solution should contain tests. The code coverage shall be at least 50%  
5. The group should make sure to use CI/CD during development.  
6. OWASP and universal design principles/techniques should be used in the project  
7. Session storage can be used to provide short-lived login session on the frontend  
## Documentations requirements (for each module)
1. End points (API) must be documented, for example, using Swagger. Note, an explanation of what the endpoints do and what the different attributes are is required. In addition, code must be documented as usual (javadoc).
2. System documentation is also a requirement., i.e., documentation that enables a new developer to quickly get the project up and running for testing and further development (architecture sketches/class diagram). Instructions for how to run the project can preferably be done as a README file, while other documentation should be as a PDF.
3. Test data that can be used while testing the app, for example, test user credentials,database credentials, etc.
4. The prerequisites must be documented if the project/module is dependent on other projects

# Product requirements / features

The product is an e-commerce marketplace like web application where sellers can list their items and potential buyers can browse the items using various filter mechanisms, can add items into their favorite lists, and can check out and buy items!

**Take inspirations from the following sites**
• https://letsdeal.no/
• https://www.finn.no/
• Or any other comparable sites you are aware of

The layout and design of user-interface elements such as screens is open-ended and it ́s up to each individual group's creativity. However, UI screens should be designed such that they are mobile devices friendly in terms of size, pagination and scroll ability.
In addition, the application shall have the following features:
1. Listing of items on the main page can be done in scrollable, paginated, and thumbnail (default) view or map view.
	1. A frontend shall have support for multiple sizes of item thumbnails such as full width, half-width, quarter-width, double-height, etc.
	2. The frontend should retrieve items from the backend using APIs
	3. The backend shall provide APIs for adding, getting, updating, deleting such items.
	4. The backend APIs should be documented with Swagger.
2. Listed items can be filtered based on, for example, categories, locations etc.
3. Items can be searched based on item descriptions, locations, categories etc.
4. An item can have the following properties – id, brief description, full description, category, location (latitude, longitude), price, etc.
5. Upon clicking an icon thumbnail or map marker, an item details page shall be shown. In item details page,
	1. Shall include information about the item such as item description, price, location, contact information of the seller and so on.
	2. Shall include pictures gallery of the related item.
	3. Shall allow the logged-in user to bookmark the item, for example by clicking the bookmark logo displayed on the top-right corner of the items page.
	4. Shall allow the logged-in user able to contact the user who posted the item, for example via message inbox/dialogue.
6. The application (frontend) supports internationalization, i.e., supports multiple languages based on language settings on the browser
7. Users shall be
	1. able to register themselves,
	2. able to edit their profile including credentials
8. There will be two types of user roles
	1. Normal user - can list, buy/sell items, etc.
	2. Administrator – can add/update/modify categories, can do other administrative actions
9. A logged in user(s)
	1. can add new items, can update, delete, archive own listed items only
	2. can add items into their favorite or bookmarked list.
	3. can negotiate price on a listed item
	4. can buy an item listed by other users
10. The application shall have a main menu towards top of the screen with relevant menu items
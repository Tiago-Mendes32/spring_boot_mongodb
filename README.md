---Spring MongoDB Project Readme---

Overview
This project is a Spring Boot application that interacts with a MongoDB database to manage users and their associated posts. The application provides RESTful APIs for performing CRUD operations on users and posts.

Prerequisites
Before running the application, make sure to have the following software installed:

Java Development Kit (JDK)
MongoDB
Configure MongoDB connection settings in the application.properties or application.yml file.

Project Structure
The project is organized into two main packages: com.legacy.spring_mongo.resources and com.legacy.spring_mongo.services.

com.legacy.spring_mongo.resources
This package contains RESTful controllers that handle HTTP requests and define the API endpoints. There are two controllers:

PostResource: Manages operations related to posts, including creation, retrieval, deletion, and searches.
UserResource: Manages operations related to users, including creation, retrieval, deletion, updating, and fetching user posts.
com.legacy.spring_mongo.services
This package contains service classes that handle business logic and interact with the MongoDB database. There are two services:

PostService: Provides methods for CRUD operations and searches related to posts.
UserService: Provides methods for CRUD operations related to users, including user-to-DTO conversion.

API Endpoints:
PostResource
GET /posts: Retrieve all posts.
GET /posts/{id}: Retrieve a specific post by ID.
POST /posts: Create a new post.
DELETE /posts/{id}: Delete a post by ID.
GET /posts/titlesearch?text={text}: Search posts by title.
GET /posts/fullsearch?text={text}&minDate={minDate}&maxDate={maxDate}: Perform a full search on posts based on text, minimum date, and maximum date.

UserResource
GET /users: Retrieve all users.
GET /users/{id}: Retrieve a specific user by ID.
POST /users: Create a new user.
DELETE /users/{id}: Delete a user by ID.
PUT /users/{id}: Update a user by ID.
GET /users/{id}/posts: Retrieve posts associated with a specific user.

Author: Tiago Mendes de Góes

# Spring Boot REST API

This repository contains a Spring Boot REST API with a Model, Controller, and Repository. The API is built using Maven.

Getting Started
To get started, you'll need to have Java 11 and Maven installed on your machine.

1. Clone this repository using git clone https://github.com/melekch14/spring-boot-rest-api.git.

2. Open a terminal window and navigate to the root directory of the project.

3. Run mvn spring-boot:run to start the application.

4. Once the application has started, you can access it at http://localhost:8080.

# API Endpoints
The API has the following endpoints:

GET /person/findall
Returns a list of all models.

GET /person/findbyid/{id}
Returns a specific model by ID.

POST /person/add
Creates a new model.

PUT /person/update/{id}
Updates an existing model by ID.

DELETE /person/delete/{id}
Deletes a model by ID.

# Model
The Model class represents the data that the API works with. It is defined in the Person.java file.

# Controller
The Controller class handles incoming HTTP requests and returns HTTP responses. It is defined in the PersonController.java file.

# Repository
The Repository class is responsible for interacting with the database. It is defined in the PersonRepository.java file.

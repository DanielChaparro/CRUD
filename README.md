
# CRUD

This is a CRUD application developed in Spring v2.7.11 using Java 11. The entity used in the application is "Client" and it has attributes such as name, lastname, identification, email, and birthdate. The application is also related to "User" and "Role" entities.

The application uses Liquibase to manage database schema changes and the H2 database for data storage. The Swagger documentation for the API is available at http://localhost:8080/swagger-ui/index.html.

In case Liquibase fails to persist the initial information, there is an import.sql file that contains all the necessary information for the application to work correctly.

#### Requirements
* Java 11
* Maven v2.7.11
### Setup

* Clone the repository to your local machine.
* In the project directory, run the command mvn spring-boot:run.
* Open http://localhost:8080/swagger-ui/index.html in your browser to view the API documentation.
### API Endpoints
The following endpoints are available for the Client entity:

* GET /clients - Returns a list of all clients.
* GET /clients/{id} - Returns the client with the specified ID.
* POST /clients - Creates a new client.
* PUT /clients/{id} - Updates an existing client.
* DELETE /clients/{id} - Deletes the client with the specified ID.
### Database
The H2 database is used for data storage. The schema is managed using Liquibase. The import.sql file contains initial data to be loaded into the database.

##Issues and Contributions
If you find any issues or want to contribute to the project, please open an issue or create a pull request on the GitHub repository.

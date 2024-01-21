# Account and Card API 

## Prerequisites

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html) installed
- [Maven](https://maven.apache.org/download.cgi) installed
- [PostgreSQL](https://www.postgresql.org/download/) database server installed and running

## Setup

1. Clone the repository:

- git clone <repository-url>
- cd <repository-directory>

2. Configure the application: 
- Create the database schema on `src/main/resources/database.sql` on your PostgreSQL database server.
- Open `src/main/resources/application.properties` and update the database connection properties as needed.

3. Build and run the application: 
- `mvn spring-boot:run`

4. Access:
- The application will be accessible at `http://localhost:8080`

## API Documentation

- To access the swagger documentation, please open ```http://localhost:8080/swagger-ui.html```


## API Endpoints

### Account API

#### Retrieve all accounts:
- curl -X GET http://localhost:8080/accounts

#### Create a new account:
- curl -X POST -H "Content-Type: application/json" -d ```{"iban":"DE89370400440532013000","bicSwift":"COBADEFF","clientId":1}``` http://localhost:8080/accounts

#### Update an account:
- curl -X PUT -H "Content-Type: application/json" -d ```{"iban":"Updated Iban"}``` http://localhost:8080/accounts/1

#### Delete an account:
- curl -X DELETE http://localhost:8080/accounts/1

#### Retrieve details of a specific account: 
- curl -X GET http://localhost:8080/accounts/1




### Card API

#### Retrieve all cards:
- curl -X GET http://localhost:8080/cards

#### Create a new card:

- curl -X POST -H "Content-Type: application/json" -d ```{"cardAlias":"My New Card","accountId":1,"cardType":"physical"}``` http://localhost:8080/cards

#### Delete a card:

- curl -X DELETE http://localhost:8080/cards/1

#### Retrieve all cards associated with an account:

- curl -X GET http://localhost:8080/cards/account/1
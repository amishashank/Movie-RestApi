# Movie-RestApi

```markdown
# Movie Rest API

A simple Movie Rest API built using Java and Spring Boot that allows users to perform basic CRUD (Create, Read, Update, Delete) operations on movie data.

## Features

- **Add a new movie**: Allows users to add a new movie to the database.
- **Get all movies**: Retrieves a list of all movies available in the database.
- **Get a movie by ID**: Retrieves a movie by its unique ID.
- **Update a movie**: Allows users to update the details of an existing movie.
- **Delete a movie**: Removes a movie from the database.

## Technologies Used

- **Java**: Programming language used for backend development.
- **Spring Boot**: Framework used for building the REST API.
- **Spring Data JPA**: Used for interacting with the database.
- **H2 Database**: In-memory database for testing.
- **Maven**: Dependency management and build automation.

## Setup and Installation

### Prerequisites

- **JDK 8+**
- **Maven**

### Clone the repository

```bash
git clone https://github.com/amishashank/Movie-RestApi.git
```

### Build and Run the Application

1. Navigate to the project directory:

```bash
cd Movie-RestApi
```

2. Build the project using Maven:

```bash
mvn clean install
```

3. Run the application:

```bash
mvn spring-boot:run
```

### Access the API

The API will be accessible at:

- **Base URL**: `http://localhost:8080`

### Endpoints

#### 1. Create a new movie

- **URL**: `/movies`
- **Method**: `POST`
- **Body**: JSON containing movie details
  ```json
  {
    "name": "Inception",
    "genre": "Sci-Fi",
    "rating": 8.8
  }
  ```

#### 2. Get all movies

- **URL**: `/movies`
- **Method**: `GET`

#### 3. Get a movie by ID

- **URL**: `/movies/{id}`
- **Method**: `GET`

#### 4. Update a movie

- **URL**: `/movies/{id}`
- **Method**: `PUT`
- **Body**: JSON with updated movie details
  ```json
  {
    "name": "Inception",
    "genre": "Sci-Fi, Thriller",
    "rating": 9.0
  }
  ```

#### 5. Delete a movie

- **URL**: `/movies/{id}`
- **Method**: `DELETE`

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Spring Boot for providing a simple and effective framework for building REST APIs.
- H2 Database for easy in-memory testing.

```

Feel free to adjust the content based on your project specifics and add any additional details!

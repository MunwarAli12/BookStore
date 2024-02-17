
# BookStore Application

- Developed a REST API book application that efficiently manages book data, encompassing four key parameters: book ID, author name, pages of book and title.The application seamlessly integrates CRUD (Create, Read, Update, Delete) operations, providing a streamlined approach to handling HTTP requests.

- Utilizing MongoDB as the database backend, the application ensures smooth execution of all operations. It consistently delivers appropriate HTTP status codes and responses to clients,ensuring robustness and efficiency in managing and manipulating server objects via the REST API.


##  tech Stack
- `Backend Framework:` `Spring Boot`
- `Databases:` `MongoDb, MySQL`
- `Tools:` `Postman` `VsCode`
- 

## API Endpoints
```bash
Crud Operator- http://localhost:8080/
```

| Method   | Endpoint              | Description              |
|----------|-----------------------|--------------------------|
| `GET`    | `/api/books`          | Retrieve all books.      |
| `GET`    | `/api/books/{id}`     | Retrieve a book by ID.   |
| `POST`   | `/api/books`          | Add a new book.          |
| `PUT`    | `/api/books/{id}`     | Update an existing book. |
| `DELETE` | `/api/books/{id}`     | Remove a book.           |

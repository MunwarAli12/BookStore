
# BookStore Application

 Developed a REST API book backend application that efficiently manages book data, encompassing four key parameters: book ID, author name, pages of book and title.The application seamlessly integrates CRUD 
 (Create, Read, Update, Delete) operations, providing a streamlined approach to handling HTTP requests.

 Utilizing MongoDB as the database backend, the application ensures smooth execution of all operations. It consistently delivers appropriate HTTP status codes and responses to clients,ensuring robustness and 
 efficiency in managing and manipulating server objects via the REST API.

## Tech Stack

- `Backend Framework:` `Spring Boot`
- `Databases:` `MongoDb` `MySQL`
- `Tools:` `Postman` `VsCode`

### API Endpoints

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


##### @PostMapping Example Response and Output,
```javascript
POST http://localhost:8080/api/book
{
  "id":7887,
  "title":"Hp",
  "author": "beep",
  "pages": 780
} 
```
```javascript
Status: 201 Created Size: 19 Bytes Time: 9 ms
Hurray! Book saved!
```

##### @GetMapping  Example Response and Output for All Saved Books In Database,
``` javascript
GET http://localhost:8080/api/books
```
```javascript
Status: 200k Size: 245 Bytes Time: 19 ms
Hurray! Book saved!
[
  {
    "id": 80,
    "title": "munwa88r ali",
    "author": "Na savu nenu sasta ",
    "pages": 2022
  },
  {
    "id": 78,
    "title": "asli jod",
    "author": null,
    "pages": 0
  },
  {
    "id": 787,
    "title": "asli jod",
    "author": "hussain",
    "pages": 780
  },
  {
    "id": 7887,
    "title": "Hp",
    "author": "beep",
    "pages": 780
  }
]
```

##### @GetMapping  Example Response and Output for using Id ,
``` javascript
GET http://localhost:8080/api/books/7887
```
```javascript
Status: 200 OK Size: 52 Bytes Time: 7 ms
{
  "id": 7887,
  "title": "Hp",
  "author": "beep",
  "pages": 780
}
```

##### @DeleteMappingg Example Response and Output,

```javascript
DELETE http://localhost:8080/api/books/{id} eg:id-787,
{
  "id":787,
  "title": "asli jod",
  "author": "hussain",
  "pages": 780
 }
```
```javascript
Status: 200 OK Size: 38 Bytes Time: 6 ms
Book with ID 787 deleted successfully!
```

##### @PutMapping Example Response and Output,

```javascript
PUT http://localhost:8080/api/books/{id} eg:id-80,
{
    "id": "80",
    "title": "The Courage",
    "author": "Munwar Ali",
    "pages": 202
  }

```
```javascript
Status: 200 OK Size: 37 Bytes Time: 11 ms
Book with ID 80 updated successfully!
```

## NOTE
> For testing purposes, Postman was employed to interact with the API. The operations underwent testing utilizing the endpoints hosted at `localhost:/8080/...`.
> Snippets of each operation are available for reference at the following link: [Click Here](https://github.com/MunwarAli12/BookStore/tree/main/output%20images).




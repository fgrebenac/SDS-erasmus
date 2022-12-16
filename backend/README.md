# Api documentation
## Users
### Models
AppUser(
    id: UUID,
    first_name: String,
    last_name: String,
    email: String,
    password: String
)

RegistrationBody(
    firstName: String,
    lastName: String,
    email: String,
    password: String
)

LoginBody(
    email: String,
    password: String
)

### Endpoints
- GET /users
- GET /users/{id} 
- PUT /users/{id}
- DELETE /users/{id}
- POST /users -> send RegistrationBody
- POST /users/log-in -> send LoginBody

## Threads
### Models
Thread(
    id: UUID,
    title: String,
    content: String
)

### Endpoints
- GET /threads
- GET /threads/{id}
- PUT /threads/{id}
- DELETE /threads/{id}
- POST /threads
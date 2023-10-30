# SpringBoot-Project
<hr>

Simple project to learn Spring Boot<br>

Goals:
- Setup PSQL database to store Students
- Develop RESTful endpoint to manage records

Endpoints:
- /api/v1/student
    - GET
        - Returns JSON of all Students in the database
    - POST
        - Accepts JSON body of new student to be added
- /api/v1/student/{studentId}
    - PUT
        - Updates student record at the provided ID
        - PARAMS
            - name=String
            - email=String
            - dob=String
    - DELETE
        - Deletes Student record at the provided ID

Example POST Body:
```json
{
  "name": "student name",
  "email": "student.email@email.com",
  "dob": "1991-05-01"
}
```
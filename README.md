# Academy Server
<hr>

Simple project to learn Spring Boot<br>

Goals:
- Setup PSQL database to store Students and Faculty
- Develop RESTful endpoint to manage records

Endpoints:
- /api/v1/student
    - GET
        - Returns JSON of all Students in the database
    - POST
        - Accepts JSON body of new student to be added
- /api/v1/student/{studentId}
    - GET
        - Return single student by provided ID
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

- /api/v1/faculty
    - GET
        - Returns JSON of all Faculty in the database
    - POST
        - Accepts JSON body of new faculty to be added
- /api/v1/faculty/{facultyId}
    - GET
        - Return single faculty by provided ID
    - PUT
        - Updates faculty record at the provided ID
        - PARAMS
            - name=String
            - department=String
            - position=String
            - manager=String
            - email=String
            - dob=String
    - DELETE
        - Deletes faculty record at the provided ID

Example POST Body:
```json
{
  "name": "faculty name",
  "department": "department name",
  "position": "new position",
  "manager": "updated manager",
  "email": "student.email@email.com",
  "dob": "1982-07-11"
}
```
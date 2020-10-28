# Back-End Assessment

### 5. How to Use

Dependencies: Spring, Maven, Java 11

To run locally, have the local port 9000 free for use.

Make sure you have the necessary dependencies and use:
`./mvnw spring-boot:run`


### API Calls

GET http://localhost:9000/api/v0/clinic/doctors


GET http://localhost:9000/api/v0/clinic/doctors/1/availabilities?start=2020-10-27&end=2020-11-01


POST http://localhost:9000/api/v0/clinic/appointment HTTP/1.1
content-type: application/json

{
    "appointmentId": 2,
    "doctorId": 1,
    "patientId": 2
}

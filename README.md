# Blogging Application (with Spring Boot)

## About the project
Application made using:\
 <i><b>Java 17,\
  Spring Boot v3.4.1,\
   Spring Web,\
    Spring Data JPA,\
      H2-in-memory-database,\
       Lombok,\
       MapStruct,\
        Gradle</b></i>.

## How to use

<b>For interacting with application one can use <i>a browser</i></b> or Postman.

By default, application uses Tomcat which listening on port: 9000,
means you can reach it if run on a local machine by hitting URL http://localhost:9000.

For reach H2 use URL http://localhost:9000/h2-console \
user: admin \
pass: password

Implemented API:
1. Create new blog article - GET http://localhost:9000/articles/new?accountId={accountId} \
body:
```
   {
   "title": "PDF12",
   "content":"File.pdf",
   "imageFilePath":"4ffc034a-da49-4045-96c7-b710d621271a"
   }
```
2. Get blog article by id - GET http://localhost:9000/articles/{id}
3. Get all account articles - GET  http://localhost:9000/articles?accountId={accountId}
4. Update blog article - \
PATCH http://localhost:9000/articles/{id}/update?accountId={accountId} \
   body:
```
   {
  "title": "XLS",
  "content":"File.tmp",
  "imageFilePath":"4ffc034a-da49-4045-96c7-b710d621271a"
    }
```
5. Delete blog article - DELETE http://localhost:9000/articles/{id}/delete
6. Get all caaount articles after creat-date - \
GET http://localhost:9000/articles/filter?accountId={accountId}&createdAfter=2025-01-05
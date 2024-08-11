## role-editor-backend

This Project depicts a simple CRUD operation 
which is being maintained in Mongo DB. This is the backend layer of the [role-editor-ui](https://github.com/soumyabrata09/role-editor-ui.git)

**Pre-Requisite**
- Maven in local
- JDK 17/21
- Mongo DB Atlas account( if hosting )
- Mongo DB Compass

Execute `mvn clean -e compile install`

Execute `mvn -e spring-boot: run`

After running the application go
> http://localhost:8081/api/v1/swagger-ui.html

> API-Doc: http://localhost:8081/api/v1/v3/api-docs.yaml

_Action Item_
- [x] Implement Swagger
- [x] Mongo DB server hosting
- [ ] Application Hosting

[Guidance to write well-formatted readme file](https://docs.github.com/en/github/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax)

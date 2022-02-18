# Schedule-Service

The purpose of this service is to expose a CRUD to access to schedule information about Courses and Students.

# Solution:

 - technologies/dependencies: Kotlin, Web, Validation, Jpa, H2
 
 
 - arquitecture: multi-layered architecture, which implements a generic CRUD, adding common operations as interfaces with implemented code to share between different entities
 
    This generic architecture is also used for the service layer, and for the repository layer.
 
    Also, a DTO layer is used to separate the views from the model, and mappers are implemented to transform these objects.
 
    Implementing all this architecture, the only remaining methods to implement in the child services are "View all Students assigned to a Courses | View all Courses assigned to a Student"
    
    Exceptions were also handled with the help of @RestControllerAdvice
 
    some unit tests were added, with more time integration tests could be added

# Execution instructions:

you can view the postman collection documentation from here https://documenter.getpostman.com/view/14479214/UVkjvcm8




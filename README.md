# Java Assignment

Project is divided into three projects.

1. File Loader Daemon
2. Task Assignment Service
3. REST API

1. File Loader Daemon
    This solution is responsible of loading files from certain location, parse it and then 
    insert it into db.

2. Task Assignment Service
    This solution is responsible of pushing TeamTask data into REST API.

3. REST API
    A simple CRUD REST Api to insert/update/delete/update Task Assignment data.


* There are two threads running to read file and push that file to REST API running on localhost:8080
* Log4j is used to log all the flow
* App has some unit tests


## Project Structure

Each project is divided into three layers at most.

1. Service
    This layer takes care of all the ORM request, I made this layer on top of DAO to make it more flexible and open for 
    extension for different ORM i-e: Other than just JPA we can use Spring Data also.
2. DAO
    A simple data access layer to talk to My SQL server.
3. Controller
    LoaderDaemonController initiated all Database call.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Springboot](https://spring.io/projects/spring-boot) - Used to create REST API

## Authors

* **Minhaj Siddiqui** - *Initial work* - [PurpleBooth](http://www.minhajsiddiqui.com) 

Note: Site may experience some issue on google chrome but by scrolling to bottom makes everything works fine
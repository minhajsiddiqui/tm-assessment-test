# Java Assignment

Project is divided into three projects.

1. File Loader Daemon
2. Task Assignment Service
3. REST API

* File Loader Daemon
    This solution is responsible of loading files from certain location, parse it and then 
    insert it into db.

* Task Assignment Service
    This solution is responsible of pushing TeamTask data into REST API.

* REST API
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
4. assignment-rest-api contains REST API    

* TeamTaskServiceImpl is taking care of task assignment. 

## Steps to run

1. Before running this app, you must run the following sql script to initiate the DB Schema

CREATE USER 'dbadmin'@'localhost' IDENTIFIED BY 'tmuseR$12345'

CREATE TABLE task( task_id VARCHAR(20) NOT NULL PRIMARY KEY, skill VARCHAR(20) NOT NULL); 

CREATE TABLE team(team_id VARCHAR(20) NOT NULL PRIMARY KEY NOT NULL);

CREATE TABLE teamSkill(team_skill_id INT UNSIGNED NOT NULL PRIMARY KEY, team_id VARCHAR(20) NOT NULL, skill VARCHAR(20) NOT NULL);

CREATE TABLE assignment_result(id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, team_id VARCHAR(20) NOT NULL, task_id VARCHAR(20) NOT NULL);


NOTE: Make sure to provide all the privilages to user accessing your db, a sample script can be as following.

GRANT ALL PRIVILEGES ON teamDb.task TO 'dbadmin'@'localhost' IDENTIFIED BY 'tmuseR$12345';

GRANT ALL PRIVILEGES ON teamDb.team TO 'dbadmin'@'localhost' IDENTIFIED BY 'tmuseR$12345';

GRANT ALL PRIVILEGES ON teamDb.teamTask TO 'dbadmin'@'localhost' IDENTIFIED BY 'tmuseR$12345';

GRANT ALL PRIVILEGES ON teamDb.assignment_result TO 'dbadmin'@'localhost' IDENTIFIED BY 'tmuseR$12345';

2. Run Spring boot app from folder "./tm-assignment-restapi" to insert Team Task data in assignment_result.

Note:
Right now only Post mapping works to justify the docs of java test assessment.

3. Java Loader Daemon and Assignment Task service must be configured in order to run this application.
    This configuration is required to make this application more flexible and ready to be used in any envionrment.
    * Make sure to replace correct path according to your OS for those 3 files required to be watched once 
      copied in that folder i-e: go to config.properties and change 
      file_daemon_path=/home/{usr_name}/Documents/{tm-assessment-files} ==> to your path 
    * Make sure to replace correct path for log
      log4j.appender.file.File=/home/{user_name}/Documents/{tm-assessment-files}/log4j-application.log

NOTE: 
ALWAYS use same file name as mentioned in "/Constants.java" class.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Springboot](https://spring.io/projects/spring-boot) - Used to create REST API

## Author

* **Minhaj Siddiqui** - *JAVA Test* - [Minhaj Siddiqui Website](http://www.minhajsiddiqui.com)
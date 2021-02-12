Coverage: 34%
# Project Title: Inventory Management System

This project is an inventory management system. It contains functionality to allow users to create, update, read and delete (CRUD) customer details, items and orders in an SQL database (called IMS). This application also allows items to be added and removed from the orders. It is simple to use and connects via JDBC to a local instance of MySQL. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
Command Prompt- accessible from Windows Search Bar
Git Bash - download https://gitforwindows.org/
MySQL Workbench (for a local instance of the SQL database) - download https://www.mysql.com/products/workbench/
Eclipse- download https://www.eclipse.org/downloads/
```

### Installing

1) Open up Command Prompt this can be accessed using the windows search bar. Alternativley, You can press Win + R, then type cmd.exe into the Run field.
2) Clone this repository into an empty folder using git bash. 
Type Git init (to initalise git in this folder)
Type Git clone https://github.com/k-mccalla/Project-work.git
This should now have cloned the repository into your folder.

3) Navigate to the root folder (where git is located) using cd in command prompt. Alternativley navigate to the location of the folder you just cloned and right click and select git bash here.

For example type cd followed by the location:

cd c:\Users\....

4) Use the command dir to see all the directory.

5) Run the Java File in command prompt. 
For example:
$ java -jar ims-0.0.1-jar-with-dependencies.jar

6) Once intialised you can use the Inventory Managment System. Follow the on screen instructions. 
Start by typing and entering
CUSTOMER
ITEMS
ORDERS


## Running the tests


### Unit Tests 

This application uses JUnit testing. 

There are tests for each package.
1)Domain
2)DAO
3)Controller

Run Eclipse.
Each test aims to test the individual properties of each package. These include testing to see if the methods in the test equal a certain value. 

Navigate to the testing folder (src/test/java). Right click and select coverage as and select 2.JUnitTesting.
It should open a new window in eclipse that shows testing and coverage. 


### Integration Tests 



## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Eclipse](https://www.eclipse.org/downloads/)- Building the Java application. Version 4.18.0
* [MySQL Workbench](https://www.mysql.com/products/workbench/)- Building the SQL database with a local instance. Version 8.0
* [SonarCube](https://www.sonarqube.org/downloads/) - For code quality testing


## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
**Katie McCalla** - *Following work* - [k-mccalla](https://github.com/k-mccalla) 

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments


*Used the inital code in IMS Starter project as a foundation. 

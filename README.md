# Course Match Daddy
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## Front-End (Android) Development Technologies
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

## Back-End (Web) Development Technologies [Coming Soon]
![Node.js](https://img.shields.io/badge/Node.js-339933?style=for-the-badge&logo=nodedotjs&logoColor=white)
![Express.js](https://img.shields.io/badge/Express.js-000000?style=for-the-badge&logo=express&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Sequelize ORM](https://img.shields.io/badge/Sequelize-52B0E7?style=for-the-badge&logo=Sequelize&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)
![Apollo-GraphQL](https://img.shields.io/badge/-ApolloGraphQL-311C87?style=for-the-badge&logo=apollo-graphql)
![React](https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB)
![Jest](https://img.shields.io/badge/Jest-C21325?style=for-the-badge&logo=jest&logoColor=white)
![Heroku](https://img.shields.io/badge/Heroku-430098?style=for-the-badge&logo=heroku&logoColor=white)
![Flask](https://img.shields.io/badge/flask-%23000.svg?style=for-the-badge&logo=flask&logoColor=white)

## Data Engineering, Analytics, and Science Technologies [Coming Soon]
![Python](https://img.shields.io/badge/python-3670A0?style=for-the-badge&logo=python&logoColor=ffdd54)
![Jupyter Notebook](https://img.shields.io/badge/jupyter-%23FA0F00.svg?style=for-the-badge&logo=jupyter&logoColor=white)
![Numpy](https://img.shields.io/badge/Numpy-777BB4?style=for-the-badge&logo=numpy&logoColor=white)
![Pandas](https://img.shields.io/badge/pandas-%23150458.svg?style=for-the-badge&logo=pandas&logoColor=white)
![Matplotlib](https://img.shields.io/badge/Matplotlib-%23ffffff.svg?style=for-the-badge&logo=Matplotlib&logoColor=black)
![scikit-learn](https://img.shields.io/badge/scikit--learn-%23F7931E.svg?style=for-the-badge&logo=scikit-learn&logoColor=white)
![Spark](https://img.shields.io/badge/Apache_Spark-FFFFFF?style=for-the-badge&logo=apachespark&logoColor=#E35A16)
_____

<a name="description"></a>
## Description
Our software application’s domain is a course-matching application for students. Specifically, our application aims to match University of Toronto students with courses and programs based on students’ academic histories, preferences, and desired learning outcomes. We hope to streamline students’ course- and program-selection processes to reduce their cognitive load of navigating an overwhelming breadth and depth of the course and program offerings at the University of Toronto.

_____

<a name="web-app-link"></a>
**Design Document**: [Coming Soon]

**GitHub Repository Link**: https://github.com/CSC207-2023Y-UofT/course-project-course-match-daddy

**GitHub Project Board Link**: https://github.com/orgs/CSC207-2023Y-UofT/projects/1

**Web Application Link**: [Coming Soon]

**(Google Slides) Presentation Link**: [Coming Soon]

_____

## Table of Contents
* [General Information](#info)
* [Team, Roles, and Contributions](#team-roles-and-contributions)
* [GitHub Repository Specifications](#github)
* [Android Software Application Specifications](#android)
* [Database Specifications](#database)
* [Machine Learning Model Specifications](#machine-learning-model)
* [Installation](#installation)
* [Usage](#usage)
* [Features](#features)
* [Testing](#testing)
* [External Contributions](#contributions)
* [Questions](#questions)
* [License](#license)
* [Project Reflection](#reflection)

_____

<a name="info"></a>
## General Information
### Software Specification
First, the user will create an account using a provided (valid) email address and password. The creation of an account ensures that user-generated data within the application can persist beyond the user’s current application usage session. Additionally, the user can also view course reviews written by other users of the application.

Next, the user will complete a brief survey specifying their academic history, preferences, and desired learning outcomes in order to streamline course and program recommendations for them. Once the user has completed the survey, the user will be presented with a carousel of course cards that may be of interest to the user; a graphic representation of the course’s content, a text-based description, and course-related metadata will be viewable to the user. If the user is interested in taking the course that is currently in view, the user may swipe right on the course’s card; otherwise, the user can discard the course recommendation by swiping left on the course’s card.

Lastly, the tabs at the bottom of the application will begin to populate with academic recommendations for the user. For example, ‘Courses’ and ‘Programs’ tabs will specify recommended courses and programs, respectively, that the user has saved or are most congruent with the user’s indicated courses of interest. Courses and programs within these tabs may be selected to view additional information about them including course reviews. Moreover, the user may also manually adjust previously-specified course recommendation preferences within a ‘Settings’ tab.

### User Stories
1. As a user, I want to be able to create an account so that my application-related metadata persists between application usage sessions. 
2. As a user, I want to be able to complete an initial survey that briefly specifies my academic history, preferences, and desired learning outcomes so that I may streamline course and program recommendations for me.
3. As a user, upon completion of the initial survey, I want to be able to view a carousel of recommended course cards for me that I may swipe right on to indicate interest in the course or swipe left to indicate disinterest in the course so that I can receive relevant course and program recommendations.
4. As a user, I want to be able to select a course’s card to view its content, text-based description, and related metadata so that I can learn more about it.
5. As a user, I want to be able to select a ‘Courses’ or ‘Programs’ tab to view recently saved or recommended courses or programs, respectively, so that I may decide on which courses or programs that I would like to enrol in.
6. As a user, I want to be able to view my provided survey data so that I can update my preferences to get new course and program recommendations.

### Codebase Architecture
The following outlines the architectural scaffolding of our software application in an effort to design, implement, and maintain a robust and scalable application. We have categorized our classes and interfaces using clean architecture categories, including - from most to least fundamental - by entities, use cases, gateways, controllers, and presenters; the last three categories form a single layer within our software application’s architecture hierarchy. This design choice constitutes packaging by layers. Additionally, SOLID design principles were adhered to when designing the content and scope of our codebase’s classes and interfaces. Recall that the SOLID design principles are the Single-Responsibility, Open-Closed, Liskov, Interface Segregation, and Dependency Inversion principles. 

The Class-Responsibility-Collaboration (CRC) cards shown within our design document outline the high-level abstract classes and interfaces that a category defines. A card includes the class’s/interface’s name, responsible party, responsibilities, collaborating classes/interfaces, (private and public) attributes, and (private and public) methods. The class cards are mostly abstract classes that either are related to or implement specific interfaces. For example, the high-level (abstract) ‘User’ entity class is related to a ‘LoggedInUserInterface’ interface which is implemented within a lower layer’s abstract class (e.g. a class within the ‘Use Case’ layer); this interface enables dependency inversion with less fundamental layers within our software application’s architecture hierarchy in congruence with SOLID architecture principles. 

Classes and interfaces were designed to adhere to SOLID design principles. Each class and interface has a single responsibility; in other words, each class and interface has high cohesion, which is a goal of effective Object-Oriented Programming (OOP) design. Classes were defined to be abstract so that they, like interfaces, could be extended, not modified, by implementing subclasses, thus adhering to the Open-Closed principle. Moreover, since classes’ and interfaces’ methods were designed and implemented using abstract class instances, substituting an instance of a parent object with a child object is viable, thus adhering to the Liskov Substitution principle. Additionally, interfaces are bijectively related to use cases, thus adhering to the Interface Segregation principle. Lastly, our use of interfaces between classes to achieve dependency inversion enables low coupling between classes, which is also a goal of effective OOP design.

Classes and interfaces were packaged by their associated Clean Architecture layers as described above. This design choice was motivated by the fact that our application is a monorepo with many granular and fungible non-use-case classes and interfaces, not an n-tier or microservices application. Specifically, packaging classes and interfaces by features, components, or whether or not they facilitate API requests would limit their reusability, especially that of more fundamental classes and interfaces.

The following Unified Modeling Language (UML) Diagram diagram depicts the high-level packaging of our application’s classes and interface based on Clean Architecture layers, with classes’ and interfaces’ details (i.e. data attributes, methods, etc.) described within the CRC cards below.

![Course Match Application's UML Design](https://github.com/CSC207-2023Y-UofT/course-project-course-match-daddy/assets/80941606/a02aebe9-e903-4d37-ad86-4a1c4c6e1792)

_____

<a name="team-roles-and-contributions"></a>
## Team, Roles, and Contributions
The following individuals were involved in the development of this software application:
* Dev Vora
 * **Role**:
 * **Contributions**:
* Gagandeep Singh Lubana
 * **Role**:
 * **Contributions**:
* Jaspreet Khela
 * **Role**:
 * **Contributions**:
* Lavya Vaishno
 * **Role**:
 * **Contributions**:
* Manav Singh
 * **Role**:
 * **Contributions**:
* Uyiosa Iyekekpolor
 * **Role**:
 * **Contributions**:

_____

<a name="github"></a>
## GitHub Repository Specifications
[Coming Soon]
_____

<a name="android"></a>
## Android Software Application Specifications
### Screenshots
[Coming Soon]
_____

<a name="database"></a>
## Database Specifications
[Coming Soon]
_____

<a name="machine-learning-model"></a>
## Machine Learning Model Specifications
[Coming Soon]
_____

<a name="installation"></a>
## Installation
[Coming Soon]
_____

<a name="usage"></a>
## Usage
[Coming Soon]
_____

<a name="features"></a>
## Features
[Coming Soon]
_____

<a name="testing"></a>
## Testing
[Coming Soon]
_____

<a name="contributions"></a>
## External Contributions
[Coming Soon]
_____

<a name="questions"></a>
## Questions
[Coming Soon]
_____

<a name="license"></a>
## License
[Coming Soon]
_____

<a name="reflection"></a>
## Project Reflection
[Coming Soon]

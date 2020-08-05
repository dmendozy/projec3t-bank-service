Bank service
======================
# Getting Started
This project is based on Spring Boot microservices using the reactive stack, read more info there https://spring.io/reactive

## Frameworks 
* Spring Boot
* Spring Data - Reactive Mongo
* Webflux

## Setup
* Java 1.8
* Maven
* Mongo
* Docker

# Building
## Windows
1. Install [Docker Desktop](https://www.docker.com/products/docker-desktop).
2. Create an image and container for bank-service using the following code:
```
mvn install
docker build . -t bank-service
docker run -p 8086:8086 --name bank-service bank-service
```
# CRUD

| HTTP Verb  |     `/banks`  |      `/banks/{bankId}`      |   
| ---------- | :---------------: | :---------------: |
| **POST**| ADD new bank | - |  
| **GET**| GET all banks | GET bank by Id |
| **PUT**| - | EDIT bank by Id|  
| **DELETE**| - |DELETE bank by Id|  



# Architecture

![Architecture](https://raw.githubusercontent.com/dmendozy/config-service/master/files/arch.png)

# Authors

* **Danny Mendoza Yenque** - *Everis Bootcamp Microservices July 2020* - [DannyMendoza](https://github.com/dmendozy)

# vaadin-spring-jooq-demo
This example shows how to use a [jOOQ](http://www.jooq.org)-based back-end in [Vaadin](https://vaadin.com) applications.

For detailed instuctions, read the tutorial at https://vaadin.com/blog/-/blogs/vaadin-jooq-implementing-business-web-applications-in-plain-java

## Compiling and executing the application

Should have installed Maven and MySQL Server.

Before compiling the application, create a new database schema:

```
CREATE SCHEMA demo;
```

Create the following table:

```
CREATE TABLE customer(
    id SERIAL, first_name VARCHAR(255),
    last_name VARCHAR(255)
);
```

Add some test data:

```
INSERT INTO customer(first_name, last_name) VALUES('Lukas', 'Eder');
INSERT INTO customer(first_name, last_name) VALUES('Mario', 'Fusco');
INSERT INTO customer(first_name, last_name) VALUES('Edson', 'Yanaga');
INSERT INTO customer(first_name, last_name) VALUES('Anton', 'Arhipov');
INSERT INTO customer(first_name, last_name) VALUES('Andres', 'Almiray');
```

Compile (this will also generate jOOQ code) and run with Maven:

```
mvn package spring-boot:run
```

The web application should be available at <http://localhost:8080>

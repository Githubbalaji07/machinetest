## Spring Boot Category-Product CRUD Application

This project is a Spring Boot application that demonstrates CRUD operations on Category and Product entities with a one-to-many relationship. 
The application uses REST APIs, MySQL database.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
## Features

**1) Category Management:**

- Create, Read, Update, Delete (CRUD) operations on categories.

**2)Product Management:**

- Create, Read, Update, Delete (CRUD) operations on products.
- While fetching a product, its associated category details are included.:

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Technologies Used

- Backend: Spring Boot (Spring Web, Spring Data JPA)
- Database: MySQL
- ORM: Hibernate
- Tools: Maven, Postman/Swagger for API testing

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## API Endpoints

**1. Category CRUD Operations**

- 1		http://localhost:8080/api/categories		GET all the categories
- 2		http://localhost:8080/api/categories		POST - create a new category
- 3		http://localhost:8080/api/categories/{id}	GET category by Id
- 4		http://localhost:8080/api/categories/{id} 	PUT - update category by id
- 5		http://localhost:8080/api/categories/{id}	DELETE - Delete category by id


**2. Product CRUD Operations**

- 1		http://localhost:8080/api/products			GET all the products
- 2		http://localhost:8080/api/products			POST - create a new product
- 3		http://localhost:8080/api/products/{id} 	GET product by Id
- 4		http://localhost:8080/api/products/{id} 	PUT - update product by id
- 5		http://localhost:8080/api/products/{id}		DELETE - Delete product by id

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Database Schema

**Category Table :**
Column Type and their Description
- id					Primary key 
- name					Name of the category.


**Product Table :**
Column Type and their Description
- id	 				Primary key
- name					Name of the product.
- price					Price of the product.
- quantity				Quantity of product.
- category_id			Foreign key referencing Category.id.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Database Configuration In Apllication.Properties 

- spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
- spring.datasource.url=jdbc:mysql://localhost:3306/fullstack
- spring.datasource.username=root
- spring.datasource.password=Balaji@598
- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.show-sql=true

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

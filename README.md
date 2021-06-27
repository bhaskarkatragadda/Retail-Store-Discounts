# The Retail Store Discounts
## Spring Boot Application using Kotlin

### Application Description
On a retail website, the following discounts apply:
1. If the user is an employee of the store, he gets a 30% discount
2. If the user is an affiliate of the store, he gets a 10% discount
3. If the user has been a customer for over 2 years, he gets a 5% discount.
4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45
   as a discount).
5. The percentage based discounts do not apply on groceries.
6. A user can get only one of the percentage based discounts on a bill.

## Requirements
- JDK 11
- Kotlin 1.5.2
- Maven  3.6.3
## Running the application locally
- Run the command `mvn spring-boot:run` in the terminal inside project folder where pom.xml present

                                    or
  
- Execute the `main` method in the `BillingApplication.kt` class from your IDE.

# API
 POSTMAN collection Link
 (https://www.getpostman.com/collections/39f883550423b9a50dcc)
##USER
* **GET** /users/getAll: Gets all the Users
* **GET** /users/getByID/{ID}: Get User by person's ID
* **POST** /users/create: Insert a new User
* **DELETE** /users/delete/{ID}: Delete User by person's ID

##PRODUCT
* **GET** /products/getAll: Gets all the products
* **GET** /products/getByID/{ID}: Get product by product's ID
* **POST** /products/create: Insert a new product
* **DELETE** /products/delete/{ID}: Delete product by product's ID

##BILL
* **GET** /bills/getAll: Gets all the bills
* **GET** /bills/getByID/{ID}: Get bill by bill's ID
* **POST** /bills/create: Create a new bills
* **DELETE** /bills/delete/{ID}: Delete bill by bill's ID

### UML Diagram
(https://drive.google.com/file/d/1mQf8da9-k-RxWxVj099qVVOPeI4sNORN/view?usp=sharing)
### API Documentation - Postman
Link (https://documenter.getpostman.com/view/10340268/Tzeak76L)


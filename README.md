# **API Ecommerce Automation Framework**

This project demonstrates a complete API automation testing framework built with **RestAssured**, **TestNG**, and **Maven**, designed for testing Ecommerce APIs such as authentication, product operations, and category endpoints.
It focuses on creating a clean, scalable, and maintainable framework that follows real-world automation standards used in QA teams.

---

## **Current Features**

* Automated API testing using **RestAssured**
* **Request & Response Specifications** implemented in Base layer
* **GET, POST, PUT, DELETE** endpoint validation
* **API Chaining** (Create → Retrieve → Validate)
* **JSON Schema Validation**
* Centralized framework design with POJOs and API client classes
* Clear project structure following automation best practices

---

## **Tech Stack**

| Tool                      | Purpose                         |
| ------------------------- | ------------------------------- |
| **Java**                  | Programming language            |
| **RestAssured**           | API automation                  |
| **TestNG**                | Test execution                  |
| **Maven**                 | Build and dependency management |
| **JSON Schema Validator** | Response structure validation   |
| **FakeStore API**         | Public test API used            |

---

## **Framework Workflow**

1. BaseTest initializes Request & Response Specifications
2. Test Layer sends API requests through RestAssured
3. JSON responses are validated using Hamcrest matchers
4. Advanced tests perform chaining (POST → GET → VALIDATE)
5. Schema validation ensures response structure integrity

---

## **Project Structure**

```
src
 ├── main
 │    └── java
 │         ├── com.ecommerce.api.base      → BaseTest, specs
 │         ├── com.ecommerce.api.client    → API client classes
 │         ├── com.ecommerce.api.pojo      → POJO request/response models
 │         └── utilities                   → schema validator utils (optional)
 └── test
      └── java
           └── tests                       → TestNG test cases
```

---

## **Key Implementations**

### **Request Specification**

* Base URI
* Content-Type
* Common headers
* Logging
* Reusable for all tests

### **Response Specification**

* Default status code
* Expected content type
* Response logging

### **API Chaining**

Example:

* Create a product (POST)
* Use returned ID
* Fetch product details (GET)
* Validate fields

### **Schema Validation**

Ensures the API response meets expected structural rules.

---

## **How to Run Tests**

### Using Maven

```bash
mvn clean test
```

### Run a specific test

```bash
mvn -Dtest=ChainingTest test
```

---

## **Future Enhancements**

* Add **Allure Reporting**
* Add **negative test scenarios**
* Add environment support (DEV/QA/PROD)
* Add data-driven testing using JSON or Excel
* Integrate with Jenkins for CI pipeline
* Add retry mechanism for unstable APIs

---

## **API Base URL**

```
https://fakestoreapi.com/
```

---

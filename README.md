# Ui-Login-Automation

This project contains automated UI tests for [SauceDemo](https://www.saucedemo.com/) login functionality using both **TestNG** and **Cucumber** in separate branches.

---

## Features Covered

-  Login with valid and invalid credentials
- Empty username/password scenarios
- Verification of error messages
- Title check after successful login

---

##  Tech Stack

| **Tool**               | **Purpose**                                                 |
|------------------------|-------------------------------------------------------------|
| **Java 11+**           | Programming language                                         |
| **Maven**              | Build and dependency management                             |
| **Selenium**           | Browser automation framework                                |
| **TestNG**             | Testing framework (used in `testng` branch)                 |
| **Cucumber**           | BDD framework (used in `cucumber` branch)                   |
| **WebDriverManager**   | Automatic driver resolution and setup                       |
| **SLF4J + Logback**    | Logging system for test events                              |
| **AssertJ**            | Fluent assertions for readable validations                  |
| **Page Object Model**  | Design pattern for separating page logic                    |
| **TestNG Listeners**   | Attach screenshots and logs on failure                      |
| **Cucumber Hooks**     | Manages driver lifecycle and failure handling               |
| **Parallel Testing**   | Enabled for multi-browser testing via `testng.xml`          |
| **Browsers Supported** | Chrome (default), Firefox (via `-Dbrowser=firefox`)         |

---

##  Branch Structure

| **Branch**   | **Purpose**                               |
|--------------|--------------------------------------------|
| `testng`     | Contains all tests written using **TestNG**|
| `cucumber`   | Contains all tests written using **Cucumber**|

>  Each branch contains its own test configuration, `testng.xml`, feature files or step definitions as needed.



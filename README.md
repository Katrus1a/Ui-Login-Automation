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

## Branch Structure

This project uses two separate branches for different test frameworks:

| Branch   | Description                                  |
|----------|----------------------------------------------|
| `testng` | Contains tests written using **TestNG**      |
| `cucumber` | Contains BDD tests written using **Cucumber** |

To run a specific version, switch to the appropriate branch:

```bash
git checkout testng   # For TestNG-based tests
git checkout cucumber # For Cucumber-based tests



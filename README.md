# OrangeHRM UI Test Automation Framework

[![CI](https://github.com/tamar-bunturi/selenium-ui-automation-framework/actions/workflows/ci.yml/badge.svg?branch=main)](https://github.com/tamar-bunturi/selenium-ui-automation-framework/actions/workflows/ci.yml)

A UI test automation framework for the OrangeHRM demo application, built with Java, Selenium WebDriver, and TestNG using the Page Object Model (POM). Test execution is reported through Allure.

## Tech Stack

| Tool                    | Purpose                       |
| ----------------------- | ----------------------------- |
| Java 21                 | Programming language          |
| Selenium WebDriver 4.44 | Browser automation            |
| TestNG                  | Test framework & assertions   |
| Maven                   | Build & dependency management |
| Allure                  | Test reporting                |

## Design

The framework follows the **Page Object Model (POM)** to separate test logic from page details:

* **`pages/`** — one class per page (e.g., `LoginPage`). Each page contains its element locators and user actions. Keeping locators in one place makes maintenance easier when the UI changes.
* **`drivers/`** — `DriverManager` handles browser initialization and cleanup.
* **`config/`** — `ConfigReader` loads configuration values such as browser type, base URL, and timeout settings from `config.properties`.
* **`tests/`** — `BaseTest` manages test setup and teardown, ensuring each test runs in a clean browser session.

Synchronization is implemented using **explicit waits** (`WebDriverWait` and `ExpectedConditions`) instead of `Thread.sleep()`, improving reliability and execution speed.

## Test Coverage

| Test                       | Scenario                                                                            |
| -------------------------- | ----------------------------------------------------------------------------------- |
| `validLoginShowsDashboard` | Logs in with valid credentials and verifies the dashboard is displayed              |
| `invalidLoginShowsError`   | Attempts login with invalid credentials and verifies the error message is displayed |

The framework includes both positive and negative login scenarios.

## How to Run

### Prerequisites

* Java 21
* Maven
* Google Chrome

Selenium Manager automatically resolves the appropriate browser driver.

### Run Tests

```bash
mvn test
```

### Generate and Open Allure Report

```bash
mvn allure:serve
```

## Project Structure

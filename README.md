# OrangeHRM UI Test Automation Framework

A UI test automation framework for the [OrangeHRM](https://opensource-demo.orangehrmlive.com/) demo application, built with Java, Selenium WebDriver, and TestNG using the Page Object Model. Test execution is reported through Allure.

## Tech Stack

| Tool | Purpose |
|------|---------|
| Java 25 | Programming language |
| Selenium WebDriver 4.44 | Browser automation |
| TestNG | Test framework & assertions |
| Maven | Build & dependency management |
| Allure | Test reporting |

## Design

The framework follows the **Page Object Model (POM)** to separate test logic from page details:

- **`pages/`** — one class per page (e.g. `LoginPage`). Each holds the page's element locators and the actions a user can perform on it. Locators live in one place, so a UI change is a one-line fix.
- **`drivers/`** — `DriverManager` handles starting and stopping the browser.
- **`config/`** — `ConfigReader` reads settings (browser, base URL, wait time) from `config.properties`, so no values are hardcoded in tests.
- **`tests/`** — `BaseTest` opens a fresh browser before each test and closes it after, so tests stay independent. Test classes extend it.

Synchronisation uses **explicit waits** (`WebDriverWait` + `ExpectedConditions`) — never `Thread.sleep` — so tests wait only as long as needed and fail fast when an element never appears.

## Test Coverage

| Test | Scenario |
|------|----------|
| `validLoginShowsDashboard` | Logs in with valid credentials and verifies the dashboard loads |
| `invalidLoginShowsError` | Attempts login with a wrong password and verifies the error message |

Both a positive and a negative path are covered.

## How to Run

Prerequisites: Java 25 and Maven installed, and Google Chrome (the driver is resolved automatically by Selenium Manager).

Run the test suite:
```bash
mvn test
```

Generate and open the Allure report:
```bash
mvn allure:serve
```

## Project Structure
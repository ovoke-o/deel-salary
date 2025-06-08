# Deel Salary Insight Automation Framework

This is a UI test automation framework using **Java**, **Playwright**, **Cucumber**, and **Allure Reports** to validate salary insights for different roles and countries on the [Deel Salary Insight Page](https://growth.deel.training/dev/salary-insights).

---

## 🧰 Tech Stack

- Java 11
- Maven 3.6+
- Playwright Java
- Cucumber (Gherkin BDD)
- Allure Reporting
- TestNG
- Intelli J IDE

---

## 📦 Installation Instructions

### 1. Prerequisites

- [Java 11+](https://adoptium.net/) installed and configured in `JAVA_HOME`
- [Maven](https://maven.apache.org/) installed and in system `PATH`
- Node.js (for Playwright CLI installation)
- Internet connection to download Playwright drivers

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/kestavoke/deel-salary.git
cd deel-salary
```

### 2. Install Playwright CLI & Browsers

```bash
npx playwright install
```

---

## 🧪 Running Tests

### Run All Tests via Maven

```bash
mvn clean test
```

### Run with TestRunner
From IntelliJ: Right-click TestRunner.java → Run 'TestRunner

### Run with Tags

```bash
mvn test -Dcucumber.filter.tags="@Regression"
```

---

## 📊 Allure Report

### Generate Allure Report

```bash
mvn allure:serve
```

Or to just generate files:

```bash
mvn allure:report
```

View HTML at: `target/site/allure-maven-plugin/index.html`

---

## 🗂 Project Structure

```
src
├── main
│   └── java
│       └── pages/               # Page Object classes
├── test
│   └── java
│       ├── hooks/               # Hooks for setup/teardown
│       ├── stepdefs/            # Step Definitions for Cucumber
│       └── utils/               # Playwright, Screenshot helpers
│   └── resources
│       └── features/            # Gherkin .feature files
```

---

## 🧾 Example Scenario

```gherkin
Scenario: Display salary insights for job in country
  Given user is on the Deel Salary Insight page
  When user selects role "QA Engineer" and country "Canada"
  Then salary insights for "QA Engineer" and country "Canada" should be displayed
```

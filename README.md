<div align="center">

# 🛡️ PolicyBazaar Automation Testing Framework

### A Production-Grade End-to-End Test Automation Suite built as a Hackathon Project

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java"/>
  <img src="https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white" alt="Selenium"/>
  <img src="https://img.shields.io/badge/Cucumber-23D96C?style=for-the-badge&logo=cucumber&logoColor=white" alt="Cucumber BDD"/>
  <img src="https://img.shields.io/badge/TestNG-FF6C37?style=for-the-badge&logo=testng&logoColor=white" alt="TestNG"/>
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven"/>
  <img src="https://img.shields.io/badge/ExtentReports-0082C8?style=for-the-badge" alt="ExtentReports"/>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Tests-34%2B-brightgreen" alt="Tests"/>
  <img src="https://img.shields.io/badge/Page%20Objects-8-blue" alt="Page Objects"/>
  <img src="https://img.shields.io/badge/BDD%20Scenarios-11%2B-purple" alt="BDD Scenarios"/>
  <img src="https://img.shields.io/badge/Test%20Runners-5-orange" alt="Test Runners"/>
  <img src="https://img.shields.io/badge/Execution-Local%20%7C%20Selenium%20Grid-informational" alt="Execution"/>
</p>

<p align="center">
  <strong>Selenium 4 · Cucumber BDD · TestNG · Page Object Model · Data-Driven · ExtentReports · Selenium Grid</strong>
</p>

</div>

---

## 📌 Project Overview

This framework automates end-to-end testing for the **PolicyBazaar** insurance aggregator platform — covering Travel Insurance, Car Insurance, Health Insurance, and Plan Comparison workflows. Built during a hackathon under the team name **CodeBreakers**, it demonstrates a professional-grade test automation architecture that mirrors industry practices used in QA teams at large-scale product companies.

The framework is **dual-layered**: it supports both **BDD-style Cucumber scenarios** (for business-readable tests) and **traditional TestNG test classes** (for data-driven, priority-ordered execution) — making it flexible enough for both QA analysts and senior automation engineers.

---

## ✨ Key Highlights

| Feature | Detail |
|---|---|
| 🏗️ **Architecture** | Page Object Model (POM) with `BasePage` abstraction |
| 🥒 **BDD** | Cucumber 7 with Gherkin feature files, step definitions, and Hooks |
| 📊 **Data-Driven** | Apache POI for Excel-based test data; `@DataProvider` for TestNG |
| 🌐 **Cross-Browser** | Chrome and Edge (local + headless); Selenium Grid for remote execution |
| 📋 **Reporting** | ExtentReports (Spark HTML), JSON, JUnit XML, and Cucumber HTML reports |
| 🔖 **Tag-Based Execution** | `@Smoke` and `@Regression` suites with dedicated runners |
| 📸 **Failure Handling** | Automatic screenshots on test/scenario failure via `ITestListener` |
| ⚙️ **Config-Driven** | `.properties` file drives browser, URL, run mode, and Grid Hub IP |
| 🧪 **Test Coverage** | 34+ test cases across 3 major insurance modules |

---

## 🏛️ Architecture

```
policy_bazaar/
│
├── browserutils/
│   └── BrowserFactory.java          # Chrome/Edge local & Selenium Grid remote setup
│
├── frameworkutils/
│   ├── CommonUtils.java             # Thread sleep, date-time helpers
│   ├── PropertiesFileReader.java    # Config reader from .properties files
│   └── ReadAndWriteFromExcel.java   # Apache POI data provider + result writer
│
├── seleniumutils/
│   ├── ActionUtil.java              # Selenium Actions (hover, drag, keyboard)
│   ├── JavaScriptUtil.java          # JS Executor wrappers (click, scroll)
│   ├── ScreenShotUtil.java          # Screenshot capture utility
│   ├── SelectUtils.java             # Dropdown handler (Select class)
│   └── Waits.java                   # Explicit waits (WebDriverWait + ExpectedConditions)
│
├── pageobjects/
│   ├── BasePage.java                # PageFactory init for all page objects
│   ├── HomePage.java                # Navigation: Travel & Health Insurance clicks
│   ├── TravelInsurancePage.java     # Country, dates, travellers, plans interaction
│   ├── PlansPage.java               # Sort, filter, student plans, top-3 extraction
│   ├── CarInsuranceLandingPage.java # Car insurance entry flow
│   ├── CarModelPage.java            # Brand, model, fuel, variant selection
│   ├── CityAndBrandSelection.java   # City/brand step interaction
│   ├── FormPage.java                # User details form + validation
│   └── HealthInsurancePage.java     # Health plan listing + data extraction
│
├── stepdefinitions/                  # Cucumber Glue Code
│   ├── Hooks.java                   # @Before / @After: browser init, screenshot, teardown
│   ├── TestDataContext.java         # Thread-safe test data sharing between steps
│   ├── HomePageStepDefs.java
│   ├── TravelInsuranceStepDefs.java
│   ├── CarInsuranceLandingSteps.java
│   ├── CarModelSteps.java
│   ├── SelectionSteps.java
│   ├── FormSteps.java
│   ├── PlansPageStepDefs.java
│   └── HealthInsuranceStepDefs.java
│
├── testlistener/
│   ├── MyListener.java              # Global ExtentReports listener
│   ├── MyListenerCombined.java      # Combined scenario listener
│   ├── MyListenerScenario1.java     # Scenario 1 scoped listener
│   ├── MyListenerScenario2.java     # Scenario 2 scoped listener
│   └── MyListenerScenario3.java     # Scenario 3 scoped listener
│
└── testrunner/
    ├── CucumberBDDTestRunner.java   # Full BDD suite runner
    ├── SmokeBDDTestRunner.java      # @Smoke tag runner
    ├── RegressionBDDTestRunner.java # @Regression tag runner
    ├── Scenario1_Runner.java        # TestNG: Travel Insurance (data-driven)
    ├── Scenario2_Runner.java        # TestNG: Car Insurance (data-driven)
    └── Scenario3_Runner.java        # TestNG: Health Insurance (data-driven)

src/test/resources/
├── features/
│   ├── CarInsurance.feature
│   ├── HealthInsurance.feature
│   └── TravelInsurance.feature
└── testdata/
    ├── config.properties
    ├── Scenario1_2_3_TestData.xlsx
    ├── Scenario1_Output.xlsx
    └── Scenario3_Output.xlsx
```

---

## 🧪 Test Coverage

### Scenario 1 — Travel Insurance (`Scenario1_Runner` / `TravelInsurance.feature`)

| # | Test Case | Type |
|---|---|---|
| TC-S1-01 | Validate accessing the Travel Insurance page | Smoke, Regression |
| TC-S1-02 | Validate destination selection from Excel data | Regression |
| TC-S1-03 | Validate travel start and end date selection | Regression |
| TC-S1-04 | Validate selecting 2 travellers and navigating to Plans page | Regression |
| TC-S1-05 | Validate clicking View Plans and reaching Plans page | Smoke, Regression |
| TC-S1-06 | Validate selecting Student Plans with trip duration filter | Regression |
| TC-S1-07 | Validate sorting plans from Low to High | Regression |
| TC-S1-08 | Validate extracting and storing top 3 insurance plans to Excel | Regression |
| TC-S1-09 | Validate no traveller selected shows error message | Regression |
| TC-S1-10 | Validate invalid country name shows no results | Regression |
| TC-S1-11 | Validate missing date selection throws error | Regression |

### Scenario 2 — Car Insurance (`Scenario2_Runner` / `CarInsurance.feature`)

| # | Test Case | Type |
|---|---|---|
| TC-002-01 | Navigate to Car Insurance page | Smoke, Regression |
| TC-002-02 | Click "without car number" and verify city field visibility | Regression |
| TC-002-03 | Select city and verify brand field appears | Regression |
| TC-002-04 | Select car brand and verify model input visible | Regression |
| TC-002-05 | Select car model and verify fuel type field | Regression |
| TC-002-06 | Select fuel type and verify variant field | Regression |
| TC-002-07 | Select variant and verify form page displayed | Regression |
| TC-002-08 | Enter name and invalid phone — verify error message | Regression |

### Scenario 3 — Health Insurance (`Scenario3_Runner` / `HealthInsurance.feature`)

| # | Test Case | Type |
|---|---|---|
| TC-003-01 | Validate Insurance Products menu is enabled on hover | Smoke, Regression |
| TC-003-04 | Validate redirection to Health Insurance page | Smoke, Regression |
| TC-003-05 | Retrieve all insurance names, cover amounts, and start amounts | Regression |
| TC-003-06 | Store extracted plan data to Excel output file | Regression |

---

## 🛠️ Technology Stack

| Layer | Technology |
|---|---|
| Language | Java 8+ |
| Browser Automation | Selenium WebDriver 4.x |
| BDD Framework | Cucumber 7 (JVM) |
| Test Runner | TestNG 7.x |
| Build Tool | Apache Maven |
| Reporting | ExtentReports 5 (Spark), Cucumber HTML/JSON/JUnit XML |
| Data Handling | Apache POI (XSSF — `.xlsx` read/write) |
| Design Pattern | Page Object Model (POM) with PageFactory |
| Remote Execution | Selenium Grid (RemoteWebDriver + DesiredCapabilities) |
| Configuration | Java `.properties` files |

---

## ⚙️ Setup & Running Tests

### Prerequisites

- Java 8 or above
- Maven 3.6+
- Chrome or Edge browser installed
- _(Optional)_ Selenium Grid Hub running for remote execution

### Clone & Configure

```bash
git clone https://github.com/<your-username>/policybazaar-automation.git
cd policybazaar-automation
```

Open `src/test/resources/testdata/config.properties` and set:

```properties
# Local or remote execution
browsername=chrome
wheretorun=local
hubip=http://localhost:4444
url=https://www.policybazaar.com
```

Set `wheretorun=cloud` and provide `hubip` to run on Selenium Grid.

### Running Tests

```bash
# Run the full BDD suite
mvn test -Dtest=CucumberBDDTestRunner

# Run only Smoke tests
mvn test -Dtest=SmokeBDDTestRunner

# Run only Regression tests
mvn test -Dtest=RegressionBDDTestRunner

# Run Scenario 1 (Travel Insurance — TestNG data-driven)
mvn test -Dtest=Scenario1_Runner

# Run Scenario 2 (Car Insurance — TestNG data-driven)
mvn test -Dtest=Scenario2_Runner

# Run Scenario 3 (Health Insurance — TestNG data-driven)
mvn test -Dtest=Scenario3_Runner
```

### Test Reports

After execution, open the relevant report:

| Report Type | Path |
|---|---|
| Cucumber HTML | `target/cucumber_reports/cucumber.html` |
| Smoke Cucumber HTML | `target/smoke_cucumber_reports/smoke_cucumber.html` |
| Regression Cucumber HTML | `target/regression_cucumber_reports/regression_cucumber.html` |
| ExtentReport (BDD) | `test-output/reports/ExtentReport.html` |
| ExtentReport Scenario 1 | `test-output/ThirdPartyReports/ExtentReportScenario1.html` |
| ExtentReport Scenario 2 | `test-output/ThirdPartyReports/ExtentReportScenario2.html` |
| ExtentReport Scenario 3 | `test-output/ThirdPartyReports/ExtentReportScenario3.html` |

---

## 📊 Data-Driven Testing

Test data is managed externally using **Apache POI** with an Excel file (`Scenario1_2_3_TestData.xlsx`). Each scenario reads data row by row via a custom `@DataProvider`.

```java
@DataProvider(name = "excelTestData")
public static Object[][] getTestData(Method m) {
    // Reads from testdata/Scenario1_2_3_TestData.xlsx
    // Matches sheet name to test method name automatically
}
```

Test results (PASS/FAIL) are also **written back to the Excel file** at runtime, giving a live traceability report alongside ExtentReports.

For **BDD scenarios**, test data is loaded via a `TestDataContext` thread-safe context class that maps TC IDs (e.g., `"TC_002_04"`) to their corresponding Excel rows, decoupling data management from step definitions.

---

## 🔖 Tag-Based Execution Strategy

Cucumber tags allow targeted test execution without modifying code:

```gherkin
@Smoke @Regression
Scenario: TC_002_01 - Navigate to Car Insurance Page

@Regression
Scenario: TC_002_08 - Enter name and invalid phone
```

| Tag | Purpose | Runner |
|---|---|---|
| `@Smoke` | Critical path verification, fast feedback | `SmokeBDDTestRunner` |
| `@Regression` | Full coverage on every build | `RegressionBDDTestRunner` |
| _(none)_ | All scenarios | `CucumberBDDTestRunner` |

---

## 🌐 Selenium Grid Support

The `BrowserFactory` class supports seamless switching between **local** and **remote (Selenium Grid)** execution via the `config.properties` file — no code changes required:

```java
public static WebDriver getBrowser(String browserName, String runMode, String hubIp) {
    if (runMode.equalsIgnoreCase("cloud")) {
        return runRemote(browserName, hubIp);  // → RemoteWebDriver → Grid
    } else {
        return runLocal(browserName);           // → local ChromeDriver/EdgeDriver
    }
}
```

This makes the framework **CI/CD pipeline-ready** — the same tests that run locally on a developer's machine can be executed in parallel across a Selenium Grid cluster.

---

## 📸 Failure Handling & Screenshots

Every test failure — both in TestNG test methods and Cucumber scenarios — is caught and documented automatically:

- `ITestListener` implementations (`MyListenerScenario1/2/3`) capture screenshots and log failures to scenario-specific ExtentReports.
- The `Hooks` class in the BDD layer captures screenshots after any failed `Scenario` and embeds them in the Cucumber report.

```java
@After
public void end(Scenario scenario) {
    if (scenario.isFailed()) {
        byte[] screenshot = ScreenShotUtil.takeScreenShotAsByteArray(driver);
        scenario.attach(screenshot, "image/png", "Failure Screenshot");
    }
    driver.quit();
}
```

---

## 📁 Project Structure Summary

```
src/
├── main/java/com/cts/policy_bazaar/
│   ├── browserutils/       → BrowserFactory (local + Grid)
│   ├── frameworkutils/     → Config, Excel, date/time utils
│   ├── seleniumutils/      → Actions, JS, waits, select, screenshot
│   └── pageobjects/        → 8 page object classes (POM + PageFactory)
│
└── test/
    ├── java/com/cts/policy_bazaar/
    │   ├── stepdefinitions/ → 10 Cucumber step def classes + Hooks
    │   ├── testlistener/    → 5 ExtentReports ITestListener classes
    │   └── testrunner/      → 3 BDD runners + 3 TestNG scenario runners
    │
    └── resources/
        ├── features/        → 3 Gherkin feature files
        └── testdata/        → config.properties + Excel test data
```

---

## 🧠 Design Decisions

**Why both BDD (Cucumber) and TestNG runners?**
The BDD layer gives business stakeholders readable scenarios in plain English. The TestNG runners provide priority-ordered, Excel-driven test execution with granular result write-back — useful when a QA team needs to maintain traceability matrices in Excel alongside Extent HTML reports.

**Why a `TestDataContext` class?**
Cucumber step definitions are instantiated per-scenario, not shared by default. `TestDataContext` uses a static `ThreadLocal`-friendly pattern to pass Excel-loaded test data (keyed by TC ID) between step definitions cleanly, without coupling unrelated step classes together.

**Why 5 separate listener classes?**
Each hackathon scenario had its own scoped ExtentReport. Dedicated listeners (`MyListenerScenario1`, `2`, `3`) let each scenario produce its own HTML report with system info, pass/fail counts, and browser details — without interfering with each other.

---

## 👨‍💻 Team

**Team Name:** CodeBreakers
**Environment:** QA
**Platform:** Cross-browser (Chrome / Edge)

---

## 📄 License

This project was built as a hackathon submission. All automation code is original work by the team. The website under test (PolicyBazaar) is a publicly accessible platform.

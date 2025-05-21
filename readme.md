A Cucumber + RestAssured + ExtentReports Framework using Page Object Model (POM)

This project automates API testing for the Pet Store API using:
✔ Java (JDK 17+)
✔ Cucumber (BDD)
✔ RestAssured (API Testing)
✔ ExtentReports (Interactive Reporting)
✔ Page Object Model (POM) for Maintainability


📌 How to Run the Tests
Prerequisites
Java JDK 17 (or higher)

Maven (for dependency management)

IDE (IntelliJ/Eclipse recommended)

Running the Tests
Option 1: Command Line (Maven)
First, install dependencies:mvn clean install
Run all tests:mvn clean test
ExtentReports - Viewing Test Results
After execution, an interactive HTML report is generated at:
target/extent-report/extent-report.html
Why Page Object Model (POM)?
✔ Reusable API Methods (e.g., addPet(), getPetById())


Why Cucumber (BDD)?
✔ Business-readable tests (Gherkin syntax)


🚀 Benefits of This Framework
✅ Maintainable (POM structure)
✅ Readable Tests (Cucumber BDD)
✅ Detailed Reporting (ExtentReports)
✅ Easy CI/CD Integration (Maven-based)
# 🧪 Todo List Automation Testing – Selenium + JUnit

This project is an automation solution for the **Spring Boot Todo List Web Application**. The UI functionalities have been tested using **Selenium WebDriver** with **JUnit 5**, and the project is built using **Maven**.

---

## ✅ Project Overview

This repository contains:
- A Spring Boot-based Todo web application.
- Automated UI tests for the application.
- Maven configuration to run tests and generate a test report.

The automated test cases validate core functionalities such as adding, deleting, completing, and validating tasks in the Todo list.

---

## 🛠️ Technologies Used

- Java 21  
- Spring Boot 3.4.4  
- Selenium WebDriver 4.21.0  
- JUnit 5 (JUnit Jupiter)  
- WebDriverManager 5.7.0  
- Maven Surefire Plugin  

---

## 📁 Project Structure

```
src/
├── test/
│   └── java/
│       └── com/example/todoapp/
│           ├── BaseTest.java       # Test setup and teardown logic
│           └── TodoTest.java       # Contains all test cases
target/
├── surefire-reports/               # Test output and reports
pom.xml                             # Project dependencies and plugins
testng.xml                          # (Unused, as JUnit is used)
```

---

## 🧪 Test Scenarios Covered

All test cases are written in `TodoTest.java` and include:

1. **Initial Empty List** – Verify that no tasks are present on page load.
2. **Add One Task** – Add a task and verify it appears unchecked.
3. **Add Two Tasks** – Add two tasks and verify both appear.
4. **Delete a Task** – Add and delete a task, and verify it's removed.
5. **Mark Task as Completed** – Mark a task as completed and verify it is struck through.
6. **Toggle Task Completion** – Mark and unmark a task and verify class changes.
7. **Verify Validation** – Try adding an empty task and check for an error message.

---

## ▶️ How to Run the Application

Make sure you have Java and Maven installed.

1. Clone the repository:

```bash
git clone https://github.com/YOUR_USERNAME/todo-challenge.git
cd todo-challenge
```

2. Start the Spring Boot app:

```bash
mvn spring-boot:run
```

Access the UI in your browser at:  
[http://localhost:8080](http://localhost:8080)

---

## 🧪 How to Run the Tests

> Make sure the application is **running** before running tests.

Execute the following command to clean, compile, and run all tests:

```bash
mvn clean install
```

---

## 📊 How to Generate Test Report

After running the tests, generate the test report using:

```bash
mvn surefire-report:report-only
```

The HTML report will be available at:

```
target/site/surefire-report.html
```

Open this file in your browser to view the results.

---

## 🚀 Future Enhancements

Here are some ideas to further improve this automation project:

- ✅ **Cross-browser testing** using Selenium Grid or cloud services (e.g., BrowserStack or SauceLabs).
- 📱 **Mobile view validation** using responsive testing or Appium.
- 🔎 **Accessibility testing** using tools like **axe-core**.
- 📘 **Cucumber BDD integration** for behavior-driven test cases with Gherkin syntax.
- 📦 **Test data externalization** using JSON or Excel for data-driven testing.
- 🧪 **API automation testing** for backend validation using RestAssured or Postman collections.
- 📸 **Screenshot capturing** for failed tests and visual logs.
- 📈 **Integration with CI/CD pipeline** using Jenkins or GitHub Actions.
- 🌐 **Parallel test execution** to reduce test runtime.

---

## 👩‍💻 Author

**Bhumika Vaghasiya**  

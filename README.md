# 🧪 Magento QA Automation Framework

This project is a **Magento QA Automation Framework** designed for automating test cases on [Magento](https://magento.com/) e-commerce platforms using **Java**, **Selenium WebDriver**, **TestNG**, and **Maven**. It follows the **Page Object Model (POM)** design pattern and supports **data-driven testing**, **parallel execution**, and **detailed test reporting**.

---

## 📌 Features

- 🧱 Framework is designed using **Page Object Model (POM)**
- 🧪 **TestNG** is used for test case execution
- 📊 **ExtentReports** is used for generating beautiful test reports
- 📈 **Log4j** is used for logging purposes
- 🧪 **Excel-based Data-driven testing** supported
- ⚙️ **TestNG.xml** used to control test execution
- 🔁 **Parallel Execution** supported via TestNG configurations
- 📦 Maven-based project for easy dependency management and build
- 🧪 Tested on Magento-based e-commerce application

---

## 📁 Project Structure
Magento-QA-Automation/ │ ├── src/ # Source code (test scripts and framework logic) │ └── test/ │ ├── java/ │ │ └── pages/ # Page classes (Page Object Model) │ │ └── tests/ # Test classes (TestNG based) │ │ └── utils/ # Utility classes (Excel reader, loggers, etc.) │ ├── test-output/ # TestNG output directory │ ├── logs/ # Log files from test executions │ ├── .settings/, .classpath, # Eclipse IDE configurations │ .project │ ├── testng.xml # TestNG suite for full regression or specific runs ├── testngClass.xml # TestNG suite by class ├── testngParallel.xml # TestNG suite for parallel execution │ ├── pom.xml # Maven configuration and dependencies ├── .gitignore # Git ignored files └── README.md # Project documentation (you're reading it!)

## ⚙️ Technologies Used

| Tool               | Purpose                              |
|--------------------|--------------------------------------|
| Java               | Programming language                 |
| Selenium WebDriver | Browser automation                   |
| TestNG             | Test framework and execution control |
| Maven              | Build and dependency management      |
| Apache POI         | Reading data from Excel              |
| Log4j              | Logging support                      |
| ExtentReports      | Rich HTML test reporting             |

---



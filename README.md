# Mttpp
projekt iz mttpp-a

Ukupno: 12 testova
6 test klasa
12 test metoda
Test pokrivenost
Login (valid/invalid, logout, success message)
Checkbox (selektiranje/deselektiranje)
Dropdown (select opcije)
Add/Remove elementi
Table (5 testova: count rows, extract data, sort, validate)
Drag & Drop 

Test Automatizacija
Selenium WebDriver 4.26.0 - za automaciju web testiranja
Cross-Browser Testing
Uključeni drajveri za više browser-a:
Chrome (ChromeDriver)
Firefox (FirefoxDriver)
Edge (EdgeDriver)

Wait naredbe (Selenium WebDriver)
WebDriverManager 5.9.2 - automatski preuzima i postavlja odgovarajuće browser driver-e
OOP
Maven - build tool i dependency management
Maven Surefire Plugin - za pokretanje testova
Maven Surefire Report Plugin - za generiranje test report-a
JUnit 5 Framework
Allure Reports sa screenshotovima
Page Object Model (POM)


.gitignore - za ignorisanje Maven target direktorijuma, IDE datoteka, Java klasa i OS datoteka



src/test/java/
├── base/
│   ├── BaseTest.java
│   └── CrossBrowserExtension.java
├── pages/
│   ├── HomePage.java
│   ├── LoginPage.java
│   ├── CheckboxPage.java
│   ├── DropdownPage.java
│   ├── AddRemovePage.java
│   ├── TablePage.java
│   └── DragDropPage.java
└── tests/
    ├── LoginTest.java (4 testa)
    ├── CheckboxTest.java (1 test)
    ├── DropdownTest.java (1 test)
    ├── AddRemoveTest.java (1 test)
    ├── TableTests.java (5 testova)
    └── DragDropTests.java (1 test)
└── pom.xml


pkretanje:
mvn clean test                    # Chrome (default)
mvn clean test -Dbrowser=firefox  # Firefox
mvn clean test -Dbrowser=edge     # Edge

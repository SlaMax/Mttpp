# MTPP Projekt – Test Automatizacija

## 📊 Opis testova

**Ukupno:** 12 testova

* 6 test klasa
* 12 test metoda

### Pokrivenost funkcionalnosti

* **Login** – valid / invalid, logout, success message
* **Checkbox** – selektiranje / deselektiranje
* **Dropdown** – odabir opcija
* **Add / Remove** elementi
* **Table** (5 testova):

  * count rows
  * extract data
  * sort
  * validate
* **Drag & Drop**

---

## 🧪 Test Automatizacija

* **Selenium WebDriver 4.26.0** – web test automatizacija

* **Cross-Browser Testing**

  * Chrome (ChromeDriver)
  * Firefox (FirefoxDriver)
  * Edge (EdgeDriver)

* **Wait naredbe** – Selenium WebDriver

* **WebDriverManager 5.9.2** – automatski driver setup

* **JUnit 5** – test framework

* **Allure Reports** – reporti + screenshotovi

---

## 🏗️ Arhitektura i alati

* **Page Object Model (POM)**
* **OOP pristup**
* **Maven** – build & dependency management
* **Maven Surefire Plugin** – pokretanje testova
* **Maven Surefire Report Plugin** – test report

---

## 📁 Struktura projekta

```
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

pom.xml
```

---

## ▶️ Pokretanje testova

```bash
mvn clean test                     # Chrome (default)
mvn clean test -Dbrowser=firefox  # Firefox
mvn clean test -Dbrowser=edge     # Edge
```

---

## 📄 .gitignore

Ignorira:

* Maven `target/` direktorij
* IDE datoteke
* kompajlirane Java klase
* OS sistemske datoteke

```
```

# CS 222: First Project
###### First-katrazo-Cameron311

---
## Summary
This project, as per the [specifications](https://bsu.instructure.com/courses/157856/files/17806780) on Canvas, allows a user to easily gather the 15 most recent revisions to a Wikipedia page simply by typing the title of the article.

The first iteration will make use of the **terminal** for both input and output.

The second iteration will make use of **JavaFX** for both input and output.

---
## Build Instructions
This project uses **[Jayway JsonPath](https://github.com/json-path/JsonPath)**, which is a Java port of the original JsonPath.
Jayway JsonPath is available at the [Central Maven Repository](https://mvnrepository.com/artifact/com.jayway.jsonpath/json-path/2.9.0).

For Maven users, add this to your <kbd>POM</kbd>.
```xml
<dependency>
    <groupId>com.jayway.jsonpath</groupId>
    <artifactId>json-path</artifactId>
    <version>2.9.0</version>
</dependency>
```

For Gradle (Kotlin) users, add this to your <kbd>build.gradle.kts</kbd> dependencies.
```java
// https://mvnrepository.com/artifact/com.jayway.jsonpath/json-path
implementation("com.jayway.jsonpath:json-path:2.9.0")
```

---
## Accreditation
| Credited Individual  | Username     | Role          |
|----------------------|--------------|---------------|
| Kat Razo             | `katrazo`    | Co-author     |
| Cameron Witzigreuter | `Cameron311` | Co-author     |
| Priscilla Zavala     | `pazavala`   | Peer Reviewer |
| Mark William         | `Gaezi`      | Peer Reviewer |
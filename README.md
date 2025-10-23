# CS 222: First Project
###### First-katrazo-Cameron311

---
## Summary
This project, as per the specifications [\[1\]](https://bsu.instructure.com/courses/157856/files/17806780 "Iteration One") [\[2\]](https://bsu.instructure.com/courses/157856/files/18275548/ "Iteration Two") on Canvas, allows a user to easily gather the 15 most recent revisions to a Wikipedia page simply by typing the title of the article.

The first iteration makes use of the <ins>**console**</ins> for input and output. Simply run the `MainCLI.java` class.
The second iteration makes use of <ins>**JavaFX**</ins> for input and output. The Gradle run task is tied to this. This version can still be run through `MainCLI.java` as well.

---
## Build Instructions
To use this project as-is, no additional build instructions are necessary. Remember to use **Gradle > Tasks > run** to open the JavaFX application.
To view dependencies, see the bottom of this readme.

---
## Accreditation
### Contributors
| Credited Individual  | Username                                                                         | Role          |
|----------------------|----------------------------------------------------------------------------------|---------------|
| Kat R.               | <kbd>[☍](https://github.com/KxtR-27 "Kat's Profile")</kbd> `KxtR-27`             | Co-author     |
| Cameron Witzigreuter | <kbd>[☍](https://github.com/Cameron311 "Cameron's Profile")</kbd> `Cameron311`   | Co-author     |
| Priscilla Zavala     | <kbd>[☍](https://github.com/pazavala "Priscilla's Profile")</kbd> `pazavala`     | Peer Reviewer |
| Mark William         | <kbd>[☍](https://github.com/Gaezi "Mark's Profile")</kbd> `Gaezi`                | Peer Reviewer |
| Mr. David L. Largent | <kbd>[☍](https://github.com/dllargent "Mr. Largent's Profile")</kbd> `dllargent` | Professor     |

### Dependencies
| Credited Dependency | Source Location                                                                                                                                                                                                         | Role                                                   |
|---------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------|
| SLF4J-NOP Logger    | https://mvnrepository.com/artifact/org.slf4j/slf4j-nop                                                                                                                                                                  | Removes logging warning                                |
| Jayway JsonPath     | https://mvnrepository.com/artifact/com.jayway.jsonpath/json-path                                                                                                                                                        | Utilities for parsing JSON data                        |
| Apache IOUtils      | https://mvnrepository.com/artifact/commons-io/commons-io                                                                                                                                                                | Streamlines the process of retrieving data from a link |
| JavaFX/SceneBuilder | [see [this repository](https://github.com/katrazo/StructureDemo "StructureDemo") and the [specifications document](https://bsu.instructure.com/courses/157856/files/18275548/ "Iteration Two Specifications") for info] | Necessary for **First Project: Iteration Two**         |

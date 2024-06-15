# README.md

### Overview

A speech therapist (Orthophonist) is a specialist in language rehabilitation. They help people of all ages who have difficulties with speech, language, communication, learning, and swallowing to promote their independence, well-being, and integration into their living environments. In this project (OOP, second year module, project), we aim to design and develop software to assist in managing a speech therapy practice by providing a simple and effective means for organizing appointments, taking care of, and monitoring patients.

### Installation

1. Download JDK 21 from the official website: [https://www.oracle.com/java/technologies/downloads/#java21](https://www.oracle.com/java/technologies/downloads/#java21)
2. Download JavaFX 22 SDK from the official website: [https://jdk.java.net/javafx22/](https://jdk.java.net/javafx22/)
3. Clone the repo and cd to it
```sh
git clone https://github.com/bndCom/Ortho-J.git
cd Ortho-J
```
4. Execute the JAR file
```sh
java --module-path "path\to\javafx-sdk-22.0.1\lib" --add-modules javafx.controls,javafx.fxml -jar .\build\libs\Ortho-J-1.0-SNAPSHOT-all.jar
```
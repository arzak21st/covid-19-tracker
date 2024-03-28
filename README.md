# COVID-19 Tracker ☕

A **Spring Boot** web application that obtains the global COVID-19 data of a specific date, 
and converts it (from CSV format) into readable HTML. </br>

The data is obtained from 
[COVID-19 Data Repository by the Center for Systems Science and Engineering (CSSE) at Johns Hopkins University](https://github.com/CSSEGISandData/COVID-19). </br>

## Live Demo 💻

- ### Requirements

  - [Java 11](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html) or higher.

- ### Steps

  - Download [this JAR file](https://github.com/arzak21st/covid-19-tracker/releases/download/v0.0.1-SNAPSHOT/covid-19-tracker-0.0.1-SNAPSHOT.jar).
  - Open your command-line and navigate to where your downloaded JAR file is located.
  - Run the JAR file with the following command:
      ```
      java -jar covid-19-tracker-0.0.1-SNAPSHOT.jar
      ```
  - Open the browser and navigate to the following URL:
      ```
      http://localhost:4869/covid-19-tracker
      ```

## Installation 🔌

- ### Requirements

  - [Java 11](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html) or higher.
  - [Maven](https://maven.apache.org/download.cgi).
  - [Git](https://git-scm.com/downloads).
  - [NetBeans 19](https://netbeans.apache.org/front/main/download/nb19/).
    > You can use any other Java IDE, just make sure it uses the mentioned **Java 11**, and **Maven**. </br>

- ### Steps

  - Press the **Fork** button (top right the page) to make a copy of this project on your own GitHub account.
  - Open **Git Bash** and navigate to where you want your forked project to be cloned.
  - Clone the project with the following command:
      ```
      git clone https://github.com/your-username/your-forked-project-name.git
      ```
      > Replace `your-username` with the actual username of your GitHub account, and `your-forked-project-name` with the actual name of your forked project. </br>
  - Open **NetBeans** (or any other Java IDE) and try to import your cloned project.

## Additional Information 🔥

On March 10, 2023, 
[the repository](https://github.com/CSSEGISandData/COVID-19) 
from which the global COVID-19 data is obtained, has stopped its reporting for some reason. 
Let's hope it never comes back! </br>

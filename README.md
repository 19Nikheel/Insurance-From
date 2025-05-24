Insurance Form Application
Overview
This is a Java Spring Boot application designed to manage insurance form data. The application allows users to submit insurance information either through a web form or by uploading an Excel sheet. It performs ambiguity checks on the data to ensure accuracy and consistency.

After processing, the application generates a downloadable Excel report. The report can be for either all users or a specific user, based on the request.

The project uses Apache POI library to read from and write to Excel files.

Features
Accept insurance form data via:

Web form input

Excel sheet upload

Perform ambiguity checks on input data to validate and highlight inconsistencies

Generate downloadable Excel reports using Apache POI

Support reports for all users or individual user data export

Technologies Used
Java 17+ (or your Java version)

Spring Boot Framework

Apache POI for Excel processing

Maven/Gradle for build management

How to Use
Run the application:

bash
Copy
Edit
mvn spring-boot:run
Submit data:

Via the web form on the frontend UI

Or upload an Excel sheet with user insurance data

Process data:

The system performs ambiguity checks to validate the entries

Download report:

Request Excel reports for all users or a single user

The generated Excel file will be available for download

Excel Template
Ensure uploaded Excel files follow the specified template with required columns such as:

User ID

Name

Insurance Policy Number

Coverage Details

Dates (Start, End)

Other relevant fields

Ambiguity Check
The system checks for:

Missing mandatory fields

Conflicting or inconsistent data entries

Duplicate records

Errors or warnings are flagged for user correction.

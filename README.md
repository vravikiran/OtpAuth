# Overview
- This application authenticates and authorizes an user using an otp sent to an email or mobile number.
- A user profile is created using an email and mobile number and other basic information
- A user is authenticated with the otp shared along with either mobile number or email.
- If a user doesn't exists with a given email or mobile number, An error message is displayed "User Not Found"
- If a user exists and checks user is authorized to perform an operation
- If a user is not authorized, an error message is displayed "Access is denied for user to perform this opertaion"
## There are three types of users
- Super admin - Allowed to create new admin users and Itineries
- Admin - allowed to create other admin users as well as Itineries
- Traveller - not permitted to create Itineries, permitted to view Itineries
- An admin/super admin user is allowed to create a new itinerary
## Prerequisites
- Java 17.0 or more
- Maven
- Twillio Account
- SMTP Server
- MySQL database / any Relation Database
## Getting Started
  - Setup and install Java, Maven, MySQL and execute the provided SQL scripts
  - Create a Twilio account using the url https://www.twilio.com/en-us, get "Account SID", "Auth token" and create a messaging serivce in Twilio and get "service id" and update them in application.properties file.
  - Create an SMTP server through cloud provider (ex: amazon ses) or any mail providers, get the login credentials and update the below properties in application.properties file.
    - "spring.mail.host" - SMTP Server
    - "spring.mail.username" - SMTP user name
    - "spring.mail.password" - SMTP password
  - Run the application and execute the API's

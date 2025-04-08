# Getting Started
- This application authenticates and authorizes an user using an otp sent to an email or mobile number.
- A user profile is created using an email and mobile number and other basic information
- A user is authenticated with the otp shared along with either mobile number or email.
- If a user doesn't exists with a given email or mobile number, An error message is displayed "User Not Found"
- If a user exists and checks user is authorized to perform an operation
## There are threee types of users
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


# User Managment System with USER,ADMIN AND SUPER-ADMIN

### overview
This project is a User Management System built using Spring Boot and Thymeleaf. The system allows for role-based authentication, with functionalities tailored for different types of users including Admin and Super Admin.

## Features
1. User Registration and Login:
   - New users can register with an email and password.
   - Users can log in based on their roles (e.g., Admin, Super Admin).
2. Role-Based Access Control:
   - Admin: Admins can manage regular users (add, edit, delete users).
   - Super Admin: Super Admins can manage both users and admins (add, edit, delete users and admins, change roles).
3. User Management:
   -View all users.
   - Delete users or admins.
   - Change user roles (e.g., from USER to ADMIN or vice versa).
4. Security
   - Implemented using Spring Security.
   - User authentication and authorization based on roles.

## Technologies Used
 - Java (Spring Boot Framework)
 - Spring Security (for Authentication and Authorization)
 - Thymeleaf (for server-side templating)
 - MySQL (for database management)
## Pages
 1. Registration Page: for user to Sign UP
 2. LogIn Page: for users to login
 3. Admin Page
 4. Super Admin Page
 5. user dashboard
 6. admin dashboard
 7. super admin dashboard

## How to Run the Project

  -  Clone the repository.
   -  Set up the MySQL database and configure (application.properties) to point to your database.
  -   Run the project using your preferred Java IDE.
   -  Access the application at http://localhost:8080.

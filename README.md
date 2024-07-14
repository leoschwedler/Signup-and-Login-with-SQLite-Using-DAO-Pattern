# Android App with SQLite Database for Login and Signup 📱

## 🌟 Overview
This project implements a user authentication system using SQLite database in an Android app. Users can sign up with a new account and log in using their credentials. The app securely stores user information and provides a seamless login experience.

## 🛠️ Project Structure
The project includes several key components designed for user management and authentication:

### Key Components
- **MainActivity**:
  - Controls the flow of the app.
  - Routes users to either the LoginActivity or SignupActivity based on their authentication status.

- **LoginActivity**:
  - Allows existing users to log in.
  - Validates user credentials against entries stored in the SQLite database.
  - Navigates to MainActivity upon successful login.

- **SignupActivity**:
  - Enables new users to create accounts.
  - Validates input fields and ensures uniqueness of email addresses.
  - Stores user information securely in the SQLite database upon successful registration.

- **UserDAO (Data Access Object)**:
  - Implements the DAO pattern for database operations.
  - Manages CRUD operations for User objects in the SQLite database.
  - Provides methods to insert new users (`createUser`), query existing users (`readUser`), update user details (`updateUser`), and delete users (`deleteUser`).

## 📷 Screenshots
<div style="display: flex; flex-wrap: wrap;">
  <img src="https://github.com/user-attachments/assets/4204c8df-8344-4c92-92a3-9dee22db4dd0" width="200" style="margin: 10px;"/>
  <img src="https://github.com/user-attachments/assets/2734ac8c-6955-45b2-8dee-701b68354f65" width="200" style="margin: 10px;"/>
  <img src="https://github.com/user-attachments/assets/fbc4d0f3-4e95-43fd-92db-fd4834f6581f" width="200" style="margin: 10px;"/>
</div>

## 🚀 Implemented Features
The project demonstrates the following functionalities:
- User authentication with SQLite database.
- User registration with email validation and password hashing.
- Seamless navigation between LoginActivity and SignupActivity.
- Integration of DAO pattern for efficient database operations.
- Secure storage of user credentials and personal information.

## 🛠️ Dependencies
- `androidx.room:room-runtime:2.5.0`: For SQLite database management.
- Additional libraries as needed for RecyclerView, CardView, etc.

## 📌 License
This project is open-source and available under the [MIT License](LICENSE).

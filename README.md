# RBAC Access Control System

## Project Overview

This project demonstrates the implementation of **Role-Based Access Control (RBAC)** using Java.

It was developed as part of the **Software Security – Chapter 4: Access Control** assignment.

The system assigns users to specific roles and determines which operations they are authorized to perform based on their assigned roles.

## Technologies Used

- Java
- Apache NetBeans IDE
- Role-Based Access Control (RBAC)

## Roles and Permissions

| Role | Create | View | Update | Delete |
|---|---|---|---|---|
| Admin | Yes | Yes | Yes | Yes |
| Manager | No | Yes | Yes | No |
| Customer | No | Yes | No | No |

## Users and Assigned Roles

| User | Role |
|---|---|
| Ali | Admin |
| Sara | Manager |
| Omar | Customer |

## How the System Works

1. The system defines three roles: Admin, Manager, and Customer.
2. Each role is assigned a set of permissions.
3. Users are assigned to their corresponding roles.
4. The system checks the user's role before allowing an operation.
5. If the role has the required permission, access is granted. Otherwise, access is denied.

## Project Structure

```text
RBAC_Access_Control/
├── src/
│   └── rbac_access_control/
│       └── RBAC_Access_Control.java
├── nbproject/
├── build.xml
└── manifest.mf
```

## How to Run

1. Download or clone the repository.
2. Open the project using Apache NetBeans IDE.
3. Make sure the Java Development Kit (JDK) is installed.
4. Open `RBAC_Access_Control.java`.
5. Run the project.
6. Check the output to see how access permissions are enforced.

## Security Concept

RBAC is an access control model in which permissions are assigned to roles rather than directly to individual users.

This approach simplifies permission management and supports the **Principle of Least Privilege**, ensuring users receive only the permissions required for their responsibilities.

## Course Information

**Course:** Software Security  
**Chapter:** Chapter 4 – Access Control  
**Implementation:** Java RBAC System

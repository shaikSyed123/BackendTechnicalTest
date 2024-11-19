# User Notification Preferences API

A Spring Boot application for managing user notification preferences and sending notifications. 
The API allows users to set preferences for notification types and delivery channels while providing endpoints to send and track notifications.

## Features

- **User Preferences Management**
  - Create, update, and delete user notification preferences.

## API Endpoints

### **User Preferences**
- **POST /api/preferences**
  Create new preferences for a user.

- **GET /api/preferences/:userId**
  Retrieve preferences for a specific user.

- **PATCH /api/preferences/:userId**
  Update preferences for a user.

- **DELETE /api/preferences/:userId**
  Delete preferences for a user.

### **Notification Management**
- **POST /api/notifications/send**
  Send a simulated notification.

- **GET /api/notifications/:userId/logs**
  Retrieve logs of notifications sent to a specific user.

- **GET /api/notifications/stats**
  View aggregated statistics of sent notifications .
  
  
  ## Technologies Used

- **Spring Boot**: For backend development.
- **mysql**: To store user preferences and notification logs.
- **Maven**: Dependency management.
- **JUnit**: For unit and integration testing.
- **Postman**: For API documentation (if applicable).
  

package com.mycompany.banking_management_system;

// Class to store and manage user information
public class UserInformation {

    private String userId, userName, password;

    // Constructor to initialize UserInformation
    public UserInformation(String userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    // Setter and Getter methods
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    // Method to display User Information
    public void displayInformation() {
        System.out.println("User ID : " + userId);
        System.out.println("User Name : " + userName);
        System.out.println();
    }

    // Main method to test the class
    public static void main(String[] args) {

        // Creating an object of UserInformation using constructor
        UserInformation user1 = new UserInformation("U101", "kafayet", "12345");

        // Display user information
        System.out.println("=== Displaying User Information ===");
        user1.displayInformation();

        // Changing user information using setter methods
        user1.setUserName("Md kafayetullah");
        user1.setPassword("67890");

        // Getting updated values using getter methods
        System.out.println("=== Updated Information ===");
        System.out.println("User ID: " + user1.getUserId());
        System.out.println("User Name: " + user1.getUserName());
        System.out.println("Password: " + user1.getPassword());
    }
}

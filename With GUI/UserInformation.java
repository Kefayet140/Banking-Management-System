
package com.mycompany.banking_management_system;


public class UserInformation {
    private String userId, userName, password;

    public UserInformation(String userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void displayInformation() {
        System.out.println("User ID: " + userId);
        System.out.println("User Name: " + userName);
    }
}
    

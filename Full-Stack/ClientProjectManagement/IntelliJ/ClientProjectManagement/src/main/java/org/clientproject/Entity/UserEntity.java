package org.clientproject.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;
    private String userName;
    private String userPassword;
    private int userLevel; // This determines what "level" of access the user has.

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public UserEntity(int userID, String userName, String userPassword, int userLevel) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userLevel = userLevel;
    }
}

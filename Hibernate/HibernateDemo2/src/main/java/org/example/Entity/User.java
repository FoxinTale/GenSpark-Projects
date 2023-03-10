package org.example.Entity;

public class User {
    private int User_ID;
    private String User_Name;
    private String User_Password;
    private String User_Email;
    private boolean User_IsAdmin;

    public User(){

    }

    public User(int user_ID, String user_Name, String user_Password, String user_Email, boolean user_IsAdmin) {
        User_ID = user_ID;
        User_Name = user_Name;
        User_Password = user_Password;
        User_Email = user_Email;
        User_IsAdmin = user_IsAdmin;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getUser_Password() {
        return User_Password;
    }

    public void setUser_Password(String user_Password) {
        User_Password = user_Password;
    }

    public String getUser_Email() {
        return User_Email;
    }

    public void setUser_Email(String user_Email) {
        User_Email = user_Email;
    }

    public boolean isUser_IsAdmin() {
        return User_IsAdmin;
    }

    public void setUser_IsAdmin(boolean user_IsAdmin) {
        User_IsAdmin = user_IsAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "User_ID=" + User_ID +
                ", User_Name='" + User_Name + '\'' +
                ", User_Password='" + User_Password + '\'' +
                ", User_Email='" + User_Email + '\'' +
                ", User_IsAdmin=" + User_IsAdmin +
                '}';
    }
}

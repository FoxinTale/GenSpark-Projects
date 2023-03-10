package org.example.Entity;


import org.hibernate.annotations.Entity;

import javax.persistence.Id;


@Entity
public class Character {
    @Id
    private int char_ID;
    private int Char_User_ID; // Should be a Foreign Key (from Users), but I'm not quite sure how to set this.
    private String Char_Name;
    private String Char_ShortName;
    private String Char_ShortDesc;
    private String Char_Age;
    private String Char_Gender;
    private String Char_RaceName;

    public Character(){

    }
// In practice, we'd want only just one.
    public Character(int char_ID, int char_User_ID, String char_Name, String char_ShortDesc, String char_Age, String char_Gender) {
        this.char_ID = char_ID;
        Char_User_ID = char_User_ID;
        Char_Name = char_Name;
        Char_ShortDesc = char_ShortDesc;
        Char_Age = char_Age;
        Char_Gender = char_Gender;
    }

    public Character(int char_ID, int char_User_ID, String char_Name, String char_ShortName,
                     String char_ShortDesc, String char_Age, String char_Gender, String char_RaceName) {
        this.char_ID = char_ID;
        Char_User_ID = char_User_ID;
        Char_Name = char_Name;
        Char_ShortName = char_ShortName;
        Char_ShortDesc = char_ShortDesc;
        Char_Age = char_Age;
        Char_Gender = char_Gender;
        Char_RaceName = char_RaceName;
    }

    public int getChar_ID() {
        return char_ID;
    }

    public void setChar_ID(int char_ID) {
        this.char_ID = char_ID;
    }

    public int getChar_User_ID() {
        return Char_User_ID;
    }

    public void setChar_User_ID(int char_User_ID) {
        Char_User_ID = char_User_ID;
    }

    public String getChar_Name() {
        return Char_Name;
    }

    public void setChar_Name(String char_Name) {
        Char_Name = char_Name;
    }

    public String getChar_ShortName() {
        return Char_ShortName;
    }

    public void setChar_ShortName(String char_ShortName) {
        Char_ShortName = char_ShortName;
    }

    public String getChar_ShortDesc() {
        return Char_ShortDesc;
    }

    public void setChar_ShortDesc(String char_ShortDesc) {
        Char_ShortDesc = char_ShortDesc;
    }

    public String getChar_Age() {
        return Char_Age;
    }

    public void setChar_Age(String char_Age) {
        Char_Age = char_Age;
    }

    public String getChar_Gender() {
        return Char_Gender;
    }

    public void setChar_Gender(String char_Gender) {
        Char_Gender = char_Gender;
    }

    public String getChar_RaceName() {
        return Char_RaceName;
    }

    public void setChar_RaceName(String char_RaceName) {
        Char_RaceName = char_RaceName;
    }

    @Override
    public String toString() {
        return "Character{" +
                "char_ID=" + char_ID +
                ", Char_User_ID=" + Char_User_ID +
                ", Char_Name='" + Char_Name + '\'' +
                ", Char_ShortName='" + Char_ShortName + '\'' +
                ", Char_ShortDesc='" + Char_ShortDesc + '\'' +
                ", Char_Age='" + Char_Age + '\'' +
                ", Char_Gender='" + Char_Gender + '\'' +
                ", Char_RaceName='" + Char_RaceName + '\'' +
                '}';
    }
}

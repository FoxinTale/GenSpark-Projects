package com.genspark.SimpleSpringbootDemoApp.Entity;

import jakarta.persistence.*;

@Entity
// @Table(name="tbl_courses") // Manual table name changing. Courses makes sense to me.
public class Course {


    @Id // Sets the following variable as the primary key.
    // @Column(name="c_ID") // If we want it to have a different name. courseID makes the most sense to me as its self-explanatory, but this is left in as a note.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseID;
    private String courseName;
    private String courseInstructor;

    public Course() {

    }

    public Course(String courseName, String courseInstructor) {
        this.courseName = courseName;
        this.courseInstructor = courseInstructor;
    }

    public Course(int courseID, String courseName, String courseInstructor) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseInstructor = courseInstructor;
    }


    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }
}

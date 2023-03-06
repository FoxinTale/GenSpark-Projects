package com.genspark.SimpleSpringbootDemoApp.Service;

import com.genspark.SimpleSpringbootDemoApp.Entity.Course;

import java.util.List;

public interface courseServiceInterface {
    List<Course> getAllCourses();
    Course getCourseByID(Integer id);

    Course addCourse(Course c);

    Course updateCourse(Course c);

    String deleteCourseByID(int courseID);
}

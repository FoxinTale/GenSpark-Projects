package com.genspark.SimpleSpringbootDemoApp.Service;

import com.genspark.SimpleSpringbootDemoApp.Entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService implements courseServiceInterface {

    List<Course> courseList; // IOf a database was used, it would be here instead.

    public CourseService(){
        courseList = new ArrayList<>();
        courseList.add(new Course(101, "Intro to Meteorology", "Azaria"));
        courseList.add(new Course(201, "Advanced Meteorology", "Azaria"));
        courseList.add(new Course(301, "Functional Meteorology", "Hatzos")); // the actual name of my local forecaster at the weather service.
    }

    @Override
    public List<Course> getAllCourses() {
        return courseList;
    }

    @Override
    public Course getCourseByID(Integer courseID) {
        Course returnCourse = null;

        for(Course course:courseList){
            if(course.getCourseID() == courseID){
                returnCourse = course;
                break;
            }
        }
        return returnCourse;
    }

    @Override
    public Course addCourse(Course c) {
        courseList.add(c);
        return c;
    }

    // We cannot update the ID, as, were this a relational DB the ID is the primary key and that should not be changed.
    @Override
    public Course updateCourse(Course c) {
        String title = c.getCourseName();
        String instructor = c.getCourseInstructor();

        Course course = null;

        for(Course e:courseList){
            if(e.getCourseID()==c.getCourseID()){
                e.setCourseName(title);
                e.setCourseInstructor(instructor);
                course = e;
                break;
            }
        }

        return course;
    }

    @Override
    public String deleteCourseByID(int courseID) {

        for(Course course:courseList){
            if(course.getCourseID() == courseID){
                courseList.remove(course);
                break;
            }
        }
        return "Deleted the course.";
    }
}

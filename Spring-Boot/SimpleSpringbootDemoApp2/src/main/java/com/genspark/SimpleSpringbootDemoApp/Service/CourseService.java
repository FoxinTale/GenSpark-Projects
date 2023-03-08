package com.genspark.SimpleSpringbootDemoApp.Service;

import com.genspark.SimpleSpringbootDemoApp.Db.CourseDB;
import com.genspark.SimpleSpringbootDemoApp.Entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements courseServiceInterface {

    List<Course> courseList; // IOf a database was used, it would be here instead.
    private CourseDB courseDB;

    public CourseService(){
        courseList = new ArrayList<>();
        courseList.add(new Course(101, "Intro to Meteorology", "Azaria")); // I pulled this name out of nowhere, but it has a mystical sound to it.
        courseList.add(new Course(201, "Advanced Meteorology", "Azaria"));
        courseList.add(new Course(301, "Functional Meteorology", "Hatzos")); // the actual name of my local forecaster at the weather service.
    }

    @Override
    public List<Course> getAllCourses() {
        return this.courseDB.findAll();
    }

    @Override
    public Course getCourseByID(Integer courseID) {
        Optional<Course> c = this.courseDB.findById(courseID);
        // Essentially, this checks if the course ID actually exists or not.
        Course course = null;
        if(c.isPresent()){
            course = c.get();
        } else {
            throw new RuntimeException("Course ID not found for ID " + courseID);
        }
        return course;
    }

    @Override
    public Course addCourse(Course course) {
    return this.courseDB.save(course);
    }

    // We cannot update the ID, as, were this a relational DB the ID is the primary key and that should not be changed.
    @Override
    public Course updateCourse(Course course) {
        return this.courseDB.save(course);
    }

    @Override
    public String deleteCourseByID(int courseID) {
        this.courseDB.deleteById(courseID);
        return "Deleted the course.";
    }
}

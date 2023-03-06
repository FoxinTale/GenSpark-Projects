package com.genspark.SimpleSpringbootDemoApp.Controller;


import com.genspark.SimpleSpringbootDemoApp.Entity.Course;
import com.genspark.SimpleSpringbootDemoApp.Service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {


    // Note that "?name=<name>&msg=<message>" can be typed directly into the URL to manipulate what is displayed.
    /*
    public String home(@RequestParam(value="name", defaultValue="World") String name, @RequestParam(value="msg", defaultValue = "Good morning.")String msg){
        return "Hello " + name + " " + msg;
    }

     */
    private CourseService courseService;

    @GetMapping("home")
    public String home(){
        return "<html><h1> Welcome to course applications.</h1/</html>";
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseService.getAllCourses();
    }

    // In practice, we really should have *some* sort of input validation as otherwise it could fail if the user inputs a non-integer.
    // Never *ever* trust the users input, and sanitize the input as much as possible.
    @GetMapping("/courses/{courseID")
    public Course getCourse(@PathVariable String courseID){
        return this.courseService.getCourseByID(Integer.parseInt(courseID));
    }

    @GetMapping("/courses")
    public Course addCourse(@RequestBody Course course){
       return this.courseService.addCourse(course);
    }

    @GetMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }


    @DeleteMapping("/courses/{courseID")
    public String deleteCourse(String courseID){
        return this.courseService.deleteCourseByID(Integer.parseInt(courseID));
    }
}

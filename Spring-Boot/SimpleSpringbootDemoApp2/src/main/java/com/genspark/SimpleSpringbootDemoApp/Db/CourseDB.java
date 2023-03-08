package com.genspark.SimpleSpringbootDemoApp.Db;

import com.genspark.SimpleSpringbootDemoApp.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDB extends JpaRepository<Course, Integer> {


}

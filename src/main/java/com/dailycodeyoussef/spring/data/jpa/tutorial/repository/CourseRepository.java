package com.dailycodeyoussef.spring.data.jpa.tutorial.repository;

import com.dailycodeyoussef.spring.data.jpa.tutorial.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

}

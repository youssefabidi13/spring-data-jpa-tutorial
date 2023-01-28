package com.dailycodeyoussef.spring.data.jpa.tutorial.repository;

import com.dailycodeyoussef.spring.data.jpa.tutorial.entity.Course;
import com.dailycodeyoussef.spring.data.jpa.tutorial.entity.Student;
import com.dailycodeyoussef.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses =
                courseRepository.findAll();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher =
                Teacher.builder()
                        .firstName("Youssef")
                        .lastName("Abidi")
                        .build();
        Course course =
                Course.builder()
                        .courseTitle("Python")
                        .credit(6)
                        .teacher(teacher)
                        .build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        PageRequest firstPagewithThreeRecords =
                 PageRequest.of(0,3);
        PageRequest secondPagewithTwoRecords =
                 PageRequest.of(1,2);
        List<Course> courses =
                courseRepository.findAll(firstPagewithThreeRecords)
                        .getContent();
        long totalElements  =
                courseRepository.findAll(firstPagewithThreeRecords)
                                .getTotalElements();
        long totalPages =
                courseRepository.findAll(firstPagewithThreeRecords)
                                .getTotalPages();
        System.out.println("courses = " + courses);

        System.out.println("totalElements = " + totalElements);

        System.out.println("totalPages = " + totalPages);
    }
    @Test
    public void findAllSorting(){
        PageRequest sortByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("courseTitle").ascending()
                );

        PageRequest sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );
        List<Course> courses =
                courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher =
                Teacher.builder()
                        .firstName("Diego")
                        .lastName("Maradona")
                        .build();
        Student student = Student
                .builder()
                .emailId("uceeef@gmail.cooom")
                .firstName("youssef")
                .firstName("ab")
                .build();
        Course course = Course
                .builder()
                .courseTitle("AI")
                .credit(12)
                .teacher(teacher)
                .build();
        course.addStudent(student);
        courseRepository.save(course);
    }
}











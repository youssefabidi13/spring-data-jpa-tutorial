package com.dailycodeyoussef.spring.data.jpa.tutorial.repository;

import com.dailycodeyoussef.spring.data.jpa.tutorial.entity.Course;
import com.dailycodeyoussef.spring.data.jpa.tutorial.entity.CourseMaterial;
import com.dailycodeyoussef.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class teacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseJPA = Course.builder()
                .courseTitle("Jpa")
                .credit(5)
                .build();
        Course courseJAVA = Course.builder()
                .courseTitle("Java")
                .credit(5)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Leo")
                .lastName("Messi")
        //        .courses(List.of(courseJAVA,courseJPA))
                .build();
        teacherRepository.save(teacher);
    }
}
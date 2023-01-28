package com.dailycodeyoussef.spring.data.jpa.tutorial.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dailycodeyoussef.spring.data.jpa.tutorial.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);
    Student findByFirstNameAndLastName(String firstName,String lastName);
    //JPQL base on class
    @Query("select s from Student s where s.emailId =?1")
    Student getStudentByEmailAddress(String emailId);

    //JPQL base on class
    @Query("select s.firstName from Student s where s.emailId =?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    //Native base on db
    @Query(
            value="select * from tbl_student s where s.email_address =?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    //Native base on db named param
    @Query(
            value="select * from tbl_student s where s.email_address =:emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(
            @Param("emailId") String emailId
    );

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address=?2 ",
            nativeQuery = true
    )
    int updateStudentNamedByEmail(String firstName , String emailId);
}















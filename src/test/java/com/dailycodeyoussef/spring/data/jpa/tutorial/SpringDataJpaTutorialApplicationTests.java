package com.dailycodeyoussef.spring.data.jpa.tutorial;

import com.dailycodeyoussef.spring.data.jpa.tutorial.entity.Guardian;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dailycodeyoussef.spring.data.jpa.tutorial.entity.Student;
import com.dailycodeyoussef.spring.data.jpa.tutorial.repository.StudentRepository;

import java.util.List;

@SpringBootTest
class SpringDataJpaTutorialApplicationTests {
	
	@Autowired
	private StudentRepository studentRepository;
	
//	@Test
//	public void saveStudent() {
//		Student student = Student.builder()
//				.emailId("youssef.abidi@etu.uae.ac.ma")
//				.firstName("Youssef")
//				.lastName("Abidi")
//				//.guardianName("Leo")
//				//.guardianEmail("Leo@gmail.com")
//				//.guardianMobile("0000000000000")
//				.build();
//		studentRepository.save(student);
//	}

	@Test
	public void printAllStudent(){

		List<Student> studentList =
				studentRepository.findAll();
		System.out.println("studentList = " + studentList);
	}
	@Test
	public void saveStudentWithGuardian(){
		Guardian guardian = Guardian.builder()
				.email("maradona@gmail.com")
				.name("maradona")
				.mobile("0000022200")
				.build();
		Student student = Student.builder()
				.firstName("Ucef")
				.lastName("Ab")
				.emailId("youssef@gmail.com")
				.guardian(guardian)
				.build();
		studentRepository.save(student);
	}
	@Test
	public void printStudentByFirstName(){
		List<Student> students =
				studentRepository.findByFirstName("Youssef");
		System.out.println("Student = " + students);
	}

	@Test
	public void printStudentByFirstNameContaining(){
		List<Student> students =
				studentRepository.findByFirstNameContaining("ef");
		System.out.println("Student = " + students);
	}
	@Test
	public void printStudentBasedOnGuardiaName(){
		List<Student> students =
				studentRepository.findByGuardianName("Leo");
		System.out.println("Student = " + students);
	}

	@Test
	public void printGetStudentByEmailAddress(){
		Student student =
				studentRepository.getStudentByEmailAddress("youssef.abidi@etu.uae.ac.ma");

		System.out.println(student);
	}

	@Test
	public void printGetStudentFirstNameByEmailAddress(){
		String name = studentRepository.getStudentFirstNameByEmailAddress("youssef.abidi@etu.uae.ac.ma");
		System.out.println(name);
	}

	@Test
	public void printgetStudentByEmailAddressNative(){
		Student student =
				studentRepository.getStudentByEmailAddressNative("youssef.abidi@etu.uae.ac.ma");
	}

	@Test
	public void updateStudentNamedByEmailId(){
		studentRepository.updateStudentNamedByEmail("Ussef","youssef.abidi@etu.uae.ac.ma");
	}
}





























package com.dailycodeyoussef.spring.data.jpa.tutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder //build method that returns an instance of the parent class with all fields set. This can make it more convenient to create and initialize objects, especially if there are many fields or some of them are required.
@Table(
		name="tbl_student",
		uniqueConstraints = 
				@UniqueConstraint (
						name="emailid_unique",
						columnNames = "email_address"
						)
		)
@Data //When applied to a class, it will automatically generate getters, setters, toString, equals, and hashCode methods
@AllArgsConstructor //The "@AllArgsConstructor" annotation in Lombok is used to generate a constructor for a Java class that takes all of the class's fields as arguments.
@NoArgsConstructor //constructor without argument

public class Student {
	
	@Id
	@SequenceGenerator(
			name="student_sequence",
			sequenceName="student_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator ="student_sequence"
			)
	private Long studentId;
	private String firstName;
	private String lastName;
	
	@Column(
			name="email_address",
			nullable = false
			)
	private String emailId;
	@Embedded
	private Guardian guardian;
	
}

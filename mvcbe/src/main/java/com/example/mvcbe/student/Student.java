package com.example.mvcbe.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String studentId;
	String name;
	String nickName;
	int marks;
	public Student(String studentId, String name, String nickName, int marks) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.nickName = nickName;
		this.marks = marks;
	}
	
	

}
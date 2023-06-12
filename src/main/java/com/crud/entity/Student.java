package com.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentID;
	private String studentName;
	private int studentClass;
	private int studentPercentage;
	private String studentCity;
	
	public Student(int studentID, String studentName, int studentClass, int studentPercentage, String studentCity) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentClass = studentClass;
		this.studentPercentage = studentPercentage;
		this.studentCity = studentCity;
		
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
	}

	public int getStudentPercentage() {
		return studentPercentage;
	}

	public void setStudentPercentage(int studentPercentage) {
		this.studentPercentage = studentPercentage;
	}

	public String getStudentCity() {
		return studentCity;
	}

	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", studentName=" + studentName + ", studentClass=" + studentClass
				+ ", studentPercentage=" + studentPercentage + ", studentCity=" + studentCity + "]";
	}
	
	
	

}

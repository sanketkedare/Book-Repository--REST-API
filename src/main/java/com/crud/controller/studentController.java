package com.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crud.entity.Student;
import com.crud.repo.StudentRepo;


@RestController
public class studentController 
{
	//Declare and Autowire StudentRepository
	
	@Autowired
	StudentRepo repo;
	
	
	
	
	//Performing Read operation for All Student
	
	@GetMapping(value = "/students")
	public ResponseEntity<List<Student>> getAllStudent() 
	{
		List<Student> list = (List<Student>) repo.findAll();
		
		if (list.size() <= 0) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	
	
    //Performing Read operation for single Student
	
	@GetMapping(value = "/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) 
	{
		Student student = repo.findById(id);
		
		if (student == null) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(student));
	}
	

	//Performing Create Operation of single student
	
	@PostMapping("/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) 
	{
		Student student1 = null;
		try 
		{
			student1 = this.repo.save(student);
			System.out.println(student1);

			return ResponseEntity.of(Optional.of(student1));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	
	//Performing Delete operation of single student by Id
	
	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<Void> deletestudent(@PathVariable("studentId") int studentId) 
	{
		try 
		{
			this.repo.deleteById(studentId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	
	//Performing Update operation of single Student
	
	@PutMapping("/students/{studentId}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student,
			                                     @PathVariable("studentId") int studentId) 
	{
		try 
		{
			Student student2 = repo.findById(studentId);
			
			if(student2 != null)
			{
				student2.setStudentID(studentId);
				student2.setStudentCity(student.getStudentCity());
				student2.setStudentClass(student.getStudentClass());
				student2.setStudentName(student.getStudentName());
				student2.setStudentPercentage(student.getStudentPercentage());
				
				repo.deleteById(studentId);
			}
			else 
			{
				throw new Exception();
			}
			
			this.repo.save(student2);
			return ResponseEntity.ok().body(student2);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}


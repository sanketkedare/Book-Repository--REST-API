package com.crud.repo;

import org.springframework.data.repository.CrudRepository;

import com.crud.entity.Student;


//Creating Student Repository to Perform operation with Database
//We can extend JpaRepository also

public interface StudentRepo extends CrudRepository<Student, Integer> 
{
	
	//Created Method by own using Standard Protocol
	//Just for Example
	
	public Student findById(int id);

}

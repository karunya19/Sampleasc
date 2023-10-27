package com.example.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.model.Student;
import com.example.web.service.StudentService;

@RestController  
public class StudentController   
{  
 
		@Autowired  
		StudentService studentService;  
		
		
		// all the students detail   
		@GetMapping("/student")  
		private List<Student> getAllStudent()   
		{  
		return studentService.getAllStudent();  
		}
		
		
		
		// the detail of a specific student  
		@GetMapping("/student/{id}")  
		private Student getStudent(@PathVariable("id") Integer id)   
		{  
		return studentService.getStudentById(id);  
		}  
		
		
		//delete mapping that deletes a specific student  
		@DeleteMapping("/student/{id}")  
		private void deleteStudent(@PathVariable("id") Integer id)   
		{  
		studentService.delete(id);  
		}  
		
		
		@PutMapping("/student/{id}")
		private Student modifyOrUpdate(@RequestBody Student student, @PathVariable("id") int id)
		{
		Student students=studentService.modifyUpdate(id,student );
		return students;
		}
		
		// post the student detail  
		@PostMapping("/student")  
		private int saveStudent(@RequestBody Student student)   
		{  
		studentService.saveOrUpdate(student);  
		return student.getId();  
		}  
}  
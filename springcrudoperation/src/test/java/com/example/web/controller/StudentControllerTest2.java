package com.example.web.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.web.model.Student;
import com.example.web.service.StudentService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StudentControllerTest2 {

	@Mock
	StudentService studentService;

	@Test
	void getStudent() {

	    Student student = new Student();
	    student.setId(0);
	    student.setName("karu sm");
	    
	    studentService.saveOrUpdate(student);
	    assertEquals(0,student.getId());
	}

	@Test
	void getList() {
		Student student = new Student();
		student.setId(2);
		student.setName("ananth sm");

		Student student1 = new Student();
		student1.setId(3);
		student1.setName("namu sm");

		studentService.saveOrUpdate(student);
		studentService.saveOrUpdate(student1);

		List<Student> list = new ArrayList<>();
		list.add(student);
		list.add(student1);

		when(studentService.getAllStudent()).thenReturn(list);
		assertEquals(list, studentService.getAllStudent());
	}

	@Test
	void saveStudentRecord() {
		Student student = new Student();
		student.setId(4);
		student.setName("prathi");

		studentService.saveOrUpdate(student);
		assertEquals("prathi", student.getName());
	}

	@Test
	void editStudent() {
		Student student = new Student();
		student.setId(0);
		student.setName("Karunya");
		student.setAge(24);
		student.setEmail("k@gmail.com");

		studentService.saveOrUpdate(student);
		student.setName("Karunya a");
		student.setAge(24);
		student.setEmail("k@gmail.com");

		studentService.modifyUpdate(student.getId(),student);
		assertEquals("Karunya a", student.getName());
	}

}

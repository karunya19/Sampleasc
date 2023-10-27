package com.example.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web.model.Student;
import com.example.web.repo.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;

	// getting all student records
	public List<Student> getAllStudent() {
		List<Student> students = new ArrayList<Student>();
		studentRepository.findAll().forEach(student -> students.add(student));
		return students;
	}

	// getting a specific record
	public Student getStudentById(Integer id) {
		return studentRepository.findById(id).get();
	}

	public void saveOrUpdate(Student student) {
		studentRepository.save(student);
	}

	// deleting a specific record
	public void delete(Integer id) {
		studentRepository.deleteById(id);
	}

	public Student modifyUpdate(Integer id, Student student) {
		Student oldDetails = studentRepository.findById(id).get();
		oldDetails.setAge(student.getAge());
		oldDetails.setName(student.getName());
		oldDetails.setEmail(student.getEmail());
		Student upDated = studentRepository.save(oldDetails);

		// TODO Auto-generated method stub
		return upDated;
	}
}

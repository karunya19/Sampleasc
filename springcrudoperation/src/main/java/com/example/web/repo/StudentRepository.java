package com.example.web.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.web.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>  
{  
}  

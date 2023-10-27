package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Fact;
import com.example.demo.service.FactService;




@RestController
public class FactController
{
	@Autowired 
	private FactService factService;
	@GetMapping("/get")
	
	public ResponseEntity<Fact> getData(){
		
		try {
			return new ResponseEntity<>(factService.consumeAPI(),HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
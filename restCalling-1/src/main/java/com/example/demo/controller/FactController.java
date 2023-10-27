package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Fact;
import com.example.demo.service.FactService;


@RestController
@RequestMapping("/fact")
public class FactController
{
	@Autowired 
	private FactService factService;
	
	
	
	@GetMapping("/get")
	public Fact getData(){
		
			Fact obj=factService.consumeAPI();
			
			return obj;
	
	}
	
}
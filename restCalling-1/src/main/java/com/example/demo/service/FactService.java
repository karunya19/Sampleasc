package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.module.Fact;

@Service
public class FactService {

	@Autowired
	private RestTemplate restTemplate;
	
	public Fact consumeAPI() {
		String url="https://catfact.ninja/fact";
		
		RestTemplate rest=new RestTemplate();
		Fact obj=rest.getForObject(url, Fact.class);
		
		return obj;
	}
}

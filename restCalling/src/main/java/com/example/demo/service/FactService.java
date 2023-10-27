package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Fact;

@Service
public class FactService {

	@Autowired
	private RestTemplate restTemplate;
	
	public Fact consumeAPI() {
		return restTemplate.getForObject("https://catfact.ninja/fact", Fact.class);
	}
}

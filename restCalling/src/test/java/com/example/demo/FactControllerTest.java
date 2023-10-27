package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.model.Fact;

class FactControllerTest {

	@Test
	void test() {
		Fact fact = new Fact();
		fact.setFact("hello");
		fact.setLength(50);
	}

}

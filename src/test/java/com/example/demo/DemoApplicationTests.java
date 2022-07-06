package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.controller.DemoController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	DemoController controller;

	@Test
	void contextLoads() {
		Assertions.assertThat(controller).isNotNull();
	}

}

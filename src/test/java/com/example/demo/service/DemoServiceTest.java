package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.EmployeeInfo;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DemoServiceTest {
	
	@Autowired
	DemoService demoService;
	
	@Test
	public void testGetEmpInfo()	{
		EmployeeInfo info = demoService.getEmpInfo("1");
		Assertions.assertThat(info).isNotNull();
		assertEquals("Malay Chakrabarty", info.getEmpName());
	}
	
}

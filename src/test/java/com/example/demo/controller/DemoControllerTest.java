package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.entity.EmployeeInfo;
import com.example.demo.service.DemoService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DemoController.class)
public class DemoControllerTest {
	
	@Autowired
	DemoService service;
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	TestEntityManager em;
	
	@Test
	public void testGetEmpDetails() throws Exception	{

		EmployeeInfo emp = new EmployeeInfo();
		emp.setEmpid(10l);
		emp.setEmpName("Amalesh Panda");
		emp.setEmpAddress("Harinavi");

		Mockito.when(service.getEmpInfo("1")).thenReturn(emp);

		mockMvc.perform(get("/getDetails"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$empName", Matchers.is("Amalesh Panda")));
	}

}

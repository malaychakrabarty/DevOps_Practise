package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.EmployeeInfo;
import com.example.demo.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest
public class DemoServiceTestMock {
	
	@InjectMocks
	DemoServiceImpl demoService;
	
	@Mock
	EmployeeRepository repo;
	
	@Test
	public void testGetEmpInfoUsingMock()	{
		
		EmployeeInfo emp = new EmployeeInfo();
		emp.setEmpid(10l);
		emp.setEmpName("Narendra Modi");
		emp.setEmpAddress("Gujrat");
		
		when(repo.findByEmpName("Narendra Modi")).thenReturn(Optional.ofNullable(emp));
		
		EmployeeInfo info = demoService.getEmpInfoByName("Narendra Modi");
		
		assertEquals("Narendra Modi", info.getEmpName());
		
		verify(repo, times(1)).findByEmpName("Narendra Modi");
	}

}

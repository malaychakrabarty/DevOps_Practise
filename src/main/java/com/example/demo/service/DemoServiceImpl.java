package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeInfo;
import com.example.demo.repository.EmployeeRepository;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	EmployeeRepository repository;
	
	@Override
	public EmployeeInfo getEmpInfo(String empid)	{
		return repository.findById(Long.valueOf(empid)).orElse(new EmployeeInfo());
	}
}

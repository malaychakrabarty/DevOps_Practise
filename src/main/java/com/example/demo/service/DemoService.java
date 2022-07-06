package com.example.demo.service;

import com.example.demo.entity.EmployeeInfo;

public interface DemoService {

	EmployeeInfo getEmpInfo(String empid);
	
	EmployeeInfo getEmpInfoByName(String empName);
	
	EmployeeInfo createOrUpdateEmployee(EmployeeInfo info); 

}

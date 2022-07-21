package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DemoService;

@RestController
public class DemoController {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	DemoService demoService;
	
	@GetMapping ("/getDetails")
	public String getEmpDetails(Model model,@RequestParam(name = "empid", required = false, defaultValue = "1") String empid)	{
		logger.info( "Employee ID :"+empid);
		logger.info(demoService.getEmpInfo(empid).toString());
		model.addAttribute("name", demoService.getEmpInfo(empid).getEmpName());
		return "Hello " + demoService.getEmpInfo(empid).getEmpName();
	}

}

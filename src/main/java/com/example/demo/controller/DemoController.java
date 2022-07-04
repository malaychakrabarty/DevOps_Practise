package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.DemoService;

@RestController
public class DemoController {
	
	@Autowired
	DemoService demoService;
	
	@GetMapping ("/getDetails")
	public String getEmpDetails(Model model,@RequestParam(name = "empid", required = false, defaultValue = "999") String empid)	{
		System.out.println( "Employee ID :"+empid);
		System.out.println(demoService.getEmpInfo(empid));
		//ModelAndView mv  = new ModelAndView();
		model.addAttribute("name", demoService.getEmpInfo(empid).getEmpName());
		//return "Hello " + demoService.getEmpInfo(empid).getEmpName();
		return "employee";
	}

}

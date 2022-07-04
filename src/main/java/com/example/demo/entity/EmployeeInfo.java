package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_INFO")
public class EmployeeInfo {
	
	@Id
	@Column(name = "EMP_ID")
	private Long empid;
	
	@Column(name = "EMP_NAME")
	private String empName;
	
	@Column(name = "EMP_ADDRESS")
	private String empAddress;

	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	
	@Override
	public String toString()	{
		return this.getEmpid() + " ,  " + this.getEmpName() + " , " + this.getEmpAddress();
	}

}

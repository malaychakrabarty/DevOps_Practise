package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EmployeeInfo;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeInfo, Long>	{

	Optional<EmployeeInfo> findByEmpName(String empName);

}

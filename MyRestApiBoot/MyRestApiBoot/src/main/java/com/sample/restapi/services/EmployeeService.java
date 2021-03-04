package com.sample.restapi.services;

import java.util.List;

import com.sample.restapi.domain.EmployeeData;

public interface EmployeeService {

	public EmployeeData createEmployee(EmployeeData empdata);

	public EmployeeData getEmployeeDetails(Long empid);

	public List<EmployeeData> getAllEmployeeDetails();

	public EmployeeData updateEmployee(EmployeeData empdata);

	public void deleteEmployee(Long empid);

}

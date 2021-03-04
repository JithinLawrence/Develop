package com.sample.restapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.restapi.domain.EmployeeData;
import com.sample.restapi.exception.CustomException;
import com.sample.restapi.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public EmployeeData createEmployee(EmployeeData empdata) {
		EmployeeData employee = employeeRepo.save(empdata);
		return employee;
	}

	@Override
	public EmployeeData getEmployeeDetails(Long empid) {
		Optional<EmployeeData> empDetails = employeeRepo.findById(empid);
		if (!empDetails.isPresent()) {
			throw new CustomException("No Record Found");
		}
		return empDetails.get();
	}

	
	
	
	
	@Override
	public List<EmployeeData> getAllEmployeeDetails() {
		List<EmployeeData> empDetails = employeeRepo.findAll();
		return empDetails;
	}

	@Override
	public EmployeeData updateEmployee(EmployeeData empdata) {
		EmployeeData empObj;
		try {
			empObj = employeeRepo.findById(empdata.getId()).get();
			if (empObj == null) {
				throw new CustomException("No Record Found");
			}
			return employeeRepo.save(empdata);
		} catch (Exception e) {
			throw new CustomException("Error While Updating Record");
		}

	}

	@Override
	public void deleteEmployee(Long empid) {
		EmployeeData empObj;
		try {
			empObj = employeeRepo.findById(empid).get();
			if (empObj == null) {
				throw new CustomException("No Record Found");
			}
			employeeRepo.delete(empObj);
		} catch (Exception e) {
			throw new CustomException("Unable to delete");
		}

	}

}

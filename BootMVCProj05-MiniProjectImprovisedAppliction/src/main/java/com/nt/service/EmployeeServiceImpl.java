package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeRepository empRepo;

	@Override
	public List<Employee> showAllEmployees() {
		List<Employee> empList = empRepo.findAll(Sort.by(Sort.Direction.ASC, "ename"));
		return empList;
	}

	@Override
	public String registerEmployee(Employee emp) {
		Integer id = empRepo.save(emp).getEmpno();
		return "Employee is registered with Employee No :: "+id;
	}

	@Override
	public Employee findEmployeeById(int id) {
		return empRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
	}

	@Override
	public String editEmployee(Employee emp) {
		Integer empno = empRepo.save(emp).getEmpno();
		return "Employee with id "+empno+" is edited successfully";
	}

	@Override
	public String removeEmployee(int id) {
		Optional<Employee> opt=empRepo.findById(id);
		if(opt.isPresent()) {
			empRepo.deleteById(id);
			return "Employee with id "+id+" is deleted successfully";
		}
		return "Employee not found";
	}

	@Override
	public List<Employee> searchEmployees(Employee emp) {
		if(emp.getEname().equalsIgnoreCase("")||emp.getEname().length()==0) {
			emp.setEname(null);
		}
		if(emp.getJob().equalsIgnoreCase("")||emp.getJob().length()==0) {
			emp.setJob(null);
		}
		Example<Employee> ex=Example.of(emp);
		List<Employee> list = empRepo.findAll(ex);
		return list;
	}

	@Override
	public List<Employee> searchByEnameStartsWithAndJobStartsWith(String name, String job) {
		if(name.equalsIgnoreCase("")||name.length()==0) {
			name.equals(null);
		}
		if(job.equalsIgnoreCase("")||job.length()==0) {
			job.equals(null);
		}
		return empRepo.findByEnameStartingWithAndJobStartingWith(name, job);
	}

	@Override
	public List<Employee> findEmployees(String name, String job, Double sal, Integer deptno) {
		if(name.equalsIgnoreCase("")||name.length()==0) {
			name.equals(null);
		}
		if(job.equalsIgnoreCase("")||job.length()==0) {
			job.equals(null);
		}
		return empRepo.findEmployees(name, job, sal, deptno);
	}
	

}

package com.nt.service;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeService {
	public List<Employee> showAllEmployees();
	public String registerEmployee(Employee emp);
	public Employee findEmployeeById(int id);
	public String editEmployee(Employee emp);
	public String removeEmployee(int id);
	public List<Employee> searchEmployees(Employee emp);
	public List<Employee> searchByEnameStartsWithAndJobStartsWith(String name, String job);
	public List<Employee> findEmployees(String name, String job, Double sal, Integer deptno);
}

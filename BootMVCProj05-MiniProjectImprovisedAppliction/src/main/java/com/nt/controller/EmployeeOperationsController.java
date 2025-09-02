package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeService;

@Controller
public class EmployeeOperationsController {
	@Autowired
	private IEmployeeService empService;
	
	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}
	
	@GetMapping("/report")
	public String showreport(Map<String, Object> map,
								@ModelAttribute("emp") Employee emp) {
		try{
		List<Employee> list = empService.showAllEmployees();
		List<Integer> dept = list.stream().map(Employee::getDeptno).distinct().sorted().collect(Collectors.toList());
		//Allocate to map
		map.put("empList", list);
		map.put("dept", dept);
		return "show_report";
		} catch(Exception e) {
			e.printStackTrace();
			map.put("errorMsg", e.getMessage());
			return "error";
		}
	}
	
	@GetMapping("/register")
	public String showRegisterationPage(@ModelAttribute("emp") Employee emp) {
		return "employee_register";
	}
	
	@PostMapping("/register")
	public String registerNewEmployee(RedirectAttributes attrs, 
										@ModelAttribute("emp") Employee emp) {
		try {
			String register = empService.registerEmployee(emp);
			attrs.addFlashAttribute("registerMsg", register);
			return "redirect:report";
		} catch(Exception e) {
			e.printStackTrace();
			attrs.addAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}
	
//	@PostMapping("/register")
//	public String registerNewEmployee(HttpSession ses, 
//												@ModelAttribute("emp") Employee emp) {
//		try {
//		String register = empService.registerEmployee(emp);
//		ses.setAttribute("registerMsg", register);
//		return "redirect:report";
//		} catch(Exception e) {
//			e.printStackTrace();
//			ses.setAttribute("errorMsg", e.getMessage());
//			return "error";
//		}
//	}
	
	@GetMapping("/edit")
	public String findEmployeeById(@ModelAttribute("emp") Employee emp,
										@RequestParam("no") int no) {
		Employee emp1 = empService.findEmployeeById(no);
		BeanUtils.copyProperties(emp1, emp);
		return "employee_edit";
	}
	
	@PostMapping("/edit")
	public String showEditedEmployee(RedirectAttributes attrs, 
									@ModelAttribute("emp") Employee emp) {
		try {
			String edit = empService.editEmployee(emp);
			attrs.addFlashAttribute("registerMsg", edit);
			return "redirect:report";
		} catch(Exception e) {
			e.printStackTrace();
			attrs.addAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}
	
	@GetMapping("/delete")
	public String deleteEmployeeById(Map<String, Object> map,
										@RequestParam("no") int no) {
		try {
			String delete = empService.removeEmployee(no);
			map.put("registerMsg", delete);
			return "forward:report";
		} catch(Exception e) {
			e.printStackTrace();
			map.put("errorMsg", e.getMessage());
			return "error";
		}
	}
	
	@PostMapping("/search")
	public String searchEmployeesDynamically(@ModelAttribute("emp") Employee emp,
												Map<String, Object> map) {
		//List<Employee> list = empService.searchByEnameStartsWithAndJobStartsWith(emp.getEname(), emp.getJob());
		List<Employee> list = empService.findEmployees(emp.getEname(), emp.getJob(), emp.getSal(), emp.getDeptno());
		List<Integer> dept = list.stream().map(Employee::getDeptno).distinct().sorted().collect(Collectors.toList());
		map.put("empList", list);
		map.put("dept", dept);
		return "show_report";
	}
	
	
}

package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
	public List<Employee> findByEnameStartingWithAndJobStartingWith(String name, String job);
	
	//@Query(value = "SELECT * FROM EMP WHERE ENAME LIKE :name AND JOB LIKE :job AND SAL > :sal", nativeQuery = true)
	@Query(value = "select e1_0.empno,e1_0.deptno,e1_0.ename,e1_0.job,e1_0.sal from emp e1_0 where e1_0.ename like concat(:name,'%') "
			+ "	 and e1_0.job like concat(:job,'%') and (:sal is null or e1_0.sal > :sal) and (:deptno is null or e1_0.deptno = :deptno)", nativeQuery = true)
	public List<Employee> findEmployees(String name, String job, Double sal, Integer deptno);

}

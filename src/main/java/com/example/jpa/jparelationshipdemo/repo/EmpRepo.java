package com.example.jpa.jparelationshipdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa.jparelationshipdemo.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {

	/*
	 * @Query(value = "select e from Employee e where e.age=:age ")
	 * Optional<Employee> findByAgeAndName(@Param("age") Integer age, @Param("city")
	 * String city);
	 */

}

package com.theara.SpringReactiveEmployeeTest.repository;

import com.theara.SpringReactiveEmployeeTest.model.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee,Long> {

}

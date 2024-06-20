package com.theara.SpringReactiveEmployeeTest.controller;

import com.theara.SpringReactiveEmployeeTest.model.Employee;
import com.theara.SpringReactiveEmployeeTest.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);


    @QueryMapping
    public Mono<Employee> getEmployeeById(@Argument Long id){
        logger.debug("Received getEmployeeById query with id: {}", id);
        return employeeService.getEmployeeById(id)
                .doOnNext(employee -> logger.debug("Returning employee: {}", employee))
                .doOnError(error -> logger.error("Error in getEmployeeById query", error));
    }

    @QueryMapping
    public Flux<Employee> getEmployeeAll(){
        return employeeService.getEmployeeAll();
    }

    @MutationMapping
    public Mono<Employee> createEmployee(@Argument String firstName, @Argument String lastName, @Argument String email){
        Employee emp = new Employee();
        emp.setFirstName(firstName);
        emp.setLastName(lastName);
        emp.setEmail(email);
        return employeeService.createEmployee(emp);
    }

    @MutationMapping
    public Mono<Employee> updateEmployee(@Argument Long id, @Argument String firstName, @Argument String lastName, @Argument String email){
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        return employeeService.updateEmployee(id,employee);
    }

    @MutationMapping
    public Mono<String> deleteEmployee(@Argument Long id) {
        return employeeService.deleteEmployee(id).thenReturn("Employee deleted successfully");
    }
}

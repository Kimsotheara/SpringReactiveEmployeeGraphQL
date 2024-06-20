package com.theara.SpringReactiveEmployeeTest.service;

import com.theara.SpringReactiveEmployeeTest.model.Employee;
import com.theara.SpringReactiveEmployeeTest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Mono<Employee> createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Mono<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id).switchIfEmpty(Mono.error(new RuntimeException("Employee not found")));
    }

    public Flux<Employee> getEmployeeAll(){
        return employeeRepository.findAll();
    }

    public Mono<Employee> updateEmployee(Long id, Employee employee){
        return employeeRepository.findById(id)
                .flatMap(existEmp->{
                    existEmp.setFirstName(employee.getFirstName());
                    existEmp.setLastName(employee.getLastName());
                    existEmp.setEmail(employee.getEmail());
                    return employeeRepository.save(existEmp);
                });
    }

    public Mono<Void> deleteEmployee(Long id) {
        return employeeRepository.deleteById(id);
    }

}

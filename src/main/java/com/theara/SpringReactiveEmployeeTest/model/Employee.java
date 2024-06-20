package com.theara.SpringReactiveEmployeeTest.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Table("Employees")
public class Employee {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}

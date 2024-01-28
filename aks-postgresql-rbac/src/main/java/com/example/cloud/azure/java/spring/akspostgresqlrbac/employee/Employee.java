package com.example.cloud.azure.java.spring.akspostgresqlrbac.employee;

import com.example.cloud.azure.java.spring.akspostgresqlrbac.company.Company;
import com.example.cloud.azure.java.spring.akspostgresqlrbac.insfrastructure.data.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.validation.annotation.Validated;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@Validated
@Entity

public class Employee extends BaseEntity {
    @NotNull
    @ManyToOne()
    private Company company;

    @NotBlank
    @Column(nullable = false)
    private String firstName;

    @NotBlank
    @Column(nullable = false)
    private String lastName;

    @NotBlank
    @Column(nullable = false)
    private String position;

    @NotNull
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private EmployeeType employeeType;

    @Column(nullable = false, updatable = false)
    private Instant joinDate;

    @PrePersist
    private void setUpAutoPopulateFields() {
        this.joinDate = Instant.now();
    }
}

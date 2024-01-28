package com.example.cloud.azure.java.spring.akspostgresqlrbac.employee;

import com.example.cloud.azure.java.spring.akspostgresqlrbac.company.CompanyDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;


@Data
public final class EmployeeDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY, required = true)
    private Long companyId;

    private CompanyDto company;

    @NotBlank
    @JsonProperty(required = true)
    private String firstName;

    @NotBlank
    @JsonProperty(required = true)
    private String lastName;

    @NotBlank
    @JsonProperty(required = true)
    private String position;

    @NotNull
    @JsonProperty(required = true)
    private EmployeeType employeeType;
    private Instant joinDate;

    public Employee toEmployee() {
        var entity = new Employee();
        if (company != null) {
            entity.setCompany(company.toCompany());
        }
        entity.setFirstName(firstName);
        entity.setLastName(lastName);
        entity.setPosition(position);
        entity.setEmployeeType(employeeType);
        return entity;
    }

    public static EmployeeDto from(Employee entity) {
        EmployeeDto dto = new EmployeeDto();
        dto.setId(entity.getId());
        dto.setCompany(CompanyDto.from(entity.getCompany()));
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPosition(entity.getPosition());
        dto.setEmployeeType(entity.getEmployeeType());
        dto.setJoinDate(entity.getJoinDate());
        return dto;
    }

}

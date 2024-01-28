package com.example.cloud.azure.java.spring.akspostgresqlrbac.employee;

import com.example.cloud.azure.java.spring.akspostgresqlrbac.insfrastructure.data.BaseRepository;

import java.util.List;

public interface EmployeeRepository extends BaseRepository<Employee> {
    List<Employee> findAllByCompanyId(Long companyId);
}

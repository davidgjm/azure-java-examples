package com.example.cloud.azure.java.spring.akspostgresqlrbac.employee;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Flux<EmployeeDto> findEmployees(@NotNull @Positive Long companyId);

    Mono<EmployeeDto> createEmployee(@NotNull EmployeeDto requestData);
}

package com.example.cloud.azure.java.spring.akspostgresqlrbac.application;

import com.example.cloud.azure.java.spring.akspostgresqlrbac.employee.EmployeeDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeApplicationService {
    Flux<EmployeeDto> findEmployees(@NotNull @Positive Long companyId);

    Mono<EmployeeDto> createEmployee(@NotNull @Validated EmployeeDto requestData);
}

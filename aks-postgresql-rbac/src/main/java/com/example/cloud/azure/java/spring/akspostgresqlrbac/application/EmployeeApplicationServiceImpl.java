package com.example.cloud.azure.java.spring.akspostgresqlrbac.application;

import com.example.cloud.azure.java.spring.akspostgresqlrbac.employee.EmployeeDto;
import com.example.cloud.azure.java.spring.akspostgresqlrbac.employee.EmployeeService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Validated
@Service
public class EmployeeApplicationServiceImpl implements EmployeeApplicationService {
    private final EmployeeService service;

    @Override
    public Flux<EmployeeDto> findEmployees(Long companyId) {
        return service.findEmployees(companyId);
    }

    @Override
    public Mono<EmployeeDto> createEmployee(@NotNull @Validated EmployeeDto requestData) {
        return service.createEmployee(requestData);
    }
}

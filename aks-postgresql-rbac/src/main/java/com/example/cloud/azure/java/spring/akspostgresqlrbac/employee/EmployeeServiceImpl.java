package com.example.cloud.azure.java.spring.akspostgresqlrbac.employee;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.example.cloud.azure.java.spring.akspostgresqlrbac.company.CompanyDto;
import com.example.cloud.azure.java.spring.akspostgresqlrbac.company.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Validated
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;
    private final CompanyService companyService;

    @Override
    public Flux<EmployeeDto> findEmployees(Long companyId) {
        return Flux.fromIterable(repository.findAllByCompanyId(companyId))
                .map(EmployeeDto::from);
    }

    @Override
    public Mono<EmployeeDto> createEmployee(EmployeeDto requestData) {
        if (null == requestData.getCompanyId() && null == requestData.getCompany()) {
            log.error("Missing company information for employee {}", requestData);
            throw new IllegalArgumentException("Missing company information!");
        }
        return companyService.findById(requestData.getCompanyId())
                .map(company -> {
                    var employee = requestData.toEmployee();
                    employee.setCompany(company);
                    return employee;
                })
                .map(repository::save)
                .map(EmployeeDto::from)
        ;
    }
}

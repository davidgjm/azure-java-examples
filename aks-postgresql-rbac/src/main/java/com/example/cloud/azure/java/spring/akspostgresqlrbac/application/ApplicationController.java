package com.example.cloud.azure.java.spring.akspostgresqlrbac.application;

import com.example.cloud.azure.java.spring.akspostgresqlrbac.company.CompanyDto;
import com.example.cloud.azure.java.spring.akspostgresqlrbac.employee.EmployeeDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/companies")
public class ApplicationController {
    private final CompanyApplicationService companyApplicationService;
    private final EmployeeApplicationService employeeApplicationService;
    @GetMapping
    public Flux<CompanyDto> getAllCompanies() {
        return companyApplicationService.findAll(Sort.unsorted())
                .publishOn(Schedulers.boundedElastic());
    }

    @PostMapping
    public Mono<CompanyDto> createCompany(@RequestBody @NotNull CompanyDto requestData) {
        return companyApplicationService.newCompany(requestData);
    }

    @GetMapping("/{id}")
    public Mono<CompanyDto> findCompanyById(@PathVariable(name = "id", required = true) @NotNull @Positive Long id) {
        return companyApplicationService.findById(id);
    }


    @GetMapping("/{id}/employees")
    public Flux<EmployeeDto> findCompanyEmployees(@PathVariable(name = "id", required = true) @NotNull @Positive Long id) {
        return employeeApplicationService.findEmployees(id);
    }

    @PostMapping("/{id}/employees")
    public Mono<EmployeeDto> createEmployee(@PathVariable(name = "id", required = true) @NotNull @Positive Long id,
                                            @RequestBody @NotNull @Validated EmployeeDto requestData) {
        requestData.setCompanyId(id);
        return employeeApplicationService.createEmployee(requestData);
    }
}

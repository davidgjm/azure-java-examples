package com.example.cloud.azure.java.spring.akspostgresqlrbac.application;

import com.example.cloud.azure.java.spring.akspostgresqlrbac.company.CompanyDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Pageable;

public interface CompanyApplicationService {
    Mono<CompanyDto> newCompany(@NotNull @Validated CompanyDto requestData);

    Flux<CompanyDto> findAll(Sort sort);

    Mono<CompanyDto> findById(@NotNull @Positive Long id);
    Mono<CompanyDto> findByName(@NotBlank String name);
}

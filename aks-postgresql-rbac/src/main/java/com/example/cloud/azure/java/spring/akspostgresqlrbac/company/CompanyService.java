package com.example.cloud.azure.java.spring.akspostgresqlrbac.company;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CompanyService {

    Mono<CompanyDto> create(CompanyDto dto);

    Flux<CompanyDto> findAll(Sort sort);

    Mono<CompanyDto> finalByName(@NotBlank String name);

    Mono<Company> findById(@Positive @NotNull Long id);
}

package com.example.cloud.azure.java.spring.akspostgresqlrbac.application;

import com.example.cloud.azure.java.spring.akspostgresqlrbac.company.CompanyDto;
import com.example.cloud.azure.java.spring.akspostgresqlrbac.company.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Pageable;

@Slf4j
@RequiredArgsConstructor
@Validated
@Service
public class CompanyApplicationServiceImpl implements CompanyApplicationService {
    private final CompanyService service;
    @Override
    public Mono<CompanyDto> newCompany(CompanyDto requestData) {
        log.info("Attempting to create company with data {}", requestData);
        return service.create(requestData);
    }

    @Override
    public Flux<CompanyDto> findAll(Sort sort) {
        log.info("Attempting to get all companies with sort information {}", sort);
        return service.findAll(sort);
    }

    @Override
    public Mono<CompanyDto> findById(Long id) {
        log.info("Attempting to find company with id {}", id);
        return service.findById(id).map(CompanyDto::from);
    }

    @Override
    public Mono<CompanyDto> findByName(String name) {
        return service.finalByName(name);
    }
}

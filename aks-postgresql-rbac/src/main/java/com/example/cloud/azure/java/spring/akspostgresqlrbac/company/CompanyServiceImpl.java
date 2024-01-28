package com.example.cloud.azure.java.spring.akspostgresqlrbac.company;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Validated
@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;
    @Override
    public Mono<CompanyDto> create(CompanyDto dto) {
        return Mono.just(repository.save(dto.toCompany()))
                .map(CompanyDto::from);
    }

    @Override
    public Flux<CompanyDto> findAll(Sort sort) {
        return Flux.fromIterable(repository.findAll(sort))
                .map(CompanyDto::from)
                ;
    }

    @Override
    public Mono<CompanyDto> finalByName(@NotBlank String name) {
        if (StringUtils.hasText(name)) {
            return Mono.empty();
        }
        return Mono.just(repository.findByNameIgnoreCase(name))
                .map(CompanyDto::from);
    }

    @Override
    public Mono<Company> findById(@Positive @NotNull Long id) {
        return Mono.justOrEmpty(repository.findById(id));
    }
}

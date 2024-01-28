package com.example.cloud.azure.java.spring.akspostgresqlrbac.company;

import com.example.cloud.azure.java.spring.akspostgresqlrbac.company.Company;
import com.example.cloud.azure.java.spring.akspostgresqlrbac.insfrastructure.data.BaseRepository;
import reactor.core.publisher.Mono;

public interface CompanyRepository extends BaseRepository<Company> {
    Company findByNameIgnoreCase(String name);
}

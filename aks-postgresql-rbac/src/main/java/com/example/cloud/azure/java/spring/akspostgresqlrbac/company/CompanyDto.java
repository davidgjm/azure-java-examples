package com.example.cloud.azure.java.spring.akspostgresqlrbac.company;

import lombok.Data;

@Data
public final class CompanyDto {
    private Long id;
    private String name;
    private String country;
    private String city;
    private String address;

    public Company toCompany() {
        Company entity = new Company();
        entity.setName(name);
        entity.setCountry(country);
        entity.setCity(city);
        entity.setAddress(address);
        return entity;
    }

    public static CompanyDto from(Company company) {
        CompanyDto dto = new CompanyDto();
        dto.setId(company.getId());
        dto.setName(company.getName());
        dto.setCountry(company.getCountry());
        dto.setCity(company.getCity());
        dto.setAddress(company.getAddress());
        return dto;
    }
}

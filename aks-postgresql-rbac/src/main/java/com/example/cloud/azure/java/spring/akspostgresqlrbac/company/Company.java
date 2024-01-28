package com.example.cloud.azure.java.spring.akspostgresqlrbac.company;

import com.example.cloud.azure.java.spring.akspostgresqlrbac.insfrastructure.data.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@Entity
public class Company extends BaseEntity {

    @NotBlank
    @Column(nullable = false, unique = true,length = 255)
    private String name;

    private String country;
    private String city;
    private String address;

}

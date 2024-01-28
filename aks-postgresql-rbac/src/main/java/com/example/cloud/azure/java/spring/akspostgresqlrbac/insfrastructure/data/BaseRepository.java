package com.example.cloud.azure.java.spring.akspostgresqlrbac.insfrastructure.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T,Long> {
}

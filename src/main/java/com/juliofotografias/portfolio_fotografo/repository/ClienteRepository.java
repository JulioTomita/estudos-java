package com.juliofotografias.portfolio_fotografo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juliofotografias.portfolio_fotografo.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}

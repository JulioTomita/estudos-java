package com.juliofotografias.portifolio_fotografo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juliofotografias.portifolio_fotografo.entity.Portifolio;

@Repository
public interface PortifolioRepository extends JpaRepository<Portifolio,Long> {

}

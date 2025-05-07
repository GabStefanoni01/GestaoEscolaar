package com.examplo.gestaoescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examplo.gestaoescolar.model.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {

}

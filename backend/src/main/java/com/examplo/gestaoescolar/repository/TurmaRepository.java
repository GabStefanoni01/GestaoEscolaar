package com.examplo.gestaoescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examplo.gestaoescolar.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    
}

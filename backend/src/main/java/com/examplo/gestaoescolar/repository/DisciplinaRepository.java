package com.examplo.gestaoescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examplo.gestaoescolar.model.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    
}

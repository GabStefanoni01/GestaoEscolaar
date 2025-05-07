package com.examplo.gestaoescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examplo.gestaoescolar.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
}

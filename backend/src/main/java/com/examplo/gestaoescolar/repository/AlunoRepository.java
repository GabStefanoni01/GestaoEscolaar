package com.examplo.gestaoescolar.repository;

import com.examplo.gestaoescolar.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}

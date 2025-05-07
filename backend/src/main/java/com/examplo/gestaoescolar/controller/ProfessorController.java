package com.examplo.gestaoescolar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examplo.gestaoescolar.model.Professor;
import com.examplo.gestaoescolar.repository.ProfessorRepository;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {
    @Autowired private ProfessorRepository repo;

    @GetMapping public List<Professor> listar() { return repo.findAll(); }
    @PostMapping public Professor criar(@RequestBody Professor p) { return repo.save(p); }
    @PutMapping("/{id}")
    public ResponseEntity<Professor> atualizar(@PathVariable Long id, @RequestBody Professor novo) {
        return repo.findById(id).map(p -> {
            p.setNome(novo.getNome()); p.setEmail(novo.getEmail());
            return ResponseEntity.ok(repo.save(p));
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public void deletar(@PathVariable Long id) { repo.deleteById(id); }
}


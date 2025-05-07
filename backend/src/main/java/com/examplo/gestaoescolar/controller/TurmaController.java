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

import com.examplo.gestaoescolar.model.Turma;
import com.examplo.gestaoescolar.repository.TurmaRepository;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {
    @Autowired private TurmaRepository repo;

    @GetMapping public List<Turma> listar() { return repo.findAll(); }
    @PostMapping public Turma criar(@RequestBody Turma t) { return repo.save(t); }
    @PutMapping("/{id}")
    public ResponseEntity<Turma> atualizar(@PathVariable Long id, @RequestBody Turma novo) {
        return repo.findById(id).map(t -> {
            t.setNome(novo.getNome()); t.setProfessor(novo.getProfessor());
            return ResponseEntity.ok(repo.save(t));
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public void deletar(@PathVariable Long id) { repo.deleteById(id); }
}

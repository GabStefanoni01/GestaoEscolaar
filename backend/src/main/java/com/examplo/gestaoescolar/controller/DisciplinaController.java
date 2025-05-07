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

import com.examplo.gestaoescolar.model.Disciplina;
import com.examplo.gestaoescolar.repository.DisciplinaRepository;


@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController {
    @Autowired private DisciplinaRepository repo;

    @GetMapping public List<Disciplina> listar() { return repo.findAll(); }
    @PostMapping public Disciplina criar(@RequestBody Disciplina d) { return repo.save(d); }
    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> atualizar(@PathVariable Long id, @RequestBody Disciplina novo) {
        return repo.findById(id).map(d -> {
            d.setNome(novo.getNome()); d.setProfessor(novo.getProfessor());
            return ResponseEntity.ok(repo.save(d));
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public void deletar(@PathVariable Long id) { repo.deleteById(id); }
}

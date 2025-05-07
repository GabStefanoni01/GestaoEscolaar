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

import com.examplo.gestaoescolar.model.Nota;
import com.examplo.gestaoescolar.repository.NotaRepository;

@RestController
@RequestMapping("/api/notas")
public class NotaController {
    @Autowired private NotaRepository repo;

    @GetMapping public List<Nota> listar() { return repo.findAll(); }
    @PostMapping public Nota criar(@RequestBody Nota n) { return repo.save(n); }
    @PutMapping("/{id}")
    public ResponseEntity<Nota> atualizar(@PathVariable Long id, @RequestBody Nota novo) {
        return repo.findById(id).map(n -> {
            n.setValor(novo.getValor()); n.setAluno(novo.getAluno()); n.setDisciplina(novo.getDisciplina());
            return ResponseEntity.ok(repo.save(n));
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public void deletar(@PathVariable Long id) { repo.deleteById(id); }
}

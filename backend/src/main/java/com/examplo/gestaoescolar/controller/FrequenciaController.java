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

import com.examplo.gestaoescolar.model.Frequencia;
import com.examplo.gestaoescolar.repository.FrequenciaRepository;

@RestController
@RequestMapping("/api/frequencias")
public class FrequenciaController {
    @Autowired private FrequenciaRepository repo;

    @GetMapping public List<Frequencia> listar() { return repo.findAll(); }
    @PostMapping public Frequencia criar(@RequestBody Frequencia f) { return repo.save(f); }
    @PutMapping("/{id}")
    public ResponseEntity<Frequencia> atualizar(@PathVariable Long id, @RequestBody Frequencia novo) {
        return repo.findById(id).map(f -> {
            f.setData(novo.getData()); f.setPresente(novo.isPresente());
            f.setAluno(novo.getAluno()); f.setDisciplina(novo.getDisciplina());
            return ResponseEntity.ok(repo.save(f));
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public void deletar(@PathVariable Long id) { repo.deleteById(id); }
}

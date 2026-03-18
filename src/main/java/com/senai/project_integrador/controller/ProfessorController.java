package com.senai.project_integrador.controller;

import com.senai.project_integrador.business.ProfessorService;
import com.senai.project_integrador.infrastructure.entitys.Professor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService service;

    @PostMapping
    public ResponseEntity<Professor> salvar(@RequestBody Professor professor){
        return ResponseEntity.ok(service.salvarProfessor(professor));
    }

    @GetMapping
    public ResponseEntity<Professor> buscar(@RequestParam String email){
        return ResponseEntity.ok(service.buscarProfessorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(@RequestParam String email){
        service.deletarProfessorPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Professor> atualizar(@RequestParam Integer id,
                                               @RequestBody Professor professor){
        return ResponseEntity.ok(service.atualizarProfessorPorId(id, professor));
    }
}
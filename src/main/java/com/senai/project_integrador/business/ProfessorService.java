package com.senai.project_integrador.business;

import com.senai.project_integrador.infrastructure.entitys.Professor;
import com.senai.project_integrador.infrastructure.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository repository;

    public Professor salvarProfessor(Professor professor){
        return repository.save(professor);
    }

    public Professor buscarProfessorEmail(String email){
        return repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
    }

    public void deletarProfessorPorEmail(String email){
        repository.deleteByEmail(email);
    }

    public Professor atualizarProfessorPorId(Integer id, Professor professor){
        Professor existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        if(professor.getNome() != null){
            existente.setNome(professor.getNome());
        }

        if(professor.getEmail() != null){
            existente.setEmail(professor.getEmail());
        }

        if(professor.getPassword() != null){
            existente.setPassword(professor.getPassword());
        }

        return repository.save(existente);
    }
}
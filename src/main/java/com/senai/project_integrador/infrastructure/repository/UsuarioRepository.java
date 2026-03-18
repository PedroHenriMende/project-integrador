package com.senai.project_integrador.infrastructure.repository;

import com.senai.project_integrador.infrastructure.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);

    void deleteByEmail(String email);
}

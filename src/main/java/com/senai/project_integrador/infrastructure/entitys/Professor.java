package com.senai.project_integrador.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "/professor")
@Entity

public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nome", unique = true)
    private String nome;

    @Column(name = "senha")
    private String senha;

}


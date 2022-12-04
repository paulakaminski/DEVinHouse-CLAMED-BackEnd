package com.example.demo.dataprovider.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="nota")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnotacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String texto;

    @Column(name="data_criacao")
    private LocalDateTime dataCriacao;

    public AnotacaoEntity(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
        this.dataCriacao = LocalDateTime.now();
    }
}

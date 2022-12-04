package com.example.demo.dataprovider.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tag")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private Long id;

    @Column
    private String tag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="nota_id")
    private AnotacaoEntity anotacaoEntity;

    public TagEntity(String tag, AnotacaoEntity anotacaoEntity) { //construtor customizado, pois não precisamos gerar o ID
        this.tag = tag;
        this.anotacaoEntity = anotacaoEntity;
    }
}

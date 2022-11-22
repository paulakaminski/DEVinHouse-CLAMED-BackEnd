package tech.semana09.entity;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "pessoas")
public class PessoaEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    @NotNull
    private String nome;

    @NotNull
    private String email;

    private Boolean status;
}

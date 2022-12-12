package com.clamed.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoOutput {
    private Long id;
    private String nome;
    private String email;
    private String telfoneFixo;
    private String telefoneCelular;
    private String telefoneTrabalho;
}

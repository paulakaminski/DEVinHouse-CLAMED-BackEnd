package exercicios.semana08.exerciciosspring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PessoaModel {
    private Long id;
    private String nome;
    private String email;

}

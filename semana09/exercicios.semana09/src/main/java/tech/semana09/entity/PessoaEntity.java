//exercicio 02
//Após a configuração efetuada no exercício anterior, vamos criar uma entidade chamada “Pessoa”. Essa classe deverá
// conter os atributos: Id, name, email e status. O id será chave da tabela com o tipo Long, name e email serão String
// e status Boolean.

package tech.semana09.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "pessoas")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String nome;

    @NotNull
    private String email;

    private Boolean status;
}

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

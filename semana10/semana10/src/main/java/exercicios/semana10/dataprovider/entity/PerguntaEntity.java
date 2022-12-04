package exercicios.semana10.dataprovider.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="pergunta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerguntaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String texto;

    //muitas perguntas para um assunto
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JoinColumn(name="assunto_id")
    private AssuntoEntity assuntoEntity;

    public PerguntaEntity(String titulo, String texto, AssuntoEntity assuntoEntity) {
        this.titulo = titulo;
        this.texto = texto;
        this.assuntoEntity = assuntoEntity;
    }
}

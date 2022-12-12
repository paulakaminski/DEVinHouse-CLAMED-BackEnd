package exercicios.semana10.dataprovider.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="resposta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespostaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private Long id;

    @Column
    private String texto;

    //muitas respostas para uma pergunta
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JoinColumn(name="pergunta_id")
    private PerguntaEntity perguntaEntity;

    public RespostaEntity(String texto, PerguntaEntity perguntaEntity) {
        this.texto = texto;
        this.perguntaEntity = perguntaEntity;
    }
}

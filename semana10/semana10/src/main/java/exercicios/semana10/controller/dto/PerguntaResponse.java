package exercicios.semana10.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerguntaResponse {
    private String titulo;
    private String texto;
    private AssuntoResponse assuntoResponse;

    public PerguntaResponse(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

}

package exercicios.semana10.controller;

import exercicios.semana10.controller.dto.PerguntaRequest;
import exercicios.semana10.controller.dto.PerguntaResponse;
import exercicios.semana10.padroes.DefaultResponse;
import exercicios.semana10.service.PerguntaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pergunta")
public class PerguntaController {

    private final PerguntaService perguntaService;

    public PerguntaController(PerguntaService perguntaService) {
        this.perguntaService = perguntaService;
    }

    @GetMapping
    public ResponseEntity<List<PerguntaResponse>> encontrarPerguntas() {

        List<PerguntaResponse> responseList = perguntaService.encontrarPerguntas();

        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerguntaResponse> encontrarPerguntaPorId(@PathVariable Long id) {
        PerguntaResponse perguntaResponse = perguntaService.encontrarPerguntaPorId(id);

        return new ResponseEntity<PerguntaResponse>(
                perguntaResponse, HttpStatus.OK
        );
    }

    @GetMapping("/assunto")
    public ResponseEntity<List<PerguntaResponse>> encontrarPerguntasPorAssunto(@RequestParam("idAssunto") String id) {

        List<PerguntaResponse> responseList = perguntaService.encontrarPerguntasPorAssunto(id);

        return ResponseEntity.ok(responseList);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> salvarPergunta(@RequestBody PerguntaRequest perguntaRequest) {
        PerguntaResponse perguntaResponse = perguntaService.salvarNovaPergunta(perguntaRequest);

        return new ResponseEntity<>(
                new DefaultResponse<PerguntaResponse>(
                        HttpStatus.CREATED.value(),
                        perguntaResponse
                ),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> atualizarPerguntaPorId(
            @PathVariable Long id,
            @RequestBody PerguntaRequest request
    ) {
        PerguntaResponse perguntaResponse = perguntaService.atualizarPerguntaPorId(id, request);

        return new ResponseEntity<>(
                new DefaultResponse<PerguntaResponse>(
                        HttpStatus.OK.value(),
                        perguntaResponse
                ),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPerguntaPorId(@PathVariable Long id) {
        perguntaService.deletarPerguntaPorId(id);
        return ResponseEntity.ok().build();
    }

}

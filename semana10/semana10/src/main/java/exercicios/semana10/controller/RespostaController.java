package exercicios.semana10.controller;

import exercicios.semana10.controller.dto.*;
import exercicios.semana10.padroes.DefaultResponse;
import exercicios.semana10.service.RespostaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resposta")
public class RespostaController {
    private final RespostaService respostaService;


    public RespostaController(RespostaService respostaService) {
        this.respostaService = respostaService;
    }

    @GetMapping
    public ResponseEntity<List<RespostaResponse>> encontrarRespostas() {
        List<RespostaResponse> responseList = respostaService.encontrarRespostas();

        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespostaResponse> encontrarRespostaPorId(@PathVariable Long id) {
        RespostaResponse respostaResponse = respostaService.encontrarRespostaPorId(id);

        return new ResponseEntity<RespostaResponse>(
                respostaResponse, HttpStatus.OK
        );
    }

    @GetMapping("/pergunta")
    public ResponseEntity<List<RespostaResponse>> encontrarRespostasPorPergunta(@RequestParam("idPergunta") String id) {
        List<RespostaResponse> responseList = respostaService.encontrarRespostasPorPergunta(id);

        return ResponseEntity.ok(responseList);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> salvarResposta(@RequestBody RespostaRequest respostaRequest) {
        RespostaResponse respostaResponse = respostaService.salvarNovaResposta(respostaRequest);

        return new ResponseEntity<>(
                new DefaultResponse<RespostaResponse>(
                        HttpStatus.CREATED.value(),
                        respostaResponse
                ),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> atualizarRespostaPorId(
            @PathVariable Long id,
            @RequestBody RespostaRequest request
    ) {
        RespostaResponse respostaResponse = respostaService.atualizarRespostaPorId(id, request);

        return new ResponseEntity<>(
                new DefaultResponse<RespostaResponse>(
                        HttpStatus.OK.value(),
                        respostaResponse
                ),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarRespostaPorId(@PathVariable Long id) {
        respostaService.deletarRespostaPorId(id);
        return ResponseEntity.ok().build();
    }

}

package exercicios.semana10.controller;

import exercicios.semana10.controller.dto.AssuntoRequest;
import exercicios.semana10.controller.dto.AssuntoResponse;
import exercicios.semana10.padroes.DefaultResponse;
import exercicios.semana10.service.AssuntoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assunto")
public class AssuntoController {
    private final AssuntoService assuntoService;

    public AssuntoController(AssuntoService assuntoService) {
        this.assuntoService = assuntoService;
    }

    @GetMapping
    public ResponseEntity<List<AssuntoResponse>> encontrarAssuntos() {

        List<AssuntoResponse> responseList = assuntoService.encontrarAssuntos();

        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssuntoResponse> encontrarAssuntoPorId(@PathVariable Long id){
        AssuntoResponse assuntoResponse = assuntoService.encontrarAssuntoPorId(id);

        return new ResponseEntity<AssuntoResponse>(
                assuntoResponse, HttpStatus.OK
        );

    }

    @PostMapping
    public ResponseEntity<DefaultResponse> salvarAssunto(@RequestBody AssuntoRequest request) {
        AssuntoResponse assuntoResponse = assuntoService.salvarNovoAssunto(request);

        return new ResponseEntity<>(
                new DefaultResponse<AssuntoResponse>(
                        HttpStatus.CREATED.value(),
                        assuntoResponse
                ),
                HttpStatus.CREATED
        );

    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> atualizarAssuntoPorId(
            @PathVariable Long id,
            @RequestBody AssuntoRequest request
    ) {
        AssuntoResponse assuntoResponse = assuntoService.atualizarAssuntoPorId(id, request);

        return new ResponseEntity<>(
                new DefaultResponse<AssuntoResponse>(
                        HttpStatus.OK.value(),
                        assuntoResponse
                ),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarAssuntoPorId(@PathVariable Long id) {
        assuntoService.deletarAssuntoPorId(id);
        return ResponseEntity.ok().build();
    }

}

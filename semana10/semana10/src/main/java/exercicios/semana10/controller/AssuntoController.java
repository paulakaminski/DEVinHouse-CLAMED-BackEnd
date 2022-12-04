package exercicios.semana10.controller;

import exercicios.semana10.controller.dto.AssuntoRequest;
import exercicios.semana10.controller.dto.AssuntoResponse;
import exercicios.semana10.dataprovider.entity.AssuntoEntity;
import exercicios.semana10.dataprovider.entity.PerguntaEntity;
import exercicios.semana10.dataprovider.repository.AssuntoRepository;
import exercicios.semana10.dataprovider.repository.PerguntaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/assunto")
public class AssuntoController {

    private final AssuntoRepository assuntoRepository;
    private final PerguntaRepository perguntaRepository;

    public AssuntoController(AssuntoRepository assuntoRepository, PerguntaRepository perguntaRepository) {
        this.assuntoRepository = assuntoRepository;
        this.perguntaRepository = perguntaRepository;
    }

    @GetMapping
    public ResponseEntity<List<AssuntoResponse>> encontrarAssuntos() {
//        assuntoRepository.save(new AssuntoEntity("Java"));
//        assuntoRepository.save(new AssuntoEntity("Javascript"));

        List<AssuntoEntity> entityList = assuntoRepository.findAll();

        List<AssuntoResponse> responseList = new ArrayList<>();
        for (AssuntoEntity entity:
             entityList) {
            responseList.add(
                    new AssuntoResponse(entity.getNome())
            );
        }
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssuntoResponse> encontrarAssuntoPorId(@PathVariable Long id){
        AssuntoEntity assuntoEntity = assuntoRepository.findById(id).get();

        return new ResponseEntity<AssuntoResponse>(
                new AssuntoResponse(assuntoEntity.getNome()),
                HttpStatus.OK
        );

    }

    @GetMapping("/perguntas/assunto/{id}")
    public ResponseEntity encontrarPerguntasPorAssunto(@PathVariable Long id) {
        List<PerguntaEntity> perguntaEntities = perguntaRepository.findPerguntaEntitiesByAssuntoEntity_Id(id);

        return ResponseEntity.ok(perguntaEntities);
    }

    @PostMapping
    public ResponseEntity<AssuntoResponse> salvarAssunto(@RequestBody AssuntoRequest request) {
        AssuntoEntity assuntoEntity = assuntoRepository.save(new AssuntoEntity(request.getNome()));

        return new ResponseEntity<AssuntoResponse>(new AssuntoResponse(assuntoEntity.getNome()), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<AssuntoResponse> atualizarAssuntoPorId(
            @PathVariable Long id,
            @RequestBody AssuntoRequest request
    ) {
        AssuntoEntity assuntoEntity = assuntoRepository.findById(id).get();
        assuntoEntity.setNome(request.getNome());
        assuntoRepository.save(assuntoEntity);

        return new ResponseEntity<AssuntoResponse>(
                new AssuntoResponse(assuntoEntity.getNome()), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarAssuntoPorId(@PathVariable Long id) {
        assuntoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}

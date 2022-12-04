package exercicios.semana10.controller;

import exercicios.semana10.controller.dto.AssuntoRequest;
import exercicios.semana10.controller.dto.AssuntoResponse;
import exercicios.semana10.controller.dto.PerguntaRequest;
import exercicios.semana10.controller.dto.PerguntaResponse;
import exercicios.semana10.dataprovider.entity.AssuntoEntity;
import exercicios.semana10.dataprovider.entity.PerguntaEntity;
import exercicios.semana10.dataprovider.entity.RespostaEntity;
import exercicios.semana10.dataprovider.repository.AssuntoRepository;
import exercicios.semana10.dataprovider.repository.PerguntaRepository;
import exercicios.semana10.dataprovider.repository.RespostaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pergunta")
public class PerguntaController {

    private final PerguntaRepository perguntaRepository;
    private final RespostaRepository respostaRepository;

    private final AssuntoRepository assuntoRepository;


    public PerguntaController(PerguntaRepository perguntaRepository, RespostaRepository respostaRepository, AssuntoRepository assuntoRepository) {
        this.perguntaRepository = perguntaRepository;
        this.respostaRepository = respostaRepository;
        this.assuntoRepository = assuntoRepository;
    }

    @GetMapping
    public ResponseEntity<List<PerguntaResponse>> encontrarPerguntas() {
//        perguntaRepository.save(new PerguntaEntity("CRUD no Spring", "Como utilizar o GetMapping no Spring?", new PerguntaEntity ()))

        List<PerguntaEntity> entityList = perguntaRepository.findAll();

        List<PerguntaResponse> responseList = new ArrayList<>();
        for (PerguntaEntity entity : entityList) {
            responseList.add(
                    new PerguntaResponse(entity.getTitulo()
                            , entity.getTexto()
                            , new AssuntoResponse(entity.getAssuntoEntity().getNome()))
            );
        }

        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerguntaResponse> encontrarPerguntaPorId(@PathVariable Long id) {
        PerguntaEntity assuntoEntity = perguntaRepository.findById(id).get();

        return new ResponseEntity<PerguntaResponse>(
                new PerguntaResponse(
                        assuntoEntity.getTitulo(),
                        assuntoEntity.getTexto(),
                        new AssuntoResponse(assuntoEntity.getAssuntoEntity().getNome())
                ), HttpStatus.OK
        );
    }

    @GetMapping("/assunto")
    public ResponseEntity encontrarPerguntasPorAssunto(@RequestParam("idAssunto") String id) {
        List<PerguntaEntity> perguntaEntities = perguntaRepository.findPerguntaEntitiesByAssuntoEntity_Id(Long.parseLong(id));

        return ResponseEntity.ok(perguntaEntities);
    }

    @PostMapping
    public ResponseEntity<PerguntaResponse> salvarPergunta(@RequestBody PerguntaRequest perguntaRequest) {
        AssuntoEntity assuntoEntity = assuntoRepository.findById(perguntaRequest.getIdAssunto()).get();

        PerguntaEntity perguntaEntity = perguntaRepository.save(new PerguntaEntity(perguntaRequest.getTitulo()
                , perguntaRequest.getTexto()
                , assuntoEntity));

        return new ResponseEntity<PerguntaResponse>(
                new PerguntaResponse(perguntaEntity.getTitulo()
                        , perguntaEntity.getTexto()
                        , new AssuntoResponse(perguntaEntity.getAssuntoEntity().getNome())),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerguntaResponse> atualizarPerguntaPorId(
            @PathVariable Long id,
            @RequestBody PerguntaRequest request
    ) {
        AssuntoEntity assuntoEntity = assuntoRepository.findById(request.getIdAssunto()).get();

        PerguntaEntity perguntaEntity = perguntaRepository.findById(id).get();
        perguntaEntity.setTitulo(request.getTitulo());
        perguntaEntity.setTexto(request.getTexto());
        perguntaEntity.setAssuntoEntity(assuntoEntity);
        perguntaRepository.save(perguntaEntity);

        return new ResponseEntity<PerguntaResponse>(
                new PerguntaResponse(perguntaEntity.getTitulo()
                        , perguntaEntity.getTexto()
                        , new AssuntoResponse(perguntaEntity.getAssuntoEntity().getNome())),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPerguntaPorId(@PathVariable Long id) {
        respostaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}

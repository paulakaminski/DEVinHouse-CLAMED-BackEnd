package exercicios.semana10.controller;

import exercicios.semana10.controller.dto.*;
import exercicios.semana10.dataprovider.entity.PerguntaEntity;
import exercicios.semana10.dataprovider.entity.RespostaEntity;
import exercicios.semana10.dataprovider.repository.PerguntaRepository;
import exercicios.semana10.dataprovider.repository.RespostaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/resposta")
public class RespostaController {
    private final RespostaRepository respostaRepository;
    private final PerguntaRepository perguntaRepository;


    public RespostaController(RespostaRepository respostaRepository, PerguntaRepository perguntaRepository) {
        this.respostaRepository = respostaRepository;
        this.perguntaRepository = perguntaRepository;
    }

    @GetMapping
    public ResponseEntity<List<RespostaResponse>> encontrarRespostas() {
        List<RespostaEntity> entityList = respostaRepository.findAll();

        List<RespostaResponse> responseList = new ArrayList<>();
        for (RespostaEntity entity : entityList) {
            responseList.add(
                    new RespostaResponse(entity.getTexto()
                            , new PerguntaResponse(entity.getPerguntaEntity().getTitulo()
                            , entity.getPerguntaEntity().getTexto()
                            , new AssuntoResponse(entity.getPerguntaEntity().getAssuntoEntity().getNome()))));
        }

        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespostaResponse> encontrarRespostaPorId(@PathVariable Long id) {
        RespostaEntity respostaEntity = respostaRepository.findById(id).get();

        return new ResponseEntity<RespostaResponse>(
                new RespostaResponse(
                        respostaEntity.getTexto()
                        , new PerguntaResponse(
                        respostaEntity.getPerguntaEntity().getTitulo()
                        , respostaEntity.getPerguntaEntity().getTexto()
                        , new AssuntoResponse(respostaEntity.getPerguntaEntity().getAssuntoEntity().getNome())

                )), HttpStatus.OK
        );
    }

    @GetMapping("/pergunta")
    public ResponseEntity encontrarRespostasPorPergunta(@RequestParam("idPergunta") String id) {
        List<RespostaEntity> respostaEntities = respostaRepository.findRespostaEntitiesByPerguntaEntity_Id(Long.parseLong(id));

        return ResponseEntity.ok(respostaEntities);
    }

    @PostMapping
    public ResponseEntity<RespostaResponse> salvarResposta(@RequestBody RespostaRequest respostaRequest) {
        PerguntaEntity perguntaEntity = perguntaRepository.findById(respostaRequest.getIdPergunta()).get();

        RespostaEntity respostaEntity = respostaRepository.save(new RespostaEntity(respostaRequest.getTexto()
                , perguntaEntity));

        return new ResponseEntity<RespostaResponse>(
                new RespostaResponse(respostaEntity.getTexto()
                        , new PerguntaResponse(
                                respostaEntity.getPerguntaEntity().getTitulo()
                                , respostaEntity.getPerguntaEntity().getTexto()
                                , new AssuntoResponse(respostaEntity.getPerguntaEntity().getAssuntoEntity().getNome()))
                ),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespostaResponse> atualizarRespostaPorId(
            @PathVariable Long id,
            @RequestBody RespostaRequest request
    ) {
        PerguntaEntity perguntaEntity = perguntaRepository.findById(request.getIdPergunta()).get();

        RespostaEntity respostaEntity = respostaRepository.findById(id).get();
        respostaEntity.setTexto(request.getTexto());
        respostaEntity.setPerguntaEntity(perguntaEntity);
        respostaRepository.save(respostaEntity);

        return new ResponseEntity<RespostaResponse>(
                new RespostaResponse(respostaEntity.getTexto()
                        , new PerguntaResponse(
                                respostaEntity.getPerguntaEntity().getTitulo()
                                , respostaEntity.getPerguntaEntity().getTexto()
                                , new AssuntoResponse(respostaEntity.getPerguntaEntity().getAssuntoEntity().getNome()))
                ),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarRespostaPorId(@PathVariable Long id) {
        respostaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}


//AnotaçãoEntity
//ManyToOne MateriaEntity

//MateriaController
//retornaNotasMateria

//______________________________

//- Listar Perguntas por Assunto

//PerguntaEntity
//ManyToOne AssuntoEntity

//AssuntoController
//encontrarPerguntaPorAssunto

//______________________________

//- Listar Respostas por Pergunta

//RespostaEntity
//ManyToOne PerguntaEntity

//PerguntaController
//encontrarRespostaPorPergunta

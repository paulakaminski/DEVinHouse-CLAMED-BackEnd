package com.example.demo.controller;

import com.example.demo.controller.dto.AnotacaoRequest;
import com.example.demo.controller.dto.AnotacaoResponse;
import com.example.demo.controller.dto.TagRequest;
import com.example.demo.controller.dto.TagResponse;
import com.example.demo.dataprovider.entity.AnotacaoEntity;
import com.example.demo.dataprovider.entity.TagEntity;
import com.example.demo.dataprovider.repository.NotaRepository;
import com.example.demo.dataprovider.repository.TagRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/nota")
public class NotaController {

    private final NotaRepository notaRepository;
    private final TagRepository tagRepository;

    public NotaController(NotaRepository notaRepository, TagRepository tagRepository) {
        this.notaRepository = notaRepository;
        this.tagRepository = tagRepository;
    }

    @GetMapping
    public ResponseEntity encontrarNotas() {
        notaRepository.save(new AnotacaoEntity("Titulo0", "Nota0"));
        notaRepository.save(new AnotacaoEntity("Titulo1", "Nota1"));

        List<AnotacaoEntity> entityList = notaRepository.findAll();
        List<AnotacaoResponse> responseList = new ArrayList<>();
        for (AnotacaoEntity anotacaoEntity : entityList) {
            responseList.add(
                    new AnotacaoResponse(anotacaoEntity.getTitulo(), anotacaoEntity.getTexto())
            );
        }

        return ResponseEntity.ok(responseList);
    }

    @PostMapping
    public ResponseEntity salvarNota(@RequestBody AnotacaoRequest anotacaoRequest) {
        AnotacaoEntity anotacaoEntity = notaRepository.save(new AnotacaoEntity(anotacaoRequest.getTitulo(), anotacaoRequest.getTexto()));

        return new ResponseEntity(new AnotacaoResponse(anotacaoEntity.getTitulo(), anotacaoEntity.getTexto()),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnotacaoResponse> encontrarNotaPorId(@PathVariable Long id) {
        AnotacaoEntity anotacaoEntity = notaRepository.findById(id).get();

        return new ResponseEntity<AnotacaoResponse>(
                new AnotacaoResponse(anotacaoEntity.getTitulo(), anotacaoEntity.getTexto()),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnotacaoResponse> atualizarNotaPorId(
            @PathVariable Long id,
            @RequestBody AnotacaoRequest request
    ) {
        AnotacaoEntity anotacaoEntity = notaRepository.findById(id).get();
        anotacaoEntity.setTitulo(request.getTitulo());
        anotacaoEntity.setTexto(request.getTexto());
        notaRepository.save(anotacaoEntity);

        return new ResponseEntity<AnotacaoResponse>(
                new AnotacaoResponse(anotacaoEntity.getTitulo(), anotacaoEntity.getTexto()),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AnotacaoResponse> deletarPorId(
            @PathVariable Long id
    ) {
        notaRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/tag")
    public ResponseEntity<TagResponse> adicionarTagPorNotaId(
            @PathVariable Long id,
            @RequestBody TagRequest request
    ) {
        AnotacaoEntity anotacaoEntity = notaRepository.findById(id).get(); // acho a nota de id

        TagEntity tagEntity = tagRepository.save(
                new TagEntity(request.getTag(), anotacaoEntity) // temos que salvar tanto a tag quanto o objeto NotaEntity
        ); // Salvar uma TagEntity com os dados da requisição
        return ResponseEntity.ok(
                new TagResponse(
                        tagEntity.getTag(), tagEntity.getAnotacaoEntity().getId()
                ));
    }

    @GetMapping("/{id}/tag")
    public ResponseEntity procurarTagPorNotaId(
            @PathVariable Long id
    ) {
        AnotacaoEntity anotacaoEntity = notaRepository.findById(id).get(); // acho a nota de id

        List<TagEntity> tagEntity = tagRepository.findAll();

        return ResponseEntity.ok(
                tagEntity);
    }

}

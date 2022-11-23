package tech.semana09.controller;

import org.springframework.web.bind.annotation.*;
import tech.semana09.entity.PessoaEntity;
import tech.semana09.service.PessoaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @PostMapping
    public void save(@RequestBody PessoaEntity pessoa) {
        service.insert(pessoa);
    }

    @GetMapping
    public List<PessoaEntity> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<PessoaEntity> getById(@PathVariable("id") String id) {
        return service.getById(Long.parseLong(id));
    }

    @GetMapping("/true")
    public List<PessoaEntity> getStatusTrue() {
        return service.getByStatus();
    }

}

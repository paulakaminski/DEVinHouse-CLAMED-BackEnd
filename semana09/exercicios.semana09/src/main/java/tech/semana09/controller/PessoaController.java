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

    @GetMapping("/status-true")
    public List<PessoaEntity> getStatusTrue() {
        return service.getByStatus();
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody PessoaEntity pessoa, @PathVariable("id") String id) {
        service.update(pessoa, Long.parseLong(id));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id) {
        service.delete(Long.parseLong(id));
    }

    @GetMapping("/filter")
    public List<PessoaEntity> filterByNameOrEmail(@RequestParam("q") String filter) {
        return service.filterByNameOrEmail(filter);
    }

}

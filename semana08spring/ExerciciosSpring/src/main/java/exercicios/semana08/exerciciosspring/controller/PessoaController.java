package exercicios.semana08.exerciciosspring.controller;

import exercicios.semana08.exerciciosspring.model.PessoaModel;
import exercicios.semana08.exerciciosspring.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @PostMapping
    public void addPessoa(@RequestBody PessoaModel pessoa) {
        service.postPessoa(pessoa);
    }

    @GetMapping()
    public List<PessoaModel> getPessoas() {
        return service.getPessoas();
    }
}

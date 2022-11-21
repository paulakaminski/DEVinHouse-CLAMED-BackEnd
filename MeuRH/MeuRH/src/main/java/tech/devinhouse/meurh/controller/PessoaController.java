package tech.devinhouse.meurh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.meurh.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @GetMapping()
    public String getPessoas() {
        return "teste";
    }

    @GetMapping("/{id}")
    public String getPessoaById(@PathVariable("id") String id) {
        return id;
    }

}

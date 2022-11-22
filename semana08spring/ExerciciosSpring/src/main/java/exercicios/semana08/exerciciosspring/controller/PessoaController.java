//exercicio 04
//Crie seu primeiro projeto Spring e organize os packages contendo o padrão de controller, service e repository.
//Nesse momento, você somente irá iniciar e ver se o projeto está executando normalmente.

package exercicios.semana08.exerciciosspring.controller;

import exercicios.semana08.exerciciosspring.model.PessoaModel;
import exercicios.semana08.exerciciosspring.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @PostMapping
    public void postPessoa(@RequestBody PessoaModel pessoa) {
        service.postPessoa(pessoa);
    }

    @GetMapping()
    public List<PessoaModel> getPessoas() {
        return service.getPessoas();
    }

    @GetMapping("/{id}")
    public PessoaModel getPessoa(@PathVariable("id") String id) {
        return service.getPessoa(Long.parseLong(id));
    }

    @PutMapping("/update")
    public void updatePessoa (@RequestBody PessoaModel pessoa) {
        service.updatePessoa(pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletePessoa(@PathVariable("id") String id) {
        service.deletePessoa(Long.parseLong(id));
    }

}

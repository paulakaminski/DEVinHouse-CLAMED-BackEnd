package exercicios.semana08.exerciciosspring.service;

import exercicios.semana08.exerciciosspring.model.PessoaModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    private static List<PessoaModel> pessoas = new ArrayList<>();

    @GetMapping
    public List<PessoaModel> getPessoas() {
        if(pessoas.size() > 0) {
            return pessoas;
        } else {
            return pessoas;
        }
    }

    @GetMapping
    public List<PessoaModel> getPessoa(Long id) {
        return pessoas;
    }

    @PostMapping
    public void postPessoa(PessoaModel pessoa) {
        pessoas.add(pessoa);
    }

    public void updatePessoa() {

    }
}

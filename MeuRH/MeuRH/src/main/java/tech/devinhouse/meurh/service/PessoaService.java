package tech.devinhouse.meurh.service;

import org.springframework.stereotype.Service;
import tech.devinhouse.meurh.model.PessoaModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    private static List<PessoaModel> pessoaModelList = new ArrayList<>();

    public PessoaService() {
        PessoaModel pessoa = new PessoaModel(1L, "pessoa1", "pessoa1@teste.com");
        PessoaModel pessoa2 = new PessoaModel(2L, "pessoa2", "pessoa2@teste.com");
    }

}

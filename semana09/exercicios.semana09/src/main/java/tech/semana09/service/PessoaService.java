package tech.semana09.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import tech.semana09.entity.PessoaEntity;
import tech.semana09.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void insert(PessoaEntity pessoa) {
        pessoaRepository.save(pessoa);
    }

    public List<PessoaEntity> getAll() {
       return pessoaRepository.findAll();
    }

    public Optional<PessoaEntity> getById(Long id) {
        return pessoaRepository.findById(id);
    }

    public List<PessoaEntity> getByStatus() {
        return pessoaRepository.findByStatus(true);
    }

}

package com.clamed.service;

import com.clamed.model.Contato;
import com.clamed.repository.ContatoRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    private static final Logger logger = LoggerFactory.getLogger(ContatoService.class);

    public Contato salvar(Contato contato) {
        log.trace("Mensagem de TRACE");
        log.debug("Mensagem de DEBUG");
        log.info("Mensagem de INFO");
        log.warn("Mensagem de AVISO");
        log.error("Mensagem de ERRO");

        return contatoRepository.save(contato);
    }

    public List<Contato> encontrarContatos() {
       return contatoRepository.findAll();
    }

    public void deletarContatoPorId(Long id) {
        contatoRepository.deleteById(id);
    }

    public List<Contato> encontrarContatoPorNome(String nome) {
       List<Contato> contatos = contatoRepository.getContatosByName(nome);
       return contatos;
    }
}

package com.clamed.controllers;

import com.clamed.dto.ContatoInput;
import com.clamed.dto.ContatoOutput;
import com.clamed.model.Contato;
import com.clamed.service.ContatoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping
    public ResponseEntity<ContatoOutput> cadastrarContato(@RequestBody ContatoInput contatoInput) {
        Contato contato = new Contato();
        BeanUtils.copyProperties(contatoInput, contato);

        Contato c = contatoService.salvar(contato);

        ContatoOutput co = new ContatoOutput();
        BeanUtils.copyProperties(c, co);

        return new ResponseEntity<ContatoOutput>(co, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Contato> encontrarContatos() {
        return contatoService.encontrarContatos();
    }

    @GetMapping("/nome")
    public List<Contato> encontrarContatoPorNome(@RequestParam("q") String nome) {
        return contatoService.encontrarContatoPorNome(nome);
    }

}

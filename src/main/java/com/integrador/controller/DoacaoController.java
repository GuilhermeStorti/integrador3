package com.integrador.controller;

import com.integrador.domain.Doacao;
import com.integrador.service.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
@CrossOrigin
@RestController
@RequestMapping("/recibo")
public class DoacaoController {

    @Autowired
    private DoacaoService service;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Doacao>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.findAll());
    }

    @CrossOrigin
    @RequestMapping(value = "/{numeroRecibo }", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Doacao> findById( @PathVariable("numeroRecibo ") Integer numeroRecibo ) {
        Doacao doacao = this.service.findById(numeroRecibo );
        return ResponseEntity.status(HttpStatus.OK).body(doacao);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Doacao doacao) {
        this.service.save(doacao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{numeroRecibo }").buildAndExpand(doacao.getNumeroRecibo()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{numeroRecibo }", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Doacao doacao, @PathVariable("numeroRecibo ") Integer numeroRecibo ) {
        this.service.update(doacao);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{numeroRecibo }", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("numeroRecibo ") Integer numeroRecibo ) {
        this.service.delete(numeroRecibo );
        return ResponseEntity.ok().build();
    }
}

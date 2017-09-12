package com.integrador.controller;

import com.integrador.domain.Endereco;
import com.integrador.service.EnderecoService;
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
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Endereco>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.findAll());
    }

    @CrossOrigin
    @RequestMapping(value = "/{cep}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Endereco> findById(@PathVariable("cep") Integer cep) {
        Endereco endereco = this.service.findById(cep);
        return ResponseEntity.status(HttpStatus.OK).body(endereco);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Endereco endereco) {
        this.service.save(endereco);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cep}").buildAndExpand(endereco.getCep()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{cep}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Endereco endereco, @PathVariable("cep") Integer cep) {
        this.service.update(endereco);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{cep}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("cep") Integer cep) {
        this.service.delete(cep);
        return ResponseEntity.ok().build();
    }
}

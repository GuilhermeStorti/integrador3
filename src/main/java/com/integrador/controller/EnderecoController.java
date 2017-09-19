package com.integrador.controller;

import com.integrador.domain.Endereco;
import com.integrador.representation.EnderecoRepresentation;
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
import java.util.ArrayList;
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
    @RequestMapping(value = "/{cep}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> findById(@PathVariable("cep") Integer cep) {
        EnderecoRepresentation representation = new EnderecoRepresentation(this.service.findById(cep));
        return ResponseEntity.status(HttpStatus.OK).body(representation);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody EnderecoRepresentation representation) {
        this.service.save(new EnderecoRepresentation().build(representation));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cep}").buildAndExpand(representation.getCep()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{cep}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody EnderecoRepresentation representation, @PathVariable("cep") Integer cep) {
        this.service.update(new EnderecoRepresentation().build(representation));
        return ResponseEntity.noContent().build();
    }
}

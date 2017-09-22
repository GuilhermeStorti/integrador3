package com.integrador.controller;

import com.integrador.domain.Funcionario;
import com.integrador.representation.FuncionarioRepresentation;
import com.integrador.service.FuncionarioService;
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
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        List<Funcionario> funcionarios = this.service.findAll();
        List<FuncionarioRepresentation> representations = new ArrayList<>();
        for(Funcionario f : funcionarios){
            representations.add(new FuncionarioRepresentation(f));
        }
        return ResponseEntity.status(HttpStatus.OK).body(representations);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        FuncionarioRepresentation representation = new FuncionarioRepresentation(this.service.findById(id));
        return ResponseEntity.status(HttpStatus.OK).body(representation);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody FuncionarioRepresentation representation) {
        this.service.save(new FuncionarioRepresentation().build(representation));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(representation.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody FuncionarioRepresentation representation, @PathVariable("id") Integer id) {
        this.service.update(new FuncionarioRepresentation().build(representation));
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/findAtualMotoboy", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> findAtualMotoboy() {
        FuncionarioRepresentation representation = new FuncionarioRepresentation(this.service.findAtualMotoboy());
        return ResponseEntity.status(HttpStatus.OK).body(representation);
    }
}

package com.integrador.controller;

import com.integrador.domain.Contribuinte;
import com.integrador.representation.ContribuinteRepresentation;
import com.integrador.service.ContribuinteService;
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
@RequestMapping("/contribuinte")
public class ContribuinteController {

    @Autowired
    private ContribuinteService service;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        List<Contribuinte> contribuintes = this.service.findAll();
        List<ContribuinteRepresentation> representations = new ArrayList<>();
        for(Contribuinte c : contribuintes){
            representations.add(new ContribuinteRepresentation(c));
        }
        return ResponseEntity.status(HttpStatus.OK).body(representations);
    }

    @CrossOrigin
    @RequestMapping(value = "/findByNome/{nome}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> findByNome(@PathVariable("nome") String nome) {
        List<Contribuinte> contribuintes = this.service.findByNome(nome.toUpperCase());
        List<ContribuinteRepresentation> representations = new ArrayList<>();
        for(Contribuinte c : contribuintes){
            representations.add(new ContribuinteRepresentation(c));
        }
        return ResponseEntity.status(HttpStatus.OK).body(representations);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        ContribuinteRepresentation representation = new ContribuinteRepresentation(this.service.findById(id));
        return ResponseEntity.status(HttpStatus.OK).body(representation);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody ContribuinteRepresentation representation) {
        this.service.save(new ContribuinteRepresentation().build(representation));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(representation.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody ContribuinteRepresentation representation, @PathVariable("id") Integer id) {
        this.service.update(new ContribuinteRepresentation().build(representation));
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }
}

package com.integrador.controller;

import com.integrador.domain.Campanha;
import com.integrador.representation.CampanhaRepresentation;
import com.integrador.service.CampanhaService;
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
@RequestMapping("/campanha")
public class CampanhaController {

    @Autowired
    private CampanhaService service;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        List<Campanha> campanhas = this.service.findAll();
        List<CampanhaRepresentation> representations = new ArrayList<>();
        for(Campanha c : campanhas){
            representations.add(new CampanhaRepresentation(c));
        }
        return ResponseEntity.status(HttpStatus.OK).body(representations);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        CampanhaRepresentation representation = new CampanhaRepresentation(this.service.findById(id));
        return ResponseEntity.status(HttpStatus.OK).body(representation);
    }

    @CrossOrigin
    @RequestMapping(value = "/filtroDescricao/{descricao}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> findByDescricao(@PathVariable("descricao") String descricao) {
        List<Campanha> campanhas = this.service.findByDescricao(descricao.toUpperCase());
        List<CampanhaRepresentation> representations = new ArrayList<>();
        for(Campanha c : campanhas){
            representations.add(new CampanhaRepresentation(c));
        }
        return ResponseEntity.status(HttpStatus.OK).body(representations);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody CampanhaRepresentation representation) {
        Campanha campanha = new CampanhaRepresentation().build(representation);
        this.service.save(campanha);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(campanha.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody CampanhaRepresentation representation, @PathVariable("id") Integer id) {
        Campanha campanha = new CampanhaRepresentation().build(representation);
        this.service.update(campanha);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }
}

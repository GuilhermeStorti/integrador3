package com.integrador.controller;

import com.integrador.domain.Doacao;
import com.integrador.representation.DoacaoRepresentation;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guilhermeplasma on 19/08/17.
 */
@CrossOrigin
@RestController
@RequestMapping("/doacao")
public class DoacaoController {

    @Autowired
    private DoacaoService service;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        List<Doacao> doacaos = this.service.findAll();
        List<DoacaoRepresentation> representations = new ArrayList<>();
        for(Doacao d : doacaos){
            representations.add(new DoacaoRepresentation(d));
        }
        return ResponseEntity.status(HttpStatus.OK).body(representations);
    }

    @CrossOrigin
    @RequestMapping(value = "/{numeroRecibo }", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> findById( @PathVariable("numeroRecibo ") Integer numeroRecibo) {
        DoacaoRepresentation representation = new DoacaoRepresentation(this.service.findById(numeroRecibo));
        return ResponseEntity.status(HttpStatus.OK).body(representation);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody DoacaoRepresentation representation) {
        this.service.save(new DoacaoRepresentation().build(representation));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{numeroRecibo }").buildAndExpand(representation.getNumeroRecibo()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{numeroRecibo }", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody DoacaoRepresentation representation, @PathVariable("numeroRecibo ") Integer numeroRecibo ) {
        this.service.update(new DoacaoRepresentation().build(representation));
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{numeroRecibo }", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("numeroRecibo ") Integer numeroRecibo ) {
        this.service.delete(numeroRecibo );
        return ResponseEntity.ok().build();
    }
}

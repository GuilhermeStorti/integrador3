package com.integrador.controller;

import com.integrador.domain.Empresa;
import com.integrador.representation.EmpresaRepresentation;
import com.integrador.service.EmpresaService;
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
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        List<Empresa> empresas = this.service.findAll();
        List<EmpresaRepresentation> representations = new ArrayList<>();
        for (Empresa u : empresas){
            representations.add(new EmpresaRepresentation(u));
        }
        return ResponseEntity.ok(representations);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        EmpresaRepresentation representation = new EmpresaRepresentation(this.service.findById(id));
        return ResponseEntity.status(HttpStatus.OK).body(representation);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody EmpresaRepresentation representation) {
        this.service.save(new EmpresaRepresentation().build(representation));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(representation.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody EmpresaRepresentation representation, @PathVariable("id") Integer id) {
        this.service.update(new EmpresaRepresentation().build(representation));
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }
}

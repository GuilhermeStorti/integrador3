package com.integrador.controller;

import com.integrador.domain.Recibos;
import com.integrador.service.ReciboService;
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
public class ReciboResource {

    @Autowired
    private ReciboService service;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Recibos>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.findAll());
    }

    @CrossOrigin
    @RequestMapping(value = "/{numeroRecibo }", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Recibos> findById(@PathVariable("numeroRecibo ") Integer numeroRecibo ) {
        Recibos recibo = this.service.findById(numeroRecibo );
        return ResponseEntity.status(HttpStatus.OK).body(recibo);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Recibos recibo) {
        this.service.save(recibo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{numeroRecibo }").buildAndExpand(recibo.getNumeroRecibo()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{numeroRecibo }", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Recibos recibo, @PathVariable("numeroRecibo ") Integer numeroRecibo ) {
        this.service.update(recibo);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{numeroRecibo }", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("numeroRecibo ") Integer numeroRecibo ) {
        this.service.delete(numeroRecibo );
        return ResponseEntity.ok().build();
    }
}

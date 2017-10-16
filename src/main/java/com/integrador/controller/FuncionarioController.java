package com.integrador.controller;

import com.integrador.domain.Funcionario;
import com.integrador.representation.FuncionarioRepresentation;
import com.integrador.service.CargoService;
import com.integrador.service.EnderecoService;
import com.integrador.service.FuncionarioService;
import com.integrador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CargoService cargoService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        List<Funcionario> funcionarios = this.service.findAll();

        return ResponseEntity.ok().body(funcionarios);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(this.service.findById(id));
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Funcionario funcionario) {
        funcionario.setEndereco(this.enderecoService.save(funcionario.getEndereco()));
        funcionario.setUsuario(this.usuarioService.save(funcionario.getUsuario()));
        funcionario.setCargo(this.cargoService.findById(funcionario.getCargo().getId()));
        this.service.save(funcionario);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Funcionario> update(@RequestBody Funcionario funcionario, @PathVariable("id") Integer id) {
        funcionario.setEndereco(this.enderecoService.update(funcionario.getEndereco()));
        funcionario.setCargo(this.cargoService.findById(funcionario.getCargo().getId()));
        funcionario.setUsuario(this.usuarioService.findById(id));
        this.service.update(funcionario);
        return ResponseEntity.ok().body(funcionario);
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

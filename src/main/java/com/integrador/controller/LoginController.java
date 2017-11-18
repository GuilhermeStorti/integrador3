package com.integrador.controller;

import com.integrador.representation.UsuarioRepresentation;
import com.integrador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by guilhermeplasma on 05/10/17.
 */
@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UsuarioService usuarioService;

    @CrossOrigin
    @RequestMapping(value = "/validateUser/{user}/{password}", method = RequestMethod.GET)
    public ResponseEntity<?>  validateUser(@PathVariable("user") String user, @PathVariable("password") String password){
        UsuarioRepresentation representation = new UsuarioRepresentation(this.usuarioService.validateUser(user, password));
        return ResponseEntity.ok(representation);
    }

}

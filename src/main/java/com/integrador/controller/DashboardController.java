package com.integrador.controller;

import com.integrador.domain.Funcionario;
import com.integrador.service.ContribuinteService;
import com.integrador.service.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guilhermeplasma on 12/09/17.
 */
@CrossOrigin
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DoacaoService doacaoService;

    @Autowired
    private ContribuinteService contribuinteService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/donationsOfMounth")
    public ResponseEntity<?> findDonationsOfMounth() {
        return ResponseEntity.status(HttpStatus.OK).body(this.doacaoService.findDonationsOfMounth());
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/taxpayersSavesOfMounth")
    public ResponseEntity<?> findTaxpayersSavesOfMounth() {
        return ResponseEntity.status(HttpStatus.OK).body(this.contribuinteService.findSavesOfMounth());
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/findValueOfDonationsOfMounth")
    public ResponseEntity<?> findValueOfDonationsOfMounth(){
        Funcionario funcionario = new Funcionario();
        funcionario.setId(2);
        return ResponseEntity.status(HttpStatus.OK).body(this.doacaoService.findValueOfDonationsOfMounth(funcionario));
    }

}

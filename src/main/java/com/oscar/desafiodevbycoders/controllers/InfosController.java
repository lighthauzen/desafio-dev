package com.oscar.desafiodevbycoders.controllers;

import com.oscar.desafiodevbycoders.models.Cnab;
import com.oscar.desafiodevbycoders.services.Crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/infos")
public class InfosController {

    @Autowired
    CrudService crudService;

    @PostMapping
    public ResponseEntity listarTodos(@RequestBody Cnab cnab) {
        return crudService.criarCnab(cnab);
    }
}

package com.oscar.desafiodevbycoders.controllers;

import com.oscar.desafiodevbycoders.models.Cnab;
import com.oscar.desafiodevbycoders.services.Crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/infos")
@CrossOrigin(origins = "http://localhost:3000")
public class InfosController {

    @Autowired
    CrudService crudService;

    @PostMapping()
    public ResponseEntity listarTodos(@RequestBody Cnab cnab) {
        return crudService.criarCnab(cnab);
    }

    @GetMapping
    public ResponseEntity getAll() {
        List<Cnab> lista = crudService.getAllCnab();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {

            return ResponseEntity.status(HttpStatus.CREATED).body(lista.toArray());
        }
    }
}

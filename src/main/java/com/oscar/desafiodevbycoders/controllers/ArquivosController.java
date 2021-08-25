package com.oscar.desafiodevbycoders.controllers;

import com.oscar.desafiodevbycoders.models.Cnab;
import com.oscar.desafiodevbycoders.services.Arquivos.ArquivosService;
import com.oscar.desafiodevbycoders.services.Crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/arquivos")
public class ArquivosController {

    @Autowired
    ArquivosService arquivosService;



    @GetMapping
    public ResponseEntity listarTodos() {
        arquivosService.converterArquivoTeste();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

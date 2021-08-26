package com.oscar.desafiodevbycoders.controllers;

import com.oscar.desafiodevbycoders.models.Cnab;
import com.oscar.desafiodevbycoders.services.Arquivos.ArquivosService;
import com.oscar.desafiodevbycoders.services.Crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/arquivos")
@CrossOrigin(origins = "http://localhost:3000")
public class ArquivosController {

    @Autowired
    ArquivosService arquivosService;


    @PostMapping
    public ResponseEntity uploadArquivos(@RequestBody MultipartFile multipartFile) throws IOException {


        arquivosService.converterArquivo(multipartFile.getInputStream());
        return ResponseEntity.status(HttpStatus.CREATED).build();


}

    @GetMapping
    public ResponseEntity listarTodos() {
        arquivosService.converterArquivoTeste();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

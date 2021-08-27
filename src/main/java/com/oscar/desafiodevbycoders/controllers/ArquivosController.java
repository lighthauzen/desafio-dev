package com.oscar.desafiodevbycoders.controllers;

import com.oscar.desafiodevbycoders.models.Cnab;
import com.oscar.desafiodevbycoders.services.Arquivos.ArquivosService;
import com.oscar.desafiodevbycoders.services.Crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@RestController
@RequestMapping("/arquivos")
@CrossOrigin(origins = "http://localhost:3000")
public class ArquivosController {

    @Autowired
    ArquivosService arquivosService;


    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadArquivos(@RequestParam("file") MultipartFile multipartFile )  {
        System.out.println("multipart file");
        System.out.println(multipartFile);


        List<Cnab> lista = null;
        try {
            lista = arquivosService.converterArquivo(multipartFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("lista arquivos convertidos");
        System.out.println(lista);
        return ResponseEntity.status(HttpStatus.CREATED).build();


}

    @GetMapping
    public ResponseEntity listarTodos() {
        arquivosService.converterArquivoTeste();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

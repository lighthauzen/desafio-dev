package com.oscar.desafiodevbycoders.services.Arquivos;

import com.oscar.desafiodevbycoders.models.Cnab;
import com.oscar.desafiodevbycoders.models.Tipos_trans;
import com.oscar.desafiodevbycoders.services.Crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ArquivosServiceImpl implements ArquivosService{

    @Autowired
    CrudService crudService;

    public  static File multipartToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+fileName);
        multipart.transferTo(convFile);
        System.out.println(convFile.getName());
        return convFile;
    }


    @Override
    public List<Cnab> converterArquivo(MultipartFile multipartFile) throws IOException {

        File dados = multipartToFile(multipartFile, "cnab");
        System.out.println(dados);
        List<Cnab> cnabList = new ArrayList<>();
        List<String> stringList;
        try (Stream<String> stream = Files.lines(Paths.get(System.getProperty("java.io.tmpdir")+"/"+"cnab"))) {
            stringList = stream.collect(Collectors.toList());
        }

        stringList.forEach(string -> {

            Integer tipo = Integer.parseInt(string.substring(0,1));
            Tipos_trans tipos_trans = crudService.getTTbyId(tipo);
            LocalDate data = LocalDate.parse(string.substring(1,9),  DateTimeFormatter.BASIC_ISO_DATE);
            Integer valor = Integer.parseInt(string.substring(9,19)) / 100;
            String cpf = string.substring(19,30);
            String cartao = string.substring(30,42);
            LocalTime hora = LocalTime.parse(string.substring(42, 48), DateTimeFormatter.ofPattern("HHmmss"));
            String donoLoja = string.substring(48,62).strip();
            String nomeLoja = string.substring(62, string.length()).strip();

            Cnab objeto = new Cnab();
            objeto.setFk_tipos_trans(tipos_trans);
            objeto.setData(data);
            objeto.setValor(valor);
            objeto.setCpf(cpf);
            objeto.setCartao(cartao);
            objeto.setHora(hora);
            objeto.setDono_loja(donoLoja);
            objeto.setNome_loja(nomeLoja);

            crudService.criarCnab(objeto);
        });
        return cnabList;


    }

    @Override
    public List<Cnab> converterArquivoTeste() {
        String fileName = "C:\\Users\\oscar\\Desktop\\desafio-bycoders\\desafio-dev\\CNAB.txt";
        List<String> stringList = new ArrayList<>();
        List<Cnab> cnabList = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stringList = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        stringList.forEach(string -> {

            Integer tipo = Integer.parseInt(string.substring(0,1));
            Tipos_trans tipos_trans = crudService.getTTbyId(tipo);
            LocalDate data = LocalDate.parse(string.substring(1,9),  DateTimeFormatter.BASIC_ISO_DATE);
            Integer valor = Integer.parseInt(string.substring(9,19)) / 100;
            String cpf = string.substring(19,30);
            String cartao = string.substring(30,42);
            LocalTime hora = LocalTime.parse(string.substring(42, 48), DateTimeFormatter.ofPattern("HHmmss"));
            String donoLoja = string.substring(48,62).strip();
            String nomeLoja = string.substring(62, string.length()).strip();

            Cnab objeto = new Cnab();
            objeto.setFk_tipos_trans(tipos_trans);
            objeto.setData(data);
            objeto.setValor(valor);
            objeto.setCpf(cpf);
            objeto.setCartao(cartao);
            objeto.setHora(hora);
            objeto.setDono_loja(donoLoja);
            objeto.setNome_loja(nomeLoja);

            crudService.criarCnab(objeto);
        });
        return cnabList;
    }
}

package com.oscar.desafiodevbycoders.services.Crud;

import com.oscar.desafiodevbycoders.models.Cnab;
import com.oscar.desafiodevbycoders.models.Tipos_trans;
import org.springframework.http.ResponseEntity;

public interface CrudService {

    public abstract ResponseEntity criarCnab(Cnab cnab);
    public abstract ResponseEntity criarTipoTrans(Tipos_trans tiposTransacao);
    public abstract Tipos_trans getTTbyId(Integer id);

}

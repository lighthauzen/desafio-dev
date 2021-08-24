package com.oscar.desafiodevbycoders.services.Crud;

import com.oscar.desafiodevbycoders.models.Cnab;
import com.oscar.desafiodevbycoders.models.TiposTransacao;
import org.springframework.http.ResponseEntity;

public interface CrudService {

    public abstract ResponseEntity criarCnab(Cnab cnab);
    public abstract ResponseEntity criarTipoTransacao(TiposTransacao tiposTransacao);


}

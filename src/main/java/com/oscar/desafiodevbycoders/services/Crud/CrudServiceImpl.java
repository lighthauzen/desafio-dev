package com.oscar.desafiodevbycoders.services.Crud;

import com.oscar.desafiodevbycoders.models.Cnab;
import com.oscar.desafiodevbycoders.models.TiposTransacao;
import com.oscar.desafiodevbycoders.repositories.CnabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CrudServiceImpl implements CrudService {

    @Autowired
    public CnabRepository cnabRepository;

    @Override
    public ResponseEntity criarCnab(Cnab cnab) {
        if (cnab == null) {
            return ResponseEntity.badRequest().build();
        } else {
            this.cnabRepository.save(cnab);
            return ResponseEntity.status(HttpStatus.CREATED).body(cnab);
        }
    }

    @Override
    public ResponseEntity criarTipoTransacao(TiposTransacao tiposTransacao) {
        return null;
    }
}

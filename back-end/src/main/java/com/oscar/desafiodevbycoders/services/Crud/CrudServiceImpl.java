package com.oscar.desafiodevbycoders.services.Crud;

import com.oscar.desafiodevbycoders.models.Cnab;
import com.oscar.desafiodevbycoders.models.Tipos_trans;
import com.oscar.desafiodevbycoders.repositories.CnabRepository;
import com.oscar.desafiodevbycoders.repositories.TiposTransRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrudServiceImpl implements CrudService {

    @Autowired
    public CnabRepository cnabRepository;

    @Autowired
    public TiposTransRepository tiposTransacaoRepository;

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
    public ResponseEntity criarTipoTrans(Tipos_trans tiposTransacao) {
        return null;
    }

    @Override
    public Tipos_trans getTTbyId(Integer id) {
        Optional<Tipos_trans> x = tiposTransacaoRepository.findById(id);
        return x.get();
    }

    @Override
    public List<Cnab> getAllCnab() {
      List<Cnab> lista = cnabRepository.findAll();

      return lista;
    }
}

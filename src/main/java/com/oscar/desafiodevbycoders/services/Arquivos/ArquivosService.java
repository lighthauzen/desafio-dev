package com.oscar.desafiodevbycoders.services.Arquivos;

import com.oscar.desafiodevbycoders.models.Cnab;

import java.io.File;
import java.util.List;

public interface ArquivosService {

    public abstract List<Cnab> converterArquivo(File file);
    public abstract List<Cnab> converterArquivoTeste();
}

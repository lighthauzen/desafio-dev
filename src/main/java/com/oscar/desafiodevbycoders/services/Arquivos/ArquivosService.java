package com.oscar.desafiodevbycoders.services.Arquivos;

import com.oscar.desafiodevbycoders.models.Cnab;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface ArquivosService {

    public abstract List<Cnab> converterArquivo(MultipartFile multipartFile) throws IOException;
    public abstract List<Cnab> converterArquivoTeste();
}

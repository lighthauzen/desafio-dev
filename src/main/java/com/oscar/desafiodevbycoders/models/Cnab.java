package com.oscar.desafiodevbycoders.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cnab {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer tipo;

    private LocalDate data;

    private Integer valor;

    private String cpf;

    private String cartao;

    private LocalTime hora;

    private String donoLoja;

    private String nomeLoja;

}

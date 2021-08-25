package com.oscar.desafiodevbycoders.models;

import lombok.AllArgsConstructor;
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

    @Column(length = 11)
    private String cpf;

    @Column(length = 12)
    private String cartao;

    private LocalTime hora;

    @Column(length = 20)
    private String donoLoja;

    @Column(length = 20)
    private String nomeLoja;

}

package com.oscar.desafiodevbycoders.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tipos_trans")
public class Tipos_trans {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String descricao;

    private String natureza;

    @Type(type = "numeric_boolean")
    private boolean sinal;

}

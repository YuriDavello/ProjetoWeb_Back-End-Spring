package com.ifsp.pwe_projetofinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto {
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;
    @Column @Getter @Setter
    private String nome;
    @Column @Getter @Setter
    private Double valor;
    @Column @Getter @Setter
    private Integer quantidade;
}

package com.ifsp.pwe_projetofinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
public class Compra {
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;
    @ManyToOne
    @JoinColumn @Getter @Setter
    private Produto produto;
    @Column @Getter @Setter
    private Integer quantidade;
}

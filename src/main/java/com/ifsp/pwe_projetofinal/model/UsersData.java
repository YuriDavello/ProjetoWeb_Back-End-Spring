package com.ifsp.pwe_projetofinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UsersData {
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;
    @Column @Getter @Setter
    private String nome;
    @Column @Getter @Setter
    private String cpf;
    @Column @Getter @Setter
    private Date nascimento;
    @Column @Getter @Setter
    private String telefone;
    @JoinColumn @Getter @Setter
    @ManyToOne
    private Compra compra;
}

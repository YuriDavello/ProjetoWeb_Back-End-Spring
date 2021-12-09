package com.ifsp.pwe_projetofinal.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class UsersData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String cpf;
    private Date nascimento;
    @Column(unique = true)
    private String telefone;
}

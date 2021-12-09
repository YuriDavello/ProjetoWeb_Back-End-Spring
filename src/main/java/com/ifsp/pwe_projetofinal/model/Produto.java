package com.ifsp.pwe_projetofinal.model;

import lombok.*;
import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double valor;
    private Integer quantidade;
}

package com.ifsp.pwe_projetofinal.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;

@Data  @NoArgsConstructor  @AllArgsConstructor
@Entity(name = "Usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @JoinColumn
    @ManyToOne
    private UsersData usersData;
    private String token;
}

package com.ifsp.pwe_projetofinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;
    @Column @Getter @Setter
    private String email;
    @Column @Getter @Setter
    private String password;
    @JoinColumn
    @Getter @Setter
    @ManyToOne
    private UsersData usersData;
    @Column @Getter @Setter
    private Boolean isAdmin;
}

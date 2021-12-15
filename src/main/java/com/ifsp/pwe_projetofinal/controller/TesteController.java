package com.ifsp.pwe_projetofinal.controller;

import com.ifsp.pwe_projetofinal.model.Teste;
import com.ifsp.pwe_projetofinal.service.TesteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("teste")
public class TesteController {

    @Autowired
    private TesteService t;

    @PostMapping("confirmar")
    public String confirmarCadastro(@RequestBody Teste teste) {
        return t.confirmarCadastro(teste);
    }
}

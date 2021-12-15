package com.ifsp.pwe_projetofinal.service;

import com.ifsp.pwe_projetofinal.model.Teste;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url= "http://localhost:8090/" , name = "confirmar")
public interface TesteService {

    @PostMapping("confirmar")
    String confirmarCadastro(@RequestBody Teste teste);
}

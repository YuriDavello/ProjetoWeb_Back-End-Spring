package com.ifsp.pwe_projetofinal.service;

import com.ifsp.pwe_projetofinal.DAO.CompraRepository;
import com.ifsp.pwe_projetofinal.model.Compra;
import com.ifsp.pwe_projetofinal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {
    private final CompraRepository compraRepository;

    @Autowired
    public CompraService(CompraRepository compraRepository){
        this.compraRepository = compraRepository;
    }
}

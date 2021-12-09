package com.ifsp.pwe_projetofinal.service;

import com.ifsp.pwe_projetofinal.DAO.UsersDataRepository;
import com.ifsp.pwe_projetofinal.model.UsersData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class UsersDataService {
    private final UsersDataRepository usersDataRepository;

    public String update(Long id, UsersData usersData){
        UsersData aux = getById(id);
        aux.setNome(usersData.getNome());
        aux.setCpf(usersData.getCpf());
        aux.setNascimento(usersData.getNascimento());
        usersDataRepository.save(aux);
        return "dados alterados!";
    }

    public UsersData getById(Long id){
        return usersDataRepository.findById(id).get();
    }
}

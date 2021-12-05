package com.ifsp.pwe_projetofinal.service;

import com.ifsp.pwe_projetofinal.DAO.UsersDataRepository;
import com.ifsp.pwe_projetofinal.model.UsersData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersDataService {
    private final UsersDataRepository usersDataRepository;

    @Autowired
    public UsersDataService(UsersDataRepository usersDataRepository){
        this.usersDataRepository = usersDataRepository;
    }

    public void update(Long id, UsersData usersData){
        UsersData aux = getById(id);
        aux.setNome(usersData.getNome());
        aux.setCpf(usersData.getCpf());
        aux.setNascimento(usersData.getNascimento());
        usersDataRepository.save(aux);
    }

    public UsersData getById(Long id){
        return usersDataRepository.findById(id).get();
    }
}

package com.ifsp.pwe_projetofinal.DAO;

import com.ifsp.pwe_projetofinal.model.UsersData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDataRepository extends CrudRepository<UsersData, Long> {

}

package com.ifsp.pwe_projetofinal.DAO;

import com.ifsp.pwe_projetofinal.model.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Long> {

}

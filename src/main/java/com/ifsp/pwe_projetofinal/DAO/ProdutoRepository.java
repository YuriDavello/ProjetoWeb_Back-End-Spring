package com.ifsp.pwe_projetofinal.DAO;

import com.ifsp.pwe_projetofinal.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    Produto findByNome(String nome);
}


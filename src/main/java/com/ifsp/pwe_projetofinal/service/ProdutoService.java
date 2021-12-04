package com.ifsp.pwe_projetofinal.service;

import com.ifsp.pwe_projetofinal.DAO.ProdutoRepository;
import com.ifsp.pwe_projetofinal.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public Produto getById(Long id){
        return produtoRepository.findById(id).get();
    }

    public void post(Produto produto){
        produtoRepository.save(produto);
    }

    public void update(Long id, Produto produto){
        Produto aux = getById(id);
        aux.setNome(produto.getNome());
        aux.setValor(produto.getValor());
        aux.setQuantidade(produto.getQuantidade());
        produtoRepository.save(aux);
    }

    public void delete(Long id){
        produtoRepository.deleteById(id);
    }


    public Produto getByNome(String nome) {
        Produto produto = produtoRepository.findByNome(nome);
        return produto;
    }
}

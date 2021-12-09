package com.ifsp.pwe_projetofinal.service;

import com.ifsp.pwe_projetofinal.DAO.ProdutoRepository;
import com.ifsp.pwe_projetofinal.model.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service @RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public Produto getById(Long id){
        return produtoRepository.findById(id).get();
    }

    public String save(Produto produto){
        produtoRepository.save(produto);
        return "produto salvo!";
    }

    public String update(Long id, Produto produto){
        Produto aux = getById(id);
        aux.setNome(produto.getNome());
        aux.setValor(produto.getValor());
        aux.setQuantidade(produto.getQuantidade());
        produtoRepository.save(aux);
        return "produto atualizado!";
    }

    public String delete(Long id){
         produtoRepository.deleteById(id);
         return "produto deletado!";
    }

    public List<Produto> getProdutos(){
      return (List<Produto>) produtoRepository.findAll();
    }

    public Produto getByNome(String nome) {
        Produto produto = produtoRepository.findByNome(nome);
        return produto;
    }
}

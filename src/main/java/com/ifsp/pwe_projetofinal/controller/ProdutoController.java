package com.ifsp.pwe_projetofinal.controller;


import com.ifsp.pwe_projetofinal.model.Produto;
import com.ifsp.pwe_projetofinal.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ProdutoController {
    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/pwe/getProduto/{id}")
    public Produto getById(@PathVariable("id") Long id){
        return produtoService.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/pwe/getProdutoByName")
    public Produto getByNome(@RequestBody Produto produto){
        return produtoService.getByNome(produto.getNome());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/pwe/postProduto")
    public String post(@RequestBody Produto produto){
        produtoService.post(produto);
        return "produto adicionado com sucesso!!!";
    }

    @RequestMapping(method = RequestMethod.PUT, path = "pwe/updateUser")
    public String update(@RequestBody Produto produto){
        produtoService.update(produto.getId(), produto);
        return "usuario atualizado com sucesso!!!";
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/pwe/deleteProduto")
    public String delete(@RequestBody Produto produto){
        produtoService.delete(produto.getId());
        return "produto deletado com sucesso!!!";
    }
}

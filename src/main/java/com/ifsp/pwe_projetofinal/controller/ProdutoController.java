package com.ifsp.pwe_projetofinal.controller;


import com.ifsp.pwe_projetofinal.model.Produto;
import com.ifsp.pwe_projetofinal.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin @RequiredArgsConstructor @RequestMapping("/pwe")
public class ProdutoController {
    private final ProdutoService produtoService;

    @GetMapping("/getProduto/{id}")
    public ResponseEntity<Produto>getById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(produtoService.getById(id));
    }

    @GetMapping("/getProdutoByName")
    public ResponseEntity<Produto>getByName(@RequestBody Produto produto){
        return ResponseEntity.ok().body(produtoService.getByNome(produto.getNome()));
    }

    @PostMapping("/postProduto")
    public ResponseEntity<String>saveProduto(@RequestBody Produto produto){
        return ResponseEntity.ok().body(produtoService.save(produto));
    }

    @PutMapping("/updateProduto")
    public ResponseEntity<String>update(@RequestBody Produto produto){
        return ResponseEntity.ok().body(produtoService.update(produto.getId(), produto));
    }

    @GetMapping("/getAllProdutos")
    public ResponseEntity<List<Produto>>getAllProdutos(){
        return ResponseEntity.ok().body(produtoService.getProdutos());
    }

    @DeleteMapping("/deleteProduto")
    public ResponseEntity<String>delete(@RequestBody Produto produto){
        return ResponseEntity.ok().body(produtoService.delete(produto.getId()));
    }
}

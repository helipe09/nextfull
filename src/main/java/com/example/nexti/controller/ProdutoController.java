package com.example.nexti.controller;

import com.example.nexti.entity.Cliente;
import com.example.nexti.entity.Produto;
import com.example.nexti.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping

    public List<Produto> listar(){
        List<Produto> produto = produtoRepository.findAll();
        return produto;
    }

    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public Produto findById(@PathVariable int id){
        final Produto produto = produtoRepository.findById(id).orElse(null);
        return produto;
    }


    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void salvar(@RequestBody Produto produto) {
        produtoRepository.save(produto);
    }

    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        produtoRepository.deleteById(id);
    }
}

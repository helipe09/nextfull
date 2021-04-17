package com.example.nexti.controller;

import com.example.nexti.entity.Cliente;
import com.example.nexti.entity.Produto;
import com.example.nexti.repository.ClienteRepository;
import com.example.nexti.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping("/produtos")

    public List<Produto> listar(){
        List<Produto> produto = produtoRepository.findAll();
        return produto;
    }



    @ResponseBody
    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(path = "/novoProduto", method = RequestMethod.POST)
    public void salvar(@RequestBody Produto produto) {
        produtoRepository.save(produto);
    }

    @ResponseBody
    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(path = "/produto/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable Integer id){
        produtoRepository.deleteById(id);
    }
}

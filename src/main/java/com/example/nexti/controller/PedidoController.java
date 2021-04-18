package com.example.nexti.controller;


import com.example.nexti.entity.Pedido;
import com.example.nexti.entity.Produto;
import com.example.nexti.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping

    public List<Pedido>listar(){
        List<Pedido> pedido = pedidoRepository.findAll();
        return pedido;
    }

    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public Pedido findById(@PathVariable int id){
        final Pedido pedido = pedidoRepository.findById(id).orElse(null);
        return pedido;
    }

    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void salvar(@RequestBody Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        pedidoRepository.deleteById(id);
    }
}

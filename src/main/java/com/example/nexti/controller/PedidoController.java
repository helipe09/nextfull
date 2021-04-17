package com.example.nexti.controller;

import com.example.nexti.entity.Cliente;
import com.example.nexti.entity.Pedido;
import com.example.nexti.repository.ClienteRepository;
import com.example.nexti.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping("/pedidos")

    public List<Pedido>listar(){
        List<Pedido> pedido = pedidoRepository.findAll();
        return pedido;
    }

    @ResponseBody
    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(path = "/novoPedido", method = RequestMethod.POST)
    public void salvar(@RequestBody Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @ResponseBody
    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(path = "/pedido/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable Integer id){
        pedidoRepository.deleteById(id);
    }
}

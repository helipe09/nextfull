package com.example.nexti.controller;

import com.example.nexti.entity.Cliente;
import com.example.nexti.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @ResponseBody
    @RequestMapping("/clientes")

    public List<Cliente> listar(){
    List<Cliente> cliente = clienteRepository.findAll();
    return cliente;
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/novoCliente", method = RequestMethod.POST)
    public void salvar(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/cliente/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable Integer id){
        clienteRepository.deleteById(id);
    }
}

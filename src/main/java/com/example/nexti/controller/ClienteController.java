package com.example.nexti.controller;

import com.example.nexti.entity.Cliente;
import com.example.nexti.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<Cliente> listar(){
    List<Cliente> cliente = clienteRepository.findAll();
    return cliente;
    }

    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public Cliente findById(@PathVariable int id){
        final Cliente cliente = clienteRepository.findById(id).orElse(null);
        return cliente;
    }


    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void salvar(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
    }



    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        clienteRepository.deleteById(id);
    }
}

package com.algalog.api.controller;

import com.algalog.api.domain.Cliente;
import com.algalog.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequestMapping("/clientes")
@RestController
public class Controller {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
        cliente = clienteService.salvar(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cliente.getId())
                .toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @GetMapping
    public List<Cliente> buscarTodosClientes(){
        return clienteService.buscarTodosClientes();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> buscarId(@PathVariable Long id){
        return clienteService.buscarId(id);
    }
}

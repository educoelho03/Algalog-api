package com.algalog.api.service;

import com.algalog.api.domain.Cliente;
import com.algalog.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){

        cliente.setId(null);
        return clienteRepository.save(cliente);
    }

    public List<Cliente> buscarTodosClientes(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarId(Long id){
        return clienteRepository.findById(id);
    }
}

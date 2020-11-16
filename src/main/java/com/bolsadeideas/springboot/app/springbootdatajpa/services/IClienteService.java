package com.bolsadeideas.springboot.app.springbootdatajpa.services;

import com.bolsadeideas.springboot.app.springbootdatajpa.models.entity.Cliente;

import java.util.List;

public interface IClienteService {
    public List<Cliente> findAll();

    public void delete(Cliente cliente);

    public void save(Cliente cliente);

    public Cliente findOne(Long id);
}

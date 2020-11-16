package com.bolsadeideas.springboot.app.springbootdatajpa.dao;

import com.bolsadeideas.springboot.app.springbootdatajpa.models.entity.Cliente;

import javax.persistence.PersistenceContext;
import java.util.List;

public interface IClienteDao {

    public List<Cliente> findAll();

    public void delete(Cliente cliente);

    public void save(Cliente cliente);

    public Cliente findOne(Long id);

}

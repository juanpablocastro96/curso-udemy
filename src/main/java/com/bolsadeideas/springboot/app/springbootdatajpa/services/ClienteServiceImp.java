package com.bolsadeideas.springboot.app.springbootdatajpa.services;

import com.bolsadeideas.springboot.app.springbootdatajpa.dao.ClienteDaoImp;
import com.bolsadeideas.springboot.app.springbootdatajpa.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteServiceImp implements IClienteService{

    @Autowired
    ClienteDaoImp clienteDaoImp;

    @Transactional
    @Override
    public List<Cliente> findAll() {
        return clienteDaoImp.findAll();
    }

    @Transactional
    @Override
    public void delete(Cliente cliente) {
        clienteDaoImp.delete(cliente);
    }

    @Transactional
    @Override
    public void save(Cliente cliente) {
        clienteDaoImp.save(cliente);
    }

    @Transactional
    @Override
    public Cliente findOne(Long id) {
        return clienteDaoImp.findOne(id);
    }
}

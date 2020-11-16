package com.bolsadeideas.springboot.app.springbootdatajpa.dao;

import com.bolsadeideas.springboot.app.springbootdatajpa.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
//@Repository("clienteDao") //acceso a datos con parametro para diferenciarlo de otra implementacion de la misma intefaz
public class ClienteDaoImp implements IClienteDao {

    @PersistenceContext
    private EntityManager em;



    @Override
    public List<Cliente> findAll() {
        return em.createQuery(" from Cliente").getResultList();
    }


    @Override
    public void delete(Cliente cliente) {

        if (cliente.getId() > 0 && cliente.getId() != null) {
            em.remove(cliente);

        }

    }

    /**
     * Lo que hace es un insert a ta tabla cliente
     *
     * @param cliente
     */

    @Override
    public void save(Cliente cliente) {
        if (cliente.getId() != null && cliente.getId() > 0) {
            em.merge(cliente);
        } else {
            em.persist(cliente);
        }


    }

    @Override
    public Cliente findOne(Long id) {
        return em.find(Cliente.class, id);
    }

}

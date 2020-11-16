package com.bolsadeideas.springboot.app.springbootdatajpa.controllers;


import com.bolsadeideas.springboot.app.springbootdatajpa.models.entity.Cliente;
import com.bolsadeideas.springboot.app.springbootdatajpa.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes("cliente")
public class ClienteController {


    @Value("${application.controler.titulo}")
    private String titulo;
    @Autowired
    //para si una interfaz es implementada por muchos objetos  @Qualifier("clienteDao")
    private IClienteService clienteService;

    @RequestMapping(value="/listar", method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo","Listado de clientes");
        model.addAttribute("clientes",clienteService.findAll());
        return "listar";
    }

    /**
     * Metodo que me crea un nuevo cliente
     * @param model
     * @return
     */
    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String crear(Map<String,Object> model){
        Cliente cliente = new Cliente();

        model.put("cliente",cliente);
        model.put("titulo",titulo);
        return "/form";

    }

    /**
     * cuando se guardar hay que guardar los datos
     * @param cliente
     * @return
     */
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status){

        if(result.hasErrors()){
            model.addAttribute("titulo",titulo);
            return "/form";
        }
        //llamo al insert de cliente dao que se hace con un em.persist
        clienteService.save(cliente);
        status.setComplete();
        return "redirect:listar";
    }

    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") Long id,Map<String,Object> model){
        Cliente cliente = null;
        if (0 < id){
            cliente = clienteService.findOne(id);
        }else{
            return "redirect:/listar";
        }
        model.put("cliente",cliente);
        model.put("titulo",titulo);
        return "/form";

    }

    @GetMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable Long id){

        clienteService.delete(clienteService.findOne(id));
        return "redirect:/listar";
    }


}

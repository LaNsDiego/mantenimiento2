package com.bibliotecaupt.bibliotecaupt.cliente;

import com.bibliotecaupt.bibliotecaupt.empleado.EmpleadoModel;
import com.bibliotecaupt.bibliotecaupt.empleado.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(ClienteController.BASE_URL)
public class ClienteController {

    @Autowired
    private ClienteService dao;
    public static final String BASE_URL = "/cliente";

    @GetMapping("/listar")
    public String listar(Model model){
        List<ClienteModel> lista =   dao.findAll();
        model.addAttribute("listadoCliente",lista);
        return "cliente/listar";
    }


    @GetMapping("/agregar")
    public String agregar(){
        return "cliente/agregar";
    }

    @PostMapping("/agregar")
    public String agregar(ClienteModel cliente){
        dao.save(cliente);
        return "redirect:/cliente/listar/";
    }


    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        ClienteModel cliente =  dao.findById(id).get();
        model.addAttribute("cliente",cliente);
        return "cliente/editar";
    }

    @PostMapping("/editar")
    public String editar(ClienteModel cliente){
        dao.save(cliente);
        return "redirect:/cliente/listar/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        dao.deleteById(id);
        return "redirect:/cliente/listar/";
    }
}

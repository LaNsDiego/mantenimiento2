package com.bibliotecaupt.bibliotecaupt.empleado;

import com.bibliotecaupt.bibliotecaupt.cargo.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(EmpleadoController.BASE_URL)
public class EmpleadoController {

    @Autowired
    private EmpleadoService dao;
    @Autowired
    private CargoService daoCargo;
    public static final String BASE_URL = "/empleado";

    @GetMapping("/listar")
    public String listar(Model model){
        List<EmpleadoModel> lista =   dao.findAll();
        model.addAttribute("listadoEmpleado",lista);
        return "empleado/listar";
    }


    @GetMapping("/agregar")
    public String agregar(Model model){
        model.addAttribute("listadoCargo",daoCargo.findAll());
        return "empleado/agregar";
    }

    @PostMapping("/agregar")
    public String agregar(EmpleadoModel empleado){
        dao.save(empleado);
        return "redirect:/empleado/listar/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        EmpleadoModel empleado =  dao.findById(id).get();
        model.addAttribute("empleado",empleado);
        model.addAttribute("listadoCargo",daoCargo.findAll());
        return "empleado/editar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        dao.deleteById(id);
        return "redirect:/empleado/listar/";
    }
}

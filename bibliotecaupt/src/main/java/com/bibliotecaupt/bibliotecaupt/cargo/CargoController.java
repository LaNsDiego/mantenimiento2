package com.bibliotecaupt.bibliotecaupt.cargo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Controller
@RequestMapping(CargoController.BASE_URL)
public class CargoController {

    public static final String BASE_URL = "/cargo";
    @Autowired
    private CargoService dao;


    @GetMapping("/listar")
    public String listar(Model model){
        List<CargoModel> lista =  (List<CargoModel>) dao.findAll();
        System.out.println("Cantidad" + lista.size());
        model.addAttribute("listadoCargo",lista);
        return "cargo/listar";
    }


    @GetMapping("/agregar")
    public String agregar(){
        return "cargo/agregar";
    }

    @PostMapping("/agregar")
    public String agregar(CargoModel cargo){
        dao.save(cargo);
        return "redirect:/cargo/listar/";
    }


    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        CargoModel cargo =  dao.findById(id).get();
        model.addAttribute("cargo",cargo);
        return "cargo/editar";
    }

    @PostMapping("/editar")
    public String editar(CargoModel cargo){
        dao.save(cargo);
        return "redirect:/cargo/listar/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        dao.deleteById(id);
        return "redirect:/cargo/listar/";
    }
}

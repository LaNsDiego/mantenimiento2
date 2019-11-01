package com.bibliotecaupt.bibliotecaupt.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(ProductoController.BASE_URL)
public class ProductoController {
    @Autowired
    private ProductoService dao;

    public static final String BASE_URL = "/producto";

    @GetMapping("/listar")
    public String listar(Model model){
        List<ProductoModel> lista =   dao.findAll();
        model.addAttribute("listadoProducto",lista);
        return "producto/listar";
    }


    @GetMapping("/agregar")
    public String agregar(){
        return "producto/agregar";
    }

    @PostMapping("/agregar")
    public String agregar(ProductoModel producto){
        dao.save(producto);
        return "redirect:/producto/listar/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        ProductoModel producto =  dao.findById(id).get();
        model.addAttribute("producto",producto);
        return "producto/editar";
    }

    @PostMapping("/editar")
    public String editar( ProductoModel producto){
        dao.save(producto);
        return "redirect:/producto/listar/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        dao.deleteById(id);
        return "redirect:/producto/listar/";
    }
}

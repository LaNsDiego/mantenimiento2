//package com.bibliotecaupt.bibliotecaupt.usuario;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.view.RedirectView;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping(UsuarioController.BASE_URL)
//public class UsuarioController {
//
//    public static final String BASE_URL = "/usuario";
//    @Autowired
//    public UsuarioService dao;
//
//    @GetMapping("/listar")
//    public List<UsuarioModel> listar(){
//        List<UsuarioModel> lista =  (List<UsuarioModel>) dao.findAll();
//        return lista;
//    }
//
//    @PostMapping("/agregar")
//    public UsuarioModel agregar( UsuarioModel usuarioModel){
//
////        if( != null){
////            return new Model("redirect:/redirectedUrl", model);
////        }
//        return dao.save(usuarioModel);
////        return usuarioModel;
//    }
//
//
//
//
//
//
//}

package com.bibliotecaupt.bibliotecaupt.login;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//@RestController
@Controller
@RequestMapping(LoginController.BASE_URL)
public class LoginController {
    public final static String BASE_URL = "/";

//    @GetMapping("/")
    @RequestMapping("/login")
    public String frmLogin(){
        return "frmlogin";
    }
}

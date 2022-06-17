package com.boldadeideas.springboot.di.app.controllers;

import com.boldadeideas.springboot.di.app.models.service.IServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    //@Qualifier("miServicioPrincipal") //le indicamos que queremos inyectar o tambien se puede utilizar el @Primary en los servicios
    private IServicio servicio;

/*
    Una opcio  para Implementar
    @Autowired //Es para indicar que se va a inyectar en el contenedor de spring
    public IndexController(IServicio servicio) {
        this.servicio = servicio;
    }
*/
    @GetMapping({"/index","/",""})
    public String index(Model model){
        model.addAttribute("objeto",servicio.operacion());
        return "index";
    }

}
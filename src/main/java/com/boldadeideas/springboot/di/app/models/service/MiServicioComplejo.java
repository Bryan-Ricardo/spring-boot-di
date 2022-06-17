package com.boldadeideas.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Service("miServicioPrincipal") //Es para que se pueda inyectar e indica que es un servicio se puede utilizar @Component
public class MiServicioComplejo implements IServicio{
    @Override //Indica que es una implementacion de un padre
    public String operacion(){
        return "ejecutando algun proceso importnate complejo...";
    }

}

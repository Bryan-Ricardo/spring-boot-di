package com.boldadeideas.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service("miServicioSimple") //Es para que se pueda inyectar e indica que es un servicio se puede utilizar @Componen// t
//@Primary //Es para indicarle que sea la clase por defecto que se va a implementar
public class MiServicio implements IServicio{
    @Override //Indica que es una implementacion de un padre
    public String operacion(){
        return "ejecutando algun proceso importnate Simple...";
    }

}

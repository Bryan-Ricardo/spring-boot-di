package com.boldadeideas.springboot.di.app.models.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.Serializable;
import java.util.List;

@Component
@RequestScope //esto va a durar lo que dura la peticion HTTP de un usuario, sera distinta para cada quien
//@SessionScope //Es para mantener persistencia en los datos y cuando se trabaja con usuarios
public class Factura implements Serializable { //SI se utiliza el SessionScope es necesario implementar Serializable
    @Value("${factura.descripcion}")
    private  String descripcion;
    @Autowired
    private Cliente cliente;
    @Autowired
    private List<ItemFactura> items;

    @PostConstruct//Se ejecuta antes que todo lo demas, se utiliza para inicializar
    public void inicializar(){
        cliente.setNombre(cliente.getNombre().concat(" ").concat("Ricardo"));
        descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
    }
    @PreDestroy//Es para cuando se acabe de ejecutar toda la aplicacion
    public void destruir(){
        System.out.println("Factura destruida ". concat(descripcion));
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }
}

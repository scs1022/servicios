package com.vinni;

import org.springframework.stereotype.Component;

import com.vinni.servicios.SOAPImplementacion;

import jakarta.xml.ws.Endpoint;

@Component
public class EndpointPublisher {

    @PostConstruct
    public void publish() {
        System.out.println("Iniciando el servicio");
        //String address = "http://localhost:8081/usuarios";
        String address = "http://0.0.0.0:8081/";
        //String address = "https://serviciossoap.azurewebsites.net/usuarios";
        Endpoint.publish(address, new SOAPImplementacion());
    }
}

package com.vinni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vinni.servicios.SOAPImplementacion;

import jakarta.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    @Autowired
    private SOAPImplementacion soapImplementacion;

    @Bean
    public Endpoint usuarioEndpoint() {
        Endpoint endpoint = Endpoint.publish("http://0.0.0.0:8081/", soapImplementacion);
        return endpoint;
    }

}

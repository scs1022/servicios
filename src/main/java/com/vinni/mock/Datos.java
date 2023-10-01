package com.vinni.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vinni.dto.Usuario;
import com.vinni.dto.Vehiculo;

public class Datos {
    public List<Usuario> usuariosList;

    public Map<String, Vehiculo> vehiculo;

    public Datos() {
        usuariosList = new ArrayList<>(Arrays.asList(
                new Usuario("Lavis", "Pa"),
                new Usuario("Elsa", "Patero"),
                new Usuario("Elcan", "Dado")));

        vehiculo = new HashMap<>();
        vehiculo.put("ABC-123", new Vehiculo("ABC-123", 2010, 15000000L));
        vehiculo.put("ABC-234", new Vehiculo("ABC-234", 2020, 10000000L));
        vehiculo.put("ABC-456", new Vehiculo("ABC-456", 2015, 12000000L));
        vehiculo.put("ABC-567", new Vehiculo("ABC-567", 2003, 17000000L));
        vehiculo.put("ABC-678", new Vehiculo("ABC-678", 2005, 20000000L));

    }

    public void adicionarUsuario(String nombre, String apellido) {
        this.adicionarUsuario(new Usuario(nombre, apellido));
    }

    public void adicionarUsuario(Usuario usuario) {
        this.usuariosList.add(usuario);
    }

    public Vehiculo consultarVehiculo(String placa){
        return vehiculo.get(placa);
    }

    
}

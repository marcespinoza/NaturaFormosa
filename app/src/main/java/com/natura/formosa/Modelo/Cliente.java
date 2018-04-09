package com.natura.formosa.Modelo;

/**
 * Created by Marceloi7 on 08/04/2018.
 */

public class Cliente {

    String nombre;
    String token;

    public Cliente(String nombre, String token) {
        this.nombre = nombre;
        this.token = token;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}

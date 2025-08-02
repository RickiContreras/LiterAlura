package com.LiterAlura_G8.LiterAlura.api;

import com.google.gson.Gson;
public class ConversorDeDatos {
    private Gson gson = new Gson();

    public <T> T obtenerDatos(String json, Class<T> clase) {
        return gson.fromJson(json, clase);
    }
}

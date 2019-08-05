package com.senasoft.prueba5_8_19.modelo;

import java.util.Date;

public class Peliculas {
    private int pelId;
    private String pelTitulo;
    private String pelLenguaje;
    private String pelDescripcion;
    private Date pelFechaEstreno;

    public Peliculas() {
    }

    public Peliculas(int pelId, String pelTitulo, String pelLenguaje, String pelDescripcion, Date pelFechaEstreno) {
        this.pelId = pelId;
        this.pelTitulo = pelTitulo;
        this.pelLenguaje = pelLenguaje;
        this.pelDescripcion = pelDescripcion;
        this.pelFechaEstreno = pelFechaEstreno;
    }

    public int getPelId() {
        return pelId;
    }

    public void setPelId(int pelId) {
        this.pelId = pelId;
    }

    public String getPelTitulo() {
        return pelTitulo;
    }

    public void setPelTitulo(String pelTitulo) {
        this.pelTitulo = pelTitulo;
    }

    public String getPelLenguaje() {
        return pelLenguaje;
    }

    public void setPelLenguaje(String pelLenguaje) {
        this.pelLenguaje = pelLenguaje;
    }

    public String getPelDescripcion() {
        return pelDescripcion;
    }

    public void setPelDescripcion(String pelDescripcion) {
        this.pelDescripcion = pelDescripcion;
    }

    public Date getPelFechaEstreno() {
        return pelFechaEstreno;
    }

    public void setPelFechaEstreno(Date pelFechaEstreno) {
        this.pelFechaEstreno = pelFechaEstreno;
    }
}

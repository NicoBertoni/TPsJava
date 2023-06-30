/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author juany
 */
public class Equipo {
    private int idEquipo;
    private Proyecto proyecto;
    private String nombre;
    private LocalDate fecha_creacion;
    private boolean estado;

    public Equipo() {
    }

    public Equipo(int idEquipo, Proyecto proyecto, String nombre, LocalDate fecha_creacion, boolean estado) {
        this.idEquipo = idEquipo;
        this.proyecto = proyecto;
        this.nombre = nombre;
        this.fecha_creacion = fecha_creacion;
        this.estado = estado;
    }

    public Equipo(Proyecto proyecto, String nombre, LocalDate fecha_creacion, boolean estado) {
        this.proyecto = proyecto;
        this.nombre = nombre;
        this.fecha_creacion = fecha_creacion;
        this.estado = estado;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
}

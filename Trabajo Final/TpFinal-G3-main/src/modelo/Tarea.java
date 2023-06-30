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
public class Tarea {
    private int idTarea;
    private String nombre;
    private LocalDate fecha_creacion;
    private LocalDate fecha_cierre;
    private boolean estado;
    private EquipoMiembro equipoMiembro;

    public Tarea() {
    }

    public Tarea(int idTarea, String nombre, LocalDate fecha_creacion, LocalDate fecha_cierre, boolean estado, EquipoMiembro equipoMiembro) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.fecha_creacion = fecha_creacion;
        this.fecha_cierre = fecha_cierre;
        this.estado = estado;
        this.equipoMiembro = equipoMiembro;
    }

    public Tarea(String nombre, LocalDate fecha_creacion, LocalDate fecha_cierre, boolean estado, EquipoMiembro equipoMiembro) {
        this.nombre = nombre;
        this.fecha_creacion = fecha_creacion;
        this.fecha_cierre = fecha_cierre;
        this.estado = estado;
        this.equipoMiembro = equipoMiembro;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
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

    public LocalDate getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(LocalDate fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public EquipoMiembro getEquipoMiembro() {
        return equipoMiembro;
    }

    public void setEquipoMiembro(EquipoMiembro equipoMiembro) {
        this.equipoMiembro = equipoMiembro;
    }
    
    
}

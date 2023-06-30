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
public class EstadoTarea {
    private int idEstadoTarea;
    private Tarea tarea;
    private LocalDate fecha;

    public EstadoTarea() {
    }

    public EstadoTarea(int idEstadoTarea, Tarea tarea, LocalDate fecha) {
        this.idEstadoTarea = idEstadoTarea;
        this.tarea = tarea;
        this.fecha = fecha;
    }

    public EstadoTarea(Tarea tarea, LocalDate fecha) {
        this.tarea = tarea;
        this.fecha = fecha;
    }

    public int getIdEstadoTarea() {
        return idEstadoTarea;
    }

    public void setIdEstadoTarea(int idEstadoTarea) {
        this.idEstadoTarea = idEstadoTarea;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
}

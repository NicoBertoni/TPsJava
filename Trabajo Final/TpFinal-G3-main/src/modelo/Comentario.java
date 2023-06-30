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
public class Comentario {
    private int idComentario;
    private String comentario;
    private LocalDate fecha_avance;
    private Tarea tarea;

    public Comentario() {
    }

    public Comentario(int idComentario, String comentario, LocalDate fecha_avance, Tarea tarea) {
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.fecha_avance = fecha_avance;
        this.tarea = tarea;
    }

    public Comentario(String comentario, LocalDate fecha_avance, Tarea tarea) {
        this.comentario = comentario;
        this.fecha_avance = fecha_avance;
        this.tarea = tarea;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFecha_avance() {
        return fecha_avance;
    }

    public void setFecha_avance(LocalDate fecha_avance) {
        this.fecha_avance = fecha_avance;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
    
    
    
}

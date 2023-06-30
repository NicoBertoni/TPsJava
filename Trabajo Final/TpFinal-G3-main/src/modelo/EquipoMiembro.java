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
public class EquipoMiembro {
    private int idEquipoMiembro;
    private LocalDate fecha_incorporacion;
    private Equipo equipo;
    private Miembro miembro;
    private boolean estado;

    public EquipoMiembro() {
    }

    public EquipoMiembro(int idEquipoMiembro, LocalDate fecha_incorporacion, Equipo equipo, Miembro miembro, boolean estado) {
        this.idEquipoMiembro = idEquipoMiembro;
        this.fecha_incorporacion = fecha_incorporacion;
        this.equipo = equipo;
        this.miembro = miembro;
        this.estado = estado;
    }

    public EquipoMiembro(LocalDate fecha_incorporacion, Equipo equipo, Miembro miembro, boolean estado) {
        this.fecha_incorporacion = fecha_incorporacion;
        this.equipo = equipo;
        this.miembro = miembro;
        this.estado = estado;
    }

    public int getIdEquipoMiembro() {
        return idEquipoMiembro;
    }

    public void setIdEquipoMiembro(int idEquipoMiembro) {
        this.idEquipoMiembro = idEquipoMiembro;
    }

    public LocalDate getFecha_incorporacion() {
        return fecha_incorporacion;
    }

    public void setFecha_incorporacion(LocalDate fecha_incorporacion) {
        this.fecha_incorporacion = fecha_incorporacion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}

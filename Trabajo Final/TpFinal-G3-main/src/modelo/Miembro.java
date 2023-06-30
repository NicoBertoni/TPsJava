/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author juany
 */
public class Miembro {
    private int idMiembro;
    private String dni;
    private String nombre;
    private String apellido;
    private boolean estado;

    public Miembro() {
    }

    public Miembro(int idMiembro, String dni, String nombre, String apellido, boolean estado) {
        this.idMiembro = idMiembro;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }

    public Miembro(String dni, String nombre, String apellido, boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }

    public int getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(int idMiembro) {
        this.idMiembro = idMiembro;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}

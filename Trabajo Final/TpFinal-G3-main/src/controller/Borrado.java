/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author juany
 */
public class Borrado {

    public static void cascadeProyecto() {
        String sql = "UPDATE proyecto\n"
                + "JOIN equipo ON equipo.idProyecto = proyecto.idProyecto AND proyecto.estado=0\n"
                + "LEFT JOIN equipomiembros ON equipomiembros.idEquipo = equipo.idEquipo\n"
                + "LEFT JOIN tarea ON tarea.idMiembroEq= equipomiembros.idMiembroEq\n"
                + "SET equipo.estado=0,equipomiembros.estado=0,tarea.estado=0\n";
        try{
            PreparedStatement  ps= Conexion.conectar().prepareStatement(sql);
            ps.execute();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
    }
    public static void cascadeMiembro(){
        String sql= "UPDATE miembro\n"
                + "JOIN equipomiembros ON equipomiembros.idMiembro = miembro.idMiembro AND miembro.estado=0\n"
                + "LEFT JOIN tarea ON tarea.idMiembroEq = equipomiembros.idMiembroEq\n"
                + "SET equipomiembros.estado=0,tarea.estado=0\n";
        try{
            PreparedStatement  ps= Conexion.conectar().prepareStatement(sql);
            ps.execute();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
    }
    public static void cascadeEquipo(){
        String sql= "UPDATE equipo as e\n"
                + "JOIN equipomiembros as em ON e.idEquipo=em.idEquipo AND e.estado=0\n"
                + "LEFT JOIN tarea as t ON t.idMiembroEq= em.idMiembroEq\n"
                + "SET em.estado=0,t.estado=0";
                
        try{
            PreparedStatement  ps= Conexion.conectar().prepareStatement(sql);
            ps.execute();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
    }
    public static void cascadeEquipoMiembro(){
        String sql= "UPDATE equipomiembros\n"
                + "JOIN tarea ON tarea.idMiembroEq=equipomiembros.idMiembroEq\n"
                + "SET tarea.estado=0\n"
                + "WHERE equipomiembros.estado=0";
        try{
            PreparedStatement  ps= Conexion.conectar().prepareStatement(sql);
            ps.execute();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.EstadoTarea;

/**
 *
 * @author juany
 */
public class EstadoTareaData {
    private TareaData td= new TareaData();
    
    public void finalizarTarea(int idTarea){
        String sql= "INSERT INTO estadotarea (idTarea,fecha) VALUES(?,?)";
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1,idTarea);
            ps.setDate(2,Date.valueOf(LocalDate.now()));
            ps.execute();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al agregar estado");
        }
    }
    public void reAbrirTarea(int idTarea){
        String sql= "DELETE FROM estado WHERE idTarea=?";
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, idTarea);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error de estados");
        }
    }
    
    public ArrayList<EstadoTarea> listarPorProyecto(int idProyecto){
        ArrayList<EstadoTarea> aux= new ArrayList();
        String sql= "SELECT * FROM estadotarea\n"
                + " JOIN tarea ON tarea.idTarea = estadotarea.idTarea\n"
                + " JOIN equipomiembros ON tarea.idMiembroEq=equipomiembros.idMiembroEq\n"
                + " JOIN equipo ON euipo.idEquipo = equipomiembros.idEquipo\n"
                + " JOIN proyecto ON proyecto.idProyecto= equipo.idProyecto AND proyecto.idProyecto= ?";
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, idProyecto);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                EstadoTarea et= new EstadoTarea();
                et.setIdEstadoTarea(rs.getInt("idEstadoTarea"));
                et.setTarea(td.buscarTarea(rs.getInt("idTarea")));
                et.setFecha(rs.getDate("fecha").toLocalDate());
                aux.add(et);
            }
            Conexion.cerrarConexion();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al listar tareas completas "+e.getMessage());
        }
        return aux;
    }
    public int cantidadDeTareasTerminadas(int idProyecto){
        String sql= "SELECT COUNT(*) as cantidad FROM estadotarea\n"
                + " JOIN tarea ON tarea.idTarea = estadotarea.idTarea\n"
                + " JOIN equipomiembros ON tarea.idMiembroEq=equipomiembros.idMiembroEq\n"
                + " JOIN equipo ON equipo.idEquipo = equipomiembros.idEquipo\n"
                + " JOIN proyecto ON proyecto.idProyecto= equipo.idProyecto AND proyecto.idProyecto= ?";
        
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, idProyecto);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                return rs.getInt("cantidad");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al contar datos "+e.getMessage());
        }
        return 0;
        
    }
    public boolean estaTerminada(int idTarea){
        String sql = "SELECT COUNT(*) as c FROM estadotarea WHERE idTarea= ?";
        
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, idTarea);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("c")>0;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al contar "+e.getMessage());
        }
        return false;
    }
    
    
    
}

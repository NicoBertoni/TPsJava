/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Comentario;

/**
 *
 * @author juany
 */
public class ComentarioData {

    TareaData td = new TareaData();

    public ArrayList<Comentario> listarComentarios() {
        ArrayList<Comentario> com = new ArrayList();

        String sql = "SELECT * FROM comentarios";
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Comentario c = new Comentario();
                c.setIdComentario(rs.getInt("idComentario"));
                c.setComentario(rs.getString("comentario"));
                c.setFecha_avance(rs.getDate("fecha_avance").toLocalDate());
                c.setTarea(td.buscarTarea(rs.getInt("idTarea")));

                com.add(c);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar comentarios");
        }
        Conexion.cerrarConexion();
        return com;
    }
    
    public void guardarComentario(Comentario c){
        String sql = "INSERT INTO comentarios (comentario,fecha_avance,idTarea) VALUES (?,?,?)";
        try{
            PreparedStatement ps  = Conexion.conectar().prepareStatement(sql);
            ps.setString(1, c.getComentario());
            ps.setDate(2, Date.valueOf(c.getFecha_avance()));
            ps.setInt(3, c.getTarea().getIdTarea());
            ps.execute();
            Conexion.cerrarConexion();
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error al guardar comentario: "+e.getMessage());
        
        }
    }
    
    public void borrarComentario(int id ){
        String sql = "DELETE FROM comentarios WHERE inComentario= ?";
        
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            Conexion.cerrarConexion();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al borrar Comentario: "+e.getMessage());
        }
        
    }
    public ArrayList<Comentario> listarPorTarea(int idTarea){
        ArrayList<Comentario> aux = new ArrayList();
        
        String sql = "SELECT * FROM comentarios WHERE idTarea = ?";
        try{
            PreparedStatement ps =Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, idTarea);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Comentario c= new Comentario();
                c.setIdComentario(rs.getInt("idComentario"));
                c.setComentario(rs.getString("comentario"));
                c.setTarea(td.buscarTarea(rs.getInt("idTarea")));
                c.setFecha_avance(rs.getDate("fecha_avance").toLocalDate());
                aux.add(c);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al listar comentarios por tarea: "+e.getMessage());
        }
        Conexion.cerrarConexion();
        return aux;
    }
    
    
    
    
}

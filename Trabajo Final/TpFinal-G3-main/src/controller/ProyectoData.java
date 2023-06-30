/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import modelo.Proyecto;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 3
 */
public class ProyectoData {

    public ProyectoData() {
    }
    
    public void guardarProyecto(Proyecto p) {
        String sql = "INSERT INTO proyecto(nombre,descripcion,fecha_inicio,estado) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setDate(3, java.sql.Date.valueOf(p.getFecha_inicio()));
            ps.setBoolean(4, p.isEstado());

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                p.setIdProyecto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Proyecto agregado con exito.");
            }
            Conexion.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar proyecto");
        }
    }

    public ArrayList<Proyecto> listarProyectos() {
        ArrayList<Proyecto> arr = new ArrayList();
        Proyecto p;
        String sql = "SELECT * FROM proyecto WHERE estado = 1";
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p = new Proyecto();
                p.setIdProyecto(rs.getInt("idProyecto"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setFecha_inicio(rs.getDate("fecha_inicio").toLocalDate());
                p.setEstado(rs.getBoolean("estado"));
                
                
                arr.add(p);
            }
            Conexion.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar proyectos");
        }

        return arr;
    }

    public Proyecto buscarProyecto(int id) {
        Proyecto p = null;
        String sql = "SELECT * FROM proyecto WHERE idProyecto = ? AND estado=1";
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Proyecto();
                p.setIdProyecto(rs.getInt("idProyecto"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setEstado(rs.getBoolean("estado"));

            }
            Conexion.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar proyecto");
        }

        return p;
    }

    public void modificarProyecto(Proyecto p) {
        String sql = "UPDATE proyecto SET nombre= ? , descripcion= ?, estado= ? WHERE idProyecto= ?";

        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setBoolean(3, p.isEstado());
            ps.setInt(4, p.getIdProyecto());
            ps.execute();
            Conexion.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el proyecto");
        }
    }
    
    public void eliminarProyecto(int id){
        String sql = "UPDATE proyecto SET estado=0 WHERE idProyecto = ?";
        
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            Borrado.cascadeProyecto();
            Conexion.cerrarConexion();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al eliminar "+e.getMessage());
        }
    }
    
     
     
     
    
    public ArrayList<Proyecto> filtrar(String f){
        String sql = "SELECT * FROM proyecto WHERE (nombre LIKE ? OR descripcion LIKE ?) AND estado = 1";
        String cadena="%"+f+"%";
        ArrayList<Proyecto> aux = new ArrayList();
        
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setString(1, cadena);
            ps.setString(2, cadena);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Proyecto p = new Proyecto();
                p.setIdProyecto(rs.getInt("idProyecto"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setFecha_inicio(rs.getDate("fecha_inicio").toLocalDate());
                aux.add(p);
            }
            Conexion.cerrarConexion();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al filtrar proyecto: "+e.getMessage());
        }
        
        return aux;
    }

}

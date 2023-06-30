/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import modelo.Equipo;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import controller.ConsultaPorEstados;
import modelo.EquipoMiembro;




/**
 *
 * @author Usuario
 */
public class EquipoData {
    

    ProyectoData proyectoData = new ProyectoData();
   

    public void guardarEquipo(Equipo equipo) {
        String sql = "INSERT INTO equipo (idProyecto, nombre, fecha_creacion, estado) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //DEVUEL CON SU KEY 
            ps.setInt(1, equipo.getProyecto().getIdProyecto());
            ps.setString(2, equipo.getNombre());
            ps.setDate(3, java.sql.Date.valueOf(equipo.getFecha_creacion()));
            ps.setBoolean(4, equipo.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                equipo.setIdEquipo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Equipo guardado.");
            } else {
                JOptionPane.showMessageDialog(null, "El Equipo no pudo ser guardado.");
            }
            ps.close();// se cierra los PS para por que pueden causar perdida de memoria o simplemente cerrar la conexion.
            Conexion.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Se encontro un problema al cargar el equipo " + e.getMessage());
        }
    }
    
     public void eliminarEquipo(int id){
        String sql = "UPDATE equipo SET estado=0 WHERE idEquipo = ?";
        
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1,id);
            int res = ps.executeUpdate();
            ps.close();
            if(res==1){
                Borrado.cascadeEquipo();
                JOptionPane.showMessageDialog(null, "Se elimino el equipo");
               
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro ningun equipo para dar eliminar");
            }
            Conexion.cerrarConexion();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al eliminar");
        }
    }
    

    public List<Equipo> obtenerEquipos(ConsultaPorEstados estado) {
        String sql; 
        if(null == estado){
            sql = "SELECT * FROM equipo";
        } else switch (estado) {
            case INACTIVOS:
                sql = "SELECT * FROM equipo WHERE estado = 0";
                break;
            case ACTIVOS:
                sql = "SELECT * FROM equipo WHERE estado = 1";
                break;
            default:
                sql = "SELECT * FROM equipo";
                break;
        }
        Equipo equipo;
        List<Equipo> equipos = new ArrayList();
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();//devuelve un conjunto de resultados
            while (rs.next()) {
                equipo = new Equipo();
                equipo.setIdEquipo(rs.getInt("idEquipo"));
                equipo.setProyecto(proyectoData.buscarProyecto(rs.getInt("idProyecto")));
                equipo.setNombre(rs.getString("nombre"));
                equipo.setFecha_creacion(rs.getDate("fecha_creacion").toLocalDate());
                equipo.setEstado(rs.getBoolean("estado"));

                equipos.add(equipo);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla equipo " + e.getMessage());
        }
        Conexion.cerrarConexion();
        return equipos;
    }
    
    
    

    public Equipo obtenerEquipo(int id) {
        String sql; 
        
        sql = "SELECT * FROM equipo WHERE idEquipo = ? AND estado=1";
        
        Equipo equipo = new Equipo();
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs;
            rs = ps.executeQuery();//devuelve un conjunto de resultados//al ser una key devuelve 1 solo
            if (rs.next()) {
                equipo.setIdEquipo(id);
                equipo.setNombre(rs.getString("nombre"));
                equipo.setProyecto(proyectoData.buscarProyecto(rs.getInt("idProyecto")));
                equipo.setFecha_creacion(rs.getDate("fecha_creacion").toLocalDate());
                equipo.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "El equipo no existe");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla equipo " + e.getMessage());
        }
        Conexion.cerrarConexion();
        return equipo;
    }
    
    public void modificarEquipo(Equipo e){
        String sql= "UPDATE equipo SET nombre= ? WHERE idEquipo= ?";
        
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setInt(2,e.getIdEquipo());
            
            ps.execute();
            JOptionPane.showMessageDialog(null,"Equipo modificado");
            Conexion.cerrarConexion();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al modificar equipo "+ex.getMessage());
        }
    }

}

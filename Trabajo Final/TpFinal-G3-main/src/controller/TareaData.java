/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import modelo.Tarea;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author juany
 */
public class TareaData {

    EquipoMiembroData emd = new EquipoMiembroData();

    public void guardarTarea(Tarea t) {
        String sql = "INSERT INTO tarea(nombre,fecha_creacion,fecha_cierre,estado,idMiembroEq) VALUES(?,?,?,?,?)";

        try {
            LocalDate FechaCreacion = LocalDate.now();
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setString(1, t.getNombre());
            ps.setDate(2, Date.valueOf(t.getFecha_creacion()));
            ps.setDate(3, Date.valueOf(t.getFecha_cierre()));
            ps.setBoolean(4, t.isEstado());
            ps.setInt(5, t.getEquipoMiembro().getIdEquipoMiembro());
//            int verificar = FechaCreacion.compareTo(t.getFecha_cierre());
//            if (verificar > 0) {
//                JOptionPane.showMessageDialog(null, "Debe ingresar una fecha posterior al dia actual");
//                return;
//            }
            ps.execute();
            Conexion.cerrarConexion();
            JOptionPane.showMessageDialog(null, "Tarea Guardada");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar Tarea: " + e.getMessage());
        }
    }

    public ArrayList<Tarea> listarTareas() {
        ArrayList<Tarea> arr = new ArrayList();
        Tarea t;
        String sql = "SELECT * FROM tarea WHERE estado = 1";

        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                t = new Tarea();
                t.setIdTarea(rs.getInt("idTarea"));
                t.setNombre(rs.getString("nombre"));
                t.setFecha_creacion(rs.getDate("fecha_creacion").toLocalDate());
                t.setFecha_cierre(rs.getDate("fecha_cierre").toLocalDate());
                t.setEstado(rs.getBoolean("estado"));
                t.setEquipoMiembro(emd.buscarEquipoMiembro(rs.getInt("idMiembroEq")));
                arr.add(t);
            }
            Conexion.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar tareas: " + e.getMessage());
        }
        return arr;

    }

    public Tarea buscarTarea(int id) {
        Tarea t = null;
        String sql = "SELECT * FROM tarea WHERE idTarea=? AND estado=1";
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                t = new Tarea();
                t.setIdTarea(id);
                t.setNombre(rs.getString("nombre"));
                t.setFecha_creacion(rs.getDate("fecha_creacion").toLocalDate());
                t.setFecha_cierre(rs.getDate("fecha_cierre").toLocalDate());
                t.setEquipoMiembro(emd.buscarEquipoMiembro(rs.getInt("idMiembroEq")));
            }
            Conexion.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar tarea: " + e.getMessage());
        }

        return t;
    }

    public void modificarTarea(Tarea t) {
        String sql = "UPDATE tarea SET nombre= ?,fecha_cierre=? WHERE idTarea = ?";
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setString(1, t.getNombre());
            ps.setDate(2, Date.valueOf(t.getFecha_cierre()));
            ps.setInt(3, t.getIdTarea());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Tarea modificada");
            Conexion.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar tarea: " + e.getMessage());
        }
    }

    public void eliminarTarea(int idTarea) {
        String sql = "UPDATE tarea SET estado= 0 WHERE idTarea= ?";

        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, idTarea);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Tarea eliminada");
            Conexion.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar tarea: " + e.getMessage());
        }
    }

    public ArrayList<Tarea> listarTareaPorMiembro(int idMiembro, int idEquipo) {
        ArrayList<Tarea> aux = new ArrayList();

        //String sql = "SELECT * FROM tarea WHERE tarea.idMiembroEq IN (SELECT equipomiembros.idMiembroEq FROM equipomiembros WHERE idMiembro = ?)";
        String sql = "SELECT * FROM tarea  WHERE tarea.idMiembroEq IN (SELECT equipomiembros.idMiembroEq FROM equipomiembros WHERE idMiembro=? AND idEquipo=?) AND estado=1";

        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, idMiembro);
            ps.setInt(2, idEquipo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tarea t = new Tarea();
                t.setIdTarea(rs.getInt("idTarea"));
                t.setNombre(rs.getString("nombre"));
                t.setFecha_creacion(rs.getDate("fecha_creacion").toLocalDate());
                t.setFecha_cierre(rs.getDate("fecha_cierre").toLocalDate());
                t.setEstado(rs.getBoolean("estado"));
                t.setEquipoMiembro(emd.buscarEquipoMiembro(idMiembro));

                aux.add(t);
            }
            Conexion.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar las tareas por Miembro " + e.getMessage());
        }
        return aux;

    }

    public ArrayList<Tarea> listarTareaPorEquipo(int idEquipo) {
        ArrayList<Tarea> aux = new ArrayList();
        String sql = "SELECT * FROM tarea WHERE idMiembroEq IN (SELECT equipomiembros.idMiembroEq FROM equipomiembros WHERE idEquipo= ?) AND estado=1";

        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, idEquipo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tarea t = new Tarea();
                t.setIdTarea(rs.getInt("idTarea"));
                t.setNombre(rs.getString("nombre"));
                t.setFecha_creacion(rs.getDate("fecha_creacion").toLocalDate());
                t.setFecha_cierre(rs.getDate("fecha_cierre").toLocalDate());
                t.setEstado(rs.getBoolean("estado"));
                t.setEquipoMiembro(emd.buscarEquipoMiembro(idEquipo));

                aux.add(t);

            }
            Conexion.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar las tareas por equipo " + e.getMessage());
        }
        return aux;
    }

    public ArrayList<Tarea> listarTareaPorProyecto(int idProyecto) {
        ArrayList<Tarea> aux = new ArrayList();
        String sql = "SELECT * FROM tarea JOIN equipomiembros ON tarea.idMiembroEq=equipomiembros.idMiembroEq JOIN equipo ON equipomiembros.idEquipo=equipo.idEquipo JOIN proyecto ON equipo.idProyecto=proyecto.idProyecto WHERE proyecto.idProyecto=? AND tarea.estado=1";

        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, idProyecto);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tarea t = new Tarea();
                t.setIdTarea(rs.getInt("idTarea"));
                t.setNombre(rs.getString("nombre"));
                t.setFecha_creacion(rs.getDate("fecha_creacion").toLocalDate());
                t.setFecha_cierre(rs.getDate("fecha_cierre").toLocalDate());
                t.setEstado(rs.getBoolean("estado"));
                t.setEquipoMiembro(emd.buscarEquipoMiembro(rs.getInt("idMiembroEq")));

                aux.add(t);
            }
            Conexion.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar las tareas por equipo " + e.getMessage());
        }
        return aux;
    }

    public ArrayList<Tarea> filtroTarea(String t) {
        String sql = "SELECT * FROM tarea WHERE nombre LIKE '" + t + "%' AND estado=1";
        ArrayList<Tarea> tareas = new ArrayList();
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tarea tt = new Tarea();
                tt.setIdTarea(rs.getInt("idTarea"));
                tt.setNombre(rs.getString("nombre"));
                tt.setFecha_creacion(rs.getDate("fecha_creacion").toLocalDate());
                tt.setFecha_cierre(rs.getDate("fecha_cierre").toLocalDate());
                tt.setEstado(rs.getBoolean("estado"));
                tareas.add(tt);
            }
            Conexion.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al filtrar tareas" + e.getMessage());
        }

        return tareas;
    }

    public int cantidadTareas(int idProyecto) {
        String sql = "SELECT COUNT(*) as cantidad FROM tarea\n"
                + "JOIN equipomiembros ON tarea.idMiembroEq = equipomiembros.idMiembroEq AND tarea.estado=1\n"
                + "JOIN equipo ON equipo.idEquipo = equipomiembros.idEquipo\n"
                + "JOIN proyecto ON proyecto.idProyecto = equipo.idProyecto AND proyecto.idProyecto = ?";
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, idProyecto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("cantidad");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al contar tareas " + e.getMessage());
        }

        return 0;
    }

}

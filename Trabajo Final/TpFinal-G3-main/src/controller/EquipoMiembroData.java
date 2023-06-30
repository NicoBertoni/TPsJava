/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Equipo;
import modelo.EquipoMiembro;

/**
 *
 * @author juany
 */
public class EquipoMiembroData {

    private MiembroData md = new MiembroData();
    private EquipoData ed = new EquipoData();
    //private EquipoData ed= new EquipoData();
    //EquipoData ed= new EquipoData();

    public EquipoMiembro buscarEquipoMiembro(int id) {
        String sql = "SELECT * FROM equipomiembros WHERE idMiembroEq=?";
        EquipoMiembro em = null;
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();//devolviendo todos los equipos.
            if (rs.next()) {
                em = new EquipoMiembro();
                em.setIdEquipoMiembro(rs.getInt("idMiembroEq"));
                em.setFecha_incorporacion(rs.getDate("fecha_incorporacion").toLocalDate());
                em.setMiembro(md.buscarMiembro(rs.getInt("idMiembro")));
                em.setEquipo(ed.obtenerEquipo(rs.getInt("idEquipo")));
            }
            Conexion.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR EQUIPO MIEMBRO" + e.getMessage());
        }
        return em;
    }

    public ArrayList<EquipoMiembro> listarEquipoMiembro() {
        ArrayList<EquipoMiembro> arrEM = new ArrayList();
        String sql = "SELECT * FROM equipomiembros WHERE estado = 1";

        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EquipoMiembro em = new EquipoMiembro();
                em.setIdEquipoMiembro(rs.getInt("idMiembroEq"));
                em.setFecha_incorporacion(rs.getDate("fecha_incorporacion").toLocalDate());
                em.setEquipo(ed.obtenerEquipo(rs.getInt("idEquipo")));
                em.setMiembro(md.buscarMiembro(rs.getInt("idMiembro")));
                em.setEstado(rs.getBoolean("estado"));
                arrEM.add(em);
            }
            Conexion.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar Equipo/miembro");
        }
        
        return arrEM;
    }

    public void guardarEquipoMiembro(EquipoMiembro em) {
        String sql = "INSERT INTO equipomiembros(fecha_incorporacion, idEquipo,idMiembro,estado) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //DEVUEL CON SU KEY 
            ps.setDate(1, Date.valueOf(em.getFecha_incorporacion()));
            ps.setInt(2, em.getEquipo().getIdEquipo());
            ps.setInt(3, em.getMiembro().getIdMiembro());
            ps.setBoolean(4, em.isEstado());

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                em.setIdEquipoMiembro(rs.getInt(1));

            }
            Conexion.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla Equipo-miembro " + em.getEquipo().getNombre() + "-" + em.getMiembro().getNombre() + " " + ex.getMessage());
        }
    }

    public void borrarEquipoMiembro(int id) {
        String sql = "UPDATE * FROM equipomiembros SET estado=0 WHERE idMiembroEq=? AND estado=1";
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            int res = ps.executeUpdate();
            if (res == 1) {
                Borrado.cascadeEquipoMiembro();
                JOptionPane.showMessageDialog(null, "Equipo miembro eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "NO se pudo eliminar el miembro equipo");
            }
            Conexion.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al borrar EQUIPO MIEMBRO" + e.getMessage());
        }
    }

}

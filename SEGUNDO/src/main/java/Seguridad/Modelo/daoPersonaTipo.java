/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seguridad.Modelo;

import Seguridad.Controlador.clsPersonaTipo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author cdavi
 */
public class daoPersonaTipo {
    private static final String SQL_SELECT = "SELECT perid, pernombre, perestatus FROM tbl_personatipo";
    private static final String SQL_INSERT = "INSERT INTO tbl_personatipo(perid, pernombre, perestatus) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_personatipo SET pernombre=?, perestatus=? WHERE perid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_personatipo WHERE perid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT perid, pernombre, perestatus FROM tbl_personatipo WHERE pernombre = ?";
    private static final String SQL_SELECT_ID = "SELECT perid, pernombre, perestatus FROM tbl_personatipo WHERE perid = ?";    

    public List<clsPersonaTipo> consultaPersona() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsPersonaTipo> personas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("perid");
                String nombre = rs.getString("pernombre");
                String estatus = rs.getString("perestatus");
                clsPersonaTipo persona = new clsPersonaTipo();
                persona.setIdPersona(id);
                persona.setNombrePersona(nombre);
                persona.setEstatusPersona(estatus);
                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return personas;
    }

    public int ingresaPersona(clsPersonaTipo persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombrePersona());
            stmt.setString(2, persona.getEstatusPersona());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaPersona(clsPersonaTipo persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombrePersona());
            stmt.setString(2, persona.getEstatusPersona());
            stmt.setInt(3, persona.getIdPersona());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarPersona(clsPersonaTipo persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsPersonaTipo consultaPersonaPorNombre(clsPersonaTipo persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + persona);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, modulo.getIdModulo());            
            stmt.setString(1, persona.getNombrePersona());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("perid");
                String nombre = rs.getString("pernombre");
                String estatus = rs.getString("perestatus");

                //modulo = new clsModulo();
                persona.setIdPersona(id);
                persona.setNombrePersona(nombre);
                persona.setEstatusPersona(estatus);
                System.out.println(" registro consultado: " + persona);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return persona;
    }
    public clsPersonaTipo consultaPersonaPorId(clsPersonaTipo persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + persona);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, persona.getIdPersona());            
            //stmt.setString(1, modulo.getNombreModulo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("perid");
                String nombre = rs.getString("pernombre");
                String estatus = rs.getString("perestatus");

                //modulo = new clsModulo();
                persona.setIdPersona(id);
                persona.setNombrePersona(nombre);
                persona.setEstatusPersona(estatus);
                System.out.println(" registro consultado: " + persona);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return persona;
    }    
}

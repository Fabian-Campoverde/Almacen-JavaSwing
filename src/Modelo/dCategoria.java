/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FABIAN CAMPOVERDE
 */
public class dCategoria {

    ConexionBD cnx = new ConexionBD();
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    Statement s;
    int r = 0;

    public String create(bCategoria catego) {
        String out;
        String sql
                = "INSERT INTO `categoria`( `nombre`,`descripcion`,`estado`) "
                + "VALUES ('" + catego.getNombre() + "',"
                + "'" + catego.getDescripcion() + "',"
                + "'" + 1 + "')";
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            out = "Registrado correctamente";
        } catch (Exception e) {
            out = "Error en DAO (registrar): " + e;
        }
        return out;

    }

    public int ValidarNombre(bCategoria catego) {
        String sql = "Select COUNT(*) from categoria where nombre = ?";
        int cantidad = 0;
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, catego.getNombre());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                cantidad = rs.getInt("COUNT(*)");
            }
            if (r == 1) {
                return cantidad;
            } else {
                return cantidad;
            }

        } catch (Exception e) {
            return cantidad;
        }
    }

    public List listar() {
        List<bCategoria> catego = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
//                r=r+1;
                bCategoria a = new bCategoria();
                a.setId(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setDescripcion(rs.getString(3));
                a.setEstado(rs.getInt(4));
                catego.add(a);
            }
            return catego;

        } catch (Exception e) {
            return null;
        }

    }

    public String update(bCategoria catego) {
        String out;
        String sql = "update categoria set nombre=?, descripcion=? where id=?";

        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, catego.getNombre());
            ps.setString(2, catego.getDescripcion());
            ps.setInt(3, catego.getId());
            
            ps.executeUpdate();
            out = "Actualizado correctamente";
        } catch (Exception e) {
            out = "Error en DAO (registrar): " + e;
        }
        return out;

    }

    public String delete(List<String> catego) {
        String out;
        String sql = "delete from categoria where id=?";

        try {
            for (int i = 0; i < catego.size(); i++) {
                con = cnx.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(catego.get(i)));
                ps.executeUpdate();
            }

            out = "Eliminado correctamente";
        } catch (Exception e) {
            out = "Error en DAO (registrar): " + e;
        }
        return out;

    }
}

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
public class dProducto {

    ConexionBD cnx = new ConexionBD();
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    Statement s;
    int r = 0;

    public String add(bProducto producto) {
        String out;
        String sql
                = "INSERT INTO `productos`( `codigo`, `nombre`,`medida`, `stock`, `categoria`, `fecha_creacion`,`stock_minimo` , `estado`) "
                + "VALUES ('" + producto.getCodigo() + "',"
                + "'" + producto.getNombre() + "',"
                + "'" + producto.getMedida() + "',"
                + "'" + producto.getStock() + "',"
                + "'" + producto.getCategoria() + "',"
                + "'" + producto.getFecha() + "',"
                + "'" + producto.getStock_minimo()+ "',"
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


    public int ValidarCodigo(bProducto producto) {
        String sql = "Select COUNT(*) from productos where codigo = ?";
        int cantidad = 0;
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getCodigo());
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
        List<bProducto> product = new ArrayList<>();
        String sql = "SELECT p.codigo, p.nombre, p.medida, p.stock,p.fecha_creacion,p.stock_minimo, c.nombre "
                + "FROM productos p JOIN categoria c ON p.categoria = c.id;";
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
//                r=r+1;
                bProducto a = new bProducto();
                a.setCodigo(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setMedida(rs.getString(3));
                a.setStock(rs.getInt(4));
                a.setFecha(rs.getTimestamp(5));
                a.setStock_minimo(rs.getInt(6));
                a.setNom_categoria(rs.getString(7));
                product.add(a);
            }
            return product;

        } catch (Exception e) {
            return null;
        }

    }

    public String update(bProducto product) {
        String out;
        String sql = "update productos set nombre=?, medida=?, stock=?, categoria=?, stock_minimo=? where codigo=?";

        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, product.getNombre());
            ps.setString(2, product.getMedida());
            ps.setInt(3, product.getStock());
            ps.setInt(4, product.getCategoria());
            ps.setInt(5, product.getStock_minimo());
            ps.setInt(6,product.getCodigo());
            ps.executeUpdate();
            out = "Actualizado correctamente";
        } catch (Exception e) {
            out = "Error en DAO (registrar): " + e;
        }
        return out;

    }

    public String delete(List<String> productos) {
        String out;
        String sql = "delete from productos where codigo=?";

        try {
            for (int i = 0; i < productos.size(); i++) {
                con = cnx.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(productos.get(i)));
                ps.executeUpdate();
            }

            out = "Eliminado correctamente";
        } catch (Exception e) {
            out = "Error en DAO (registrar): " + e;
        }
        return out;

    }
}

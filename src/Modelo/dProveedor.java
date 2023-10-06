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
public class dProveedor {
    ConexionBD cnx = new ConexionBD ();
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
     Statement s;
     int r=0;
    
    public String add(bProveedor prov) {
        String out;
        String sql = 
                "INSERT INTO `proveedor`( `ruc`, `razon social`,`nombre`, `telefono`, `direccion`,`estado`) "
                + "VALUES ('"+prov.getRuc()+"',"
                + "'"+prov.getRazon()+"',"
                + "'"+prov.getNombre()+"',"
                + "'"+prov.getTelefono()+"',"  
                + "'"+prov.getDireccion()+"',"                
                + "'"+1+"')";
        try{
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            out = "Registrado correctamente";
        } catch(Exception e){
            out = "Error en DAO (registrar): " + e;
        }
        return out;
    
    }
    

    public int ValidarRUC(bProveedor prov) {
       String sql= "Select COUNT(*) from proveedor where ruc = ?";
       int cantidad=0;
        try {
            con= cnx.getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1,prov.getRuc());           
            rs= ps.executeQuery();
            while (rs.next()) {    
                r=r+1;
                cantidad=rs.getInt("COUNT(*)");
            }
            if(r==1){
                return cantidad;
            }
            else{
                return cantidad;
            }
            
        } catch (Exception e) {
            return cantidad;
        }
    }
    
    public List listar(){
        List <bProveedor> prov= new ArrayList<>();
        String sql= "SELECT * FROM proveedor";
         try {
            con= cnx.getConnection();
            ps= con.prepareStatement(sql);           
            rs= ps.executeQuery();
            while (rs.next()) {    
//                r=r+1;
                bProveedor a= new bProveedor();             
                a.setRuc(rs.getString(1));
                a.setRazon(rs.getString(2));
                a.setNombre(rs.getString(3));
                a.setTelefono(rs.getInt(4));
                a.setDireccion(rs.getString(5));
                prov.add(a);
            }
           return prov;
            
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public String update(bProveedor prov) {
        String out;
        String sql = "update proveedor set `razon social`=?, nombre=?, telefono=?, direccion=? where ruc=?";
              
        try{
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getRazon());
            ps.setString(2,prov.getNombre() );
            ps.setInt(3, prov.getTelefono());
            ps.setString(4, prov.getDireccion());
            ps.setString(5,prov.getRuc());
            ps.executeUpdate();
            out = "Actualizado correctamente";
        } catch(Exception e){
            out = "Error en DAO (registrar): " + e;
        }
        return out;
    
    }
    
    public String delete(List<String> proveedores) {
        String out;
        String sql = "delete from proveedor where ruc=?";
              
        try{
            for (int i = 0; i < proveedores.size(); i++) {
                con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, proveedores.get(i));           
            ps.executeUpdate();               
            }
            
            out = "Eliminado correctamente";
        } catch(Exception e){
            out = "Error en DAO (registrar): " + e;
        }
        return out;
    
    }
}


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
public class dUsuario {
    ConexionBD cnx = new ConexionBD ();
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
     Statement s;
     int r=0;
    
    public String add(bUsuario usuarios) {
        String out;
        String sql = 
                "INSERT INTO `usuarios`( `dni`, `nombres`,`apellidos`, `telefono`, `correo`, `contraseña`, `estado`, `tipo`) "
                + "VALUES ('"+usuarios.getDni()+"',"
                + "'"+usuarios.getNombres()+"',"
                + "'"+usuarios.getApellidos()+"',"
                + "'"+usuarios.getTelefono()+"',"  
                + "'"+usuarios.getCorreo()+"',"  
                + "'"+usuarios.getContraseña()+"',"
                + "'"+1+"'," 
                + "'"+usuarios.getTipo()+"')";
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
    
    public bUsuario Validar(bUsuario user) {
       String sql= "Select * from usuarios where dni = ? and contraseña = ?";
        try {
            con= cnx.getConnection();
            ps= con.prepareStatement(sql);
            ps.setInt(1,user.getDni());
            ps.setString(2,user.getContraseña());
            rs= ps.executeQuery();
            while (rs.next()) {    
                r=r+1;
                //user.setDni(rs.getInt("dni"));
                //user.setContraseña(rs.getString("contraseña"));
                user.setNombres(rs.getString("nombres"));
            }
            if(r==1){
                return user;
            }
            else{
                return null;
            }
            
        } catch (Exception e) {
            return null;
        }
    }
    
    public int ValidarDNI(bUsuario user) {
       String sql= "Select COUNT(*) from usuarios where dni = ?";
       int cantidad=0;
        try {
            con= cnx.getConnection();
            ps= con.prepareStatement(sql);
            ps.setInt(1,user.getDni());           
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
        List <bUsuario> user= new ArrayList<>();
        String sql= "SELECT u.dni, u.nombres, u.apellidos, u.telefono,u.correo,u.contraseña, t.tipo "
                + "FROM usuarios u JOIN tipo_user t ON u.tipo = t.id;";
         try {
            con= cnx.getConnection();
            ps= con.prepareStatement(sql);           
            rs= ps.executeQuery();
            while (rs.next()) {    
//                r=r+1;
                bUsuario a= new bUsuario();             
                a.setDni(rs.getInt(1));
                a.setNombres(rs.getString(2));
                a.setApellidos(rs.getString(3));
                a.setTelefono(rs.getInt(4));
                a.setCorreo(rs.getString(5));
                a.setContraseña(rs.getString(6));
                a.setNom_tipo(rs.getString(7));
                user.add(a);
            }
           return user;
            
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public String update(bUsuario usuarios) {
        String out;
        String sql = "update usuarios set nombres=?, apellidos=?, telefono=?, correo=?, contraseña=?, tipo=? where dni=?";
              
        try{
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuarios.getNombres());
            ps.setString(2, usuarios.getApellidos());
            ps.setInt(3, usuarios.getTelefono());
            ps.setString(4, usuarios.getCorreo());
            ps.setString(5,usuarios.getContraseña());
            ps.setInt(6, usuarios.getTipo());
            ps.setInt(7, usuarios.getDni());
            ps.executeUpdate();
            out = "Actualizado correctamente";
        } catch(Exception e){
            out = "Error en DAO (registrar): " + e;
        }
        return out;
    
    }
    
    public String delete(List<String> usuarios) {
        String out;
        String sql = "delete from usuarios where dni=?";
              
        try{
            for (int i = 0; i < usuarios.size(); i++) {
                con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(usuarios.get(i)));           
            ps.executeUpdate();               
            }
            
            out = "Eliminado correctamente";
        } catch(Exception e){
            out = "Error en DAO (registrar): " + e;
        }
        return out;
    
    }
}


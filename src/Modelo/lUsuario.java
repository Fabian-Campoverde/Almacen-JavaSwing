/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

/**
 *
 * @author FABIAN CAMPOVERDE
 */
public class lUsuario {
    public static dUsuario user= new dUsuario();
    public static String agregarDatos(bUsuario obUser){
        return user.add(obUser);
    }
     public static bUsuario Validar(bUsuario obUser){
        return user.Validar(obUser);
    }
     public static List listar(){
         return user.listar();
     }
     public static String actualizarDatos(bUsuario obUser){
         return user.update(obUser);
     }
     public static String eliminarDatos(List<String> obUser){
         return user.delete(obUser);
     }
}

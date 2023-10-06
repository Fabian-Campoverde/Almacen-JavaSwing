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
public class lProveedor {
    public static dProveedor Prov= new dProveedor();
    
    public static String add_Prov(bProveedor obProv){
        return Prov.add(obProv);
    }
    public static List list_Prov(){
        return Prov.listar();
    }
    public static String actualizarDatos(bProveedor prov){
         return Prov.update(prov);
     }
    public static String eliminarDatos(List<String> obProv){
         return Prov.delete(obProv);
     }
}

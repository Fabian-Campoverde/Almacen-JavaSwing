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
public class lProducto {
    public static dProducto prod= new dProducto();
    public static String agregarDatos(bProducto producto){
        return prod.add(producto);
    }

     public static List listar(){
         return prod.listar();
     }
     public static String actualizarDatos(bProducto producto){
         return prod.update(producto);
     }
     public static String eliminarDatos(List<String> productos){
         return prod.delete(productos);
     }
}

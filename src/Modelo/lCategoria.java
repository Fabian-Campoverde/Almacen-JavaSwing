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
public class lCategoria {
    public static dCategoria Catego= new dCategoria();
    
    public static String add_Catego(bCategoria obCatego){
        return Catego.create(obCatego);
    }
    public static List list_Catego(){
        return Catego.listar();
    }
    public static String actualizarDatos(bCategoria catego){
         return Catego.update(catego);
     }
    public static String eliminarDatos(List<String> obCatego){
         return Catego.delete(obCatego);
     }
}

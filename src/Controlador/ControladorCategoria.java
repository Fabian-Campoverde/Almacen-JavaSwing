/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.bCategoria;
import Modelo.dCategoria;
import Modelo.lCategoria;
import Modelo.lUsuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FABIAN CAMPOVERDE
 */
public class ControladorCategoria {
    private static List<String> id;
    private static int id1;
    private static String nombre;
    private static String descripcion;
    
    public static void setDatosCatego( int codigo,String nom, String desc) {
       id1=codigo;
        nombre=nom;
        descripcion=desc;
    }
    
    public static void deleteDatosCatego(List<String> cod){
        id=cod;
    }
    public static String decisor(int opcion) {
        switch (opcion) {
            case 1:
                bCategoria objeto = new bCategoria();
                dCategoria dao= new dCategoria();              
                objeto.setNombre(nombre);
                objeto.setDescripcion(descripcion);
                int res= dao.ValidarNombre(objeto);
                if (res==0) {
                    return lCategoria.add_Catego(objeto);
                }
                else{
                    return "Nombre ya existente";
                }
            case 2:
                bCategoria objeto1 = new bCategoria();
                objeto1.setId(id1);
                objeto1.setNombre(nombre);
                objeto1.setDescripcion(descripcion);
                return lCategoria.actualizarDatos(objeto1);
            case 3:
                List<String> objeto2 = new ArrayList();
                objeto2= id;
                return lCategoria.eliminarDatos(objeto2);
            default:
                return "";
        }
    }
    public static List listar(int opcion) {
        switch (opcion) {
            case 1:
                return lCategoria.list_Catego();
            default:
                return null;
        }
    }
}

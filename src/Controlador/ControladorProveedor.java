/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.bCategoria;
import Modelo.bProveedor;
import Modelo.dCategoria;
import Modelo.dProveedor;
import Modelo.lCategoria;
import Modelo.lProveedor;
import Modelo.lUsuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FABIAN CAMPOVERDE
 */
public class ControladorProveedor {
    private static List<String> ruc;
    private static String ruc1;
    private static String razon;
    private static String nombre;
    private static String direccion;
    private static int telefono;
    
    
    public static void setDatosProv( String RUC, String RAZON, String NOMBRE,String DIRECCION, int TELEFONO) {
       ruc1=RUC;
       razon=RAZON;
       nombre=NOMBRE;
       direccion=DIRECCION;
       telefono=TELEFONO;
    }
    
    public static void deleteDatosCatego(List<String> cod){
        ruc=cod;
    }
    public static String decisor(int opcion) {
        switch (opcion) {
            case 1:
                bProveedor objeto = new bProveedor();
                dProveedor dao= new dProveedor();              
                objeto.setRuc(ruc1);
                objeto.setRazon(razon);
                objeto.setNombre(nombre);
                objeto.setDireccion(direccion);
                objeto.setTelefono(telefono);
                int res= dao.ValidarRUC(objeto);
                if (res==0) {
                    return lProveedor.add_Prov(objeto);
                }
                else{
                    return "Nombre ya existente";
                }
            case 2:
                bProveedor objeto1 = new bProveedor();
                objeto1.setRuc(ruc1);
                objeto1.setRazon(razon);
                objeto1.setNombre(nombre);
                objeto1.setTelefono(telefono);
                objeto1.setDireccion(direccion);
                return lProveedor.actualizarDatos(objeto1);
            case 3:
                List<String> objeto2 = new ArrayList();
                objeto2= ruc;
                return lProveedor.eliminarDatos(objeto2);
            default:
                return "";
        }
    }
    public static List listar(int opcion) {
        switch (opcion) {
            case 1:
                return lProveedor.list_Prov();
            default:
                return null;
        }
    }
}

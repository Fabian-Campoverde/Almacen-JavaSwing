/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.bCategoria;
import Modelo.bProducto;
import Modelo.bProveedor;
import Modelo.dCategoria;
import Modelo.dProducto;
import Modelo.dProveedor;
import Modelo.lCategoria;
import Modelo.lProducto;
import Modelo.lProveedor;
import Modelo.lUsuario;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FABIAN CAMPOVERDE
 */
public class ControladorProducto {

    private static List<String> codigo;
    private static int codigo1;
    private static String nombre;
    private static String medida;
    private static int stock;
    private static String categoria;
    private static Timestamp fecha;
    private static int stock_minimo;
    private static List<bCategoria> catego = ControladorCategoria.listar(1);
    private static int c;
    public static void setDatosProducto(int cod, String nom, String med, int cant, String cat, Timestamp fec, int min) {
        codigo1 = cod;
        nombre = nom;
        medida = med;
        stock = cant;
        categoria = cat;
        fecha = fec;
        stock_minimo = min;
    }

    public static void deleteDatosProducto(List<String> cod) {
        codigo = cod;
    }

    public static String decisor(int opcion) {
        switch (opcion) {
            case 1:
                bProducto objeto = new bProducto();
                dProducto dao = new dProducto();
                
                for (int i = 0; i < catego.size(); i++) {
                    if(categoria.equals(catego.get(i).getNombre())){
                        c=catego.get(i).getId();
                        break; 
                    }
                    
                }
                objeto.setCodigo(codigo1);
                objeto.setNombre(nombre);
                objeto.setMedida(medida);
                objeto.setStock(stock);
                objeto.setCategoria(c);
                objeto.setFecha(fecha);
                objeto.setStock_minimo(stock_minimo);
                int res = dao.ValidarCodigo(objeto);
                if (res == 0) {
                    return lProducto.agregarDatos(objeto);
                } else {
                    return "Codigo ya existente";
                }
            case 2:
                bProducto objeto1 = new bProducto();
                for (int i = 0; i < catego.size(); i++) {
                    if(categoria.equals(catego.get(i).getNombre())){
                        c=catego.get(i).getId();
                        break; 
                    }                
                }
                objeto1.setCodigo(codigo1);
                objeto1.setNombre(nombre);
                objeto1.setMedida(medida);
                objeto1.setCategoria(c);
                objeto1.setStock(stock);
                objeto1.setStock_minimo(stock_minimo);
                return lProducto.actualizarDatos(objeto1);
            case 3:
                List<String> objeto2 = new ArrayList();
                objeto2 = codigo;
                return lProducto.eliminarDatos(objeto2);
            default:
                return "";
        }
    }

    public static List listar(int opcion) {
        switch (opcion) {
            case 1:
                return lProducto.listar();
            default:
                return null;
        }
    }
}

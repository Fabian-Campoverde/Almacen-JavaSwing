/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.bUsuario;
import Modelo.dUsuario;
import Modelo.lUsuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FABIAN CAMPOVERDE
 */
public class ControladorUsuario {

    private static String apellidos;
    private static String nombres;
    private static String contra;
    private static String correo;
    private static int dni;
    private static int telefono;
    private static int tipo;
    private static List<String> document;

    public static void setDatos(String ap, String nom, String cont, String corr, int cod, int tel,
            int tip) {
        apellidos = ap;
        nombres = nom;
        contra = cont;
        correo = corr;
        dni = cod;
        telefono = tel;
        tipo = tip;

    }

    public static void deleteDatos(List<String> id) {
        document = id;
    }

    public static void setValidacion(int dni1, String clave) {
        dni = dni1;
        contra = clave;
    }
//    public static void setUpdateDatos(int dni2,String n, String ape, int tele, int value_tipo){
//        dni=dni2;
//        nombres=n;
//        apellidos=ape;
//        telefono=tele;
//        tipo= value_tipo;
//    }

    public static String decisor(int opcion) {
        switch (opcion) {
            case 1:
                bUsuario objeto = new bUsuario();
                dUsuario dao = new dUsuario();
                objeto.setDni(dni);
                objeto.setApellidos(apellidos);
                objeto.setNombres(nombres);
                objeto.setTelefono(telefono);
                objeto.setCorreo(correo);
                objeto.setContraseña(contra);
                objeto.setTipo(tipo);
                int abc = dao.ValidarDNI(objeto);
                if (abc == 0) {
                    return lUsuario.agregarDatos(objeto);
                } else {
                    return "DNI debe ser unico uwu";
                }

            case 2:
                bUsuario objeto1 = new bUsuario();
                objeto1.setDni(dni);
                objeto1.setContraseña(contra);
                bUsuario a = lUsuario.Validar(objeto1);
                if (a == null) {
                    return "Usuario o contraseña incorrectos";
                } else {
                    String nom = "Bienvenido al sistema " + a.getNombres();
                    return nom;
                }
            case 3:
                bUsuario ob = new bUsuario();
                ob.setDni(dni);
                ob.setNombres(nombres);
                ob.setApellidos(apellidos);
                ob.setTelefono(telefono);
                ob.setTipo(tipo);
                ob.setContraseña(contra);
                ob.setCorreo(correo);
                return lUsuario.actualizarDatos(ob);
            case 4:
                List<String> obj = new ArrayList();
                obj = document;

                return lUsuario.eliminarDatos(obj);
            default:
                return "";
        }
    }

    public static List listar(int opcion) {
        switch (opcion) {
            case 1:
                return lUsuario.listar();
            default:
                return null;
        }
    }
}

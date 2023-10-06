/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.Servlet;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author FABIAN CAMPOVERDE
 */
//@WebServlet (name="ConexionBD",urlPatterns={"/ConexionBD"})
public class ConexionBD {

//Connection con;
//    public ConexionBD () throws ClassNotFoundException {
//          
//        String url = "jdbc:mysql://localhost:3306/almacen";
//        String usuario = "root";
//        String contra = "";
//         try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection(url, usuario
//                    , contra);
//             System.out.println("Se conecto a " );
//
//        } catch (SQLException e) {
//            System.err.println("Error" + e);
//        }
//         
//    }
//    public Connection getConnection() {
//        return con;
//    }
    static Connection con;

    public static void main(String[] args) {
        try {
//            String url = "jdbc:mysql://db4free.net:3306/almacen2911";
//            String usuario = "fabian29";
//            String contra = "BnrQSy.6-hPeQjq";
            String url = "jdbc:mysql://localhost:3307/almacen";     
            String usuario = "root";
            String contra = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, contra);

            if (con != null) {
                System.out.println("Conexión establecida con éxito a la base de datos.");
                // Ahora puedes usar 'con' para interactuar con la base de datos
            } else {
                System.err.println("No se pudo establecer la conexión.");
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador JDBC: " + e);
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e);
//        } finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException e) {
//                System.err.println("Error al cerrar la conexión: " + e);
//            }
        }
    }

    public ConexionBD() {
        try {

            String url = "jdbc:mysql://localhost:3307/almacen";     
            String usuario = "root";
            String contra = "";
//            String url = "jdbc:mysql://db4free.net:3306/almacen2911";
//            String usuario = "fabian29";
//            String contra = "BnrQSy.6-hPeQjq";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, contra);

            if (con != null) {
                System.out.println("Conexión establecida con éxito a la base de datos.");
                // Ahora puedes usar 'con' para interactuar con la base de datos
            } else {
                System.err.println("No se pudo establecer la conexión.");
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador JDBC: " + e);
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e);
//        } finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException e) {
//                System.err.println("Error al cerrar la conexión: " + e);
//            }
        }
    }

    public static Connection getConnection() {
        return con;
    }
}

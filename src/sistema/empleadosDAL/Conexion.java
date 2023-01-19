

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.empleadosDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Gonzalo
 */
public class Conexion {
    
    String strConexionBD="jdbc:sqlite:C:/Users/Gonzalo/Documents/db/sistemaCRUD.s3db";
    Connection conn = null;
    //ESTE METODO REALIZA LA CONEXION CON LA BASE DE DATOS
    public Conexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strConexionBD);
            System.out.println("Conexion establecida");
        } catch (Exception e) {
            System.out.println("Error de conexion con DB"+e);
        }

    }
    //ESTE METODO EJECUTA LA SENTENCIA DE INSERT EN EL BOTON AGREGAR
    public int ejecutarSentenciaSQL(String strSentenciaSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }
    
    public ResultSet consultarRegistros(String strSentenciaSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    
    
}

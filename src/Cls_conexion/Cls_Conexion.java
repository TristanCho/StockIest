/*
Con esta clase nos conectamos a la base de datos

*/
package Cls_conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;




public class Cls_Conexion {
    
  
    private static final String DRIVER = "com.mysql.jdbc.Driver";// Hacemos referencia al DRIVER que hemos importado para hacer la conexión
    //private static final String USER = "root";
    //private static final String PASSWORD = "";
    private static final String USER = "cristhian";
    private static final String PASSWORD = "cristhian";
    private static final String IP = "89.129.146.6";
    private static final String PUERTO = "3306";
    private static final String DDBB = "StockIest";
   //private static final String URL = "jdbc:mysql://52.59.29.126:3306/tienda";
    private static final String URL = "jdbc:mysql://"+IP+":"+PUERTO+"/"+DDBB+"?autoReconnect=true&useSSL=false";
    private Connection CN;

    public Cls_Conexion() {
        CN = null;}
        
   
    //Este método nos retorna la conexión
    public Connection getConnection(){
        try{
            Class.forName(DRIVER);
            CN = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida...");
          }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al conectar con la base de datos", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error de Conectar Con la DDBB...");
            System.exit(0);
        }
        return CN;
    }
    
    //Cierra conexiones abiertas a la base de datos.
    public void close(){
        try{
            System.out.println("Cerrando Conexión");
            CN.close();
            System.out.println("Conexión Cerrada");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al cerrar la conexión con la base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}

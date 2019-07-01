package logica;

import Cls_conexion.Cls_Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Cls_Stock {
   
    private final String SQL_INSERT = "INSERT INTO `terminales` (`fabricante`, `modelo`, `serie`, `mac`, `huella`, `proximidad`,`rele`, `tecnico`,`estado`,`observaciones`) values (?,?,?,?,?,?,?,?,?,?)";
    private final String SQL_SELECT = "SELECT * FROM terminales";
    private DefaultTableModel DT;
    private ResultSet RS;
    private PreparedStatement PS;
    private final Cls_Conexion CN;
    
    public Cls_Stock(){
        PS = null;
        CN = new Cls_Conexion();
        
    }
    
    
    private DefaultTableModel setTitulos(){
        DT = new DefaultTableModel();
        DT.addColumn("Fabricante");
        DT.addColumn("Modelo");
        DT.addColumn("Serie");
        DT.addColumn("Mac");
        DT.addColumn("Huella");
        DT.addColumn("Proximidad");
        DT.addColumn("Rele");
        DT.addColumn("Tecnico");
        DT.addColumn("Estado");
        DT.addColumn("Observaciones");
        
       
        return DT;
    }
    
       //Creamos el Método que nos va a Guardar los datos en la DDBB
    public int insertDatos(String fabricante, String modelo, String serie, String mac, String huella, String proximidad, String rele, String tecnico, String estado, String observaciones){
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT);
            PS.setString(1, fabricante);
            PS.setString(2, modelo);
            PS.setString(3, serie);
            PS.setString(4, mac);
            PS.setString(5, huella);
            PS.setString(6, proximidad);
            PS.setString(7, rele);
            PS.setString(8, tecnico);
            PS.setString(9, estado);
            PS.setString(10, observaciones);
            res = PS.executeUpdate();
            if(huella == null){
                JOptionPane.showMessageDialog(null, "Campo Huella vacio");
                
            }
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            }else{
                System.out.println("Fallo de Inserción, revise actualización del Registro");
            }
            
        } catch (SQLException e) {
            System.err.println("Insert datos Error al Guardar los datos en DDBB: "+ e.getMessage());
            JOptionPane.showMessageDialog(null,"Registro no Almacenado");
        }finally{
            PS = null;
            CN.close();
            System.out.println("Conexión cerrada desde Insertar datos");
        }
         return res;
    }
    //Método que nos va a Actualizar los datos en la DDBB
      public int updateDatos(String fabricante, String modelo, String serie, String mac, String huella, String proximidad, String rele, String tecnico, String estado, String observaciones){
          
             String SQL = "UPDATE terminales SET fabricante='"+fabricante+"',modelo='"+modelo+"',serie='"+serie+"',mac='"+mac+"',huella='"+huella+"',proximidad='"+proximidad+"',rele='"+rele+"',tecnico='"+tecnico+"',estado='"+estado+"',observaciones='"+observaciones+"' WHERE `serie` = '"+serie+"';";
             System.out.println("valor de sql: "+ SQL);  
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            System.out.println("valor DENTRO DEL TYR - ANTES DEL IF de sql: "+ SQL);
            res = PS.executeUpdate();
            if(res > 0){
                System.out.println("valor de sql: "+ SQL);
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                System.out.println("valor del res = "+ res + " dentro del Update");
            }
        } catch (SQLException e) {
            System.out.println("valor de sql: "+ SQL);
               JOptionPane.showMessageDialog(null, "Error al Modificar..." + e.getMessage());
                System.err.println("Error... No es posible modificar los datos en la  DDBB: "+ e.getMessage());
            
        }finally{
            System.out.println("valor de sql: "+ SQL);
            PS = null;
            RS = null;
            CN.close();
            System.out.println("Conexión cerrada  para actualización de datos");
            
        }
        
        return res;
    }
    
      // Método para Eliminar Registros
    public int deleteDatos(String serie){
        System.out.println("serie="+ serie);
        
        String SQL = "DELETE FROM `terminales` WHERE `terminales`.`serie` = '"+serie+"'";
        int res = 0 ;
        System.out.println("Valor del res inicio de eliminacion: "+ res);
        System.out.println("valor de sql: "+ SQL);
        
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            System.out.println("valor de sql: "+ SQL);
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                System.out.println("valor de sql"+ SQL);
                System.out.println("valor de sql: "+ SQL);
                
            }
            System.out.println("resultado = "+ res +" Despues del try deleteDatos");
            System.out.println("valor de sql: "+ SQL);
        } catch (SQLException e) {
            System.out.println("serie="+ serie);
            System.err.println("Error!!!... No es posible Eliminar los datos en la  DDBB: "+ e.getMessage());
            System.out.println("valor de sql: "+ SQL);
        }finally{
            PS = null;
            System.out.println("valor de sql: "+ SQL);
            //RS = null;
            CN.close();
            System.out.println("serie="+ serie);
            System.out.println("Conexión cerrada desde Eliminación de datos");
        }
        return res;
    }
    //Método para listar los datos leyendo desde la DDBB
    public DefaultTableModel getDatos(){
        try {
            setTitulos();
            PS = CN.getConnection().prepareStatement(SQL_SELECT);
            RS = PS.executeQuery();
            Object[] fila = new Object[10];
            while (RS.next()){
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getString(5);
                fila[5] = RS.getString(6);
                fila[6] = RS.getString(7);
                fila[7] = RS.getString(8);
                fila[8] = RS.getString(9);
                fila[9] = RS.getString(10);
                DT.addRow(fila);
                
            }
        } catch (SQLException e) {
            System.out.println("Error al Listar los datos: "+ e.getMessage());
        }finally{
            PS = null;
            RS = null;
            CN.close();
        }
        return DT;
    }
}

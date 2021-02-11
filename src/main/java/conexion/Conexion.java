package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    static private String url= "jdbc:mysql://localhost:3306/afa";
    static private String usr = "root";
    static private String pwd = "";
    static private String driver = "com.mysql.cj.jdbc.Driver";

    public void elDriver(){
        try{
            Class.forName(driver);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection  conection(){
        Connection conneccion = null;
        try{
            elDriver();
            conneccion = DriverManager.getConnection(url, usr, pwd);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conneccion;
    }
}
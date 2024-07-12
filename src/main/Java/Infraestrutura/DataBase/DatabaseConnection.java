package Infraestrutura.DataBase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

   //creo la conexión

    private static final String url="jdbc:mysql//localhost:3306/trabajofinal";
    private static final String user="root";
    private static final String password="";

 //creo un método

    public static Connection getconnection()  {
        try {
           // Class.forName("com.mysql.cj.jbdc.Drive");
            return DriverManager.getConnection(url, user, password);
        }catch (SQLException e){

            throw new RuntimeException(e);

        }





    }




}

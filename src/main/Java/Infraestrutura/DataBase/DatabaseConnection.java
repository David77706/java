package Infraestrutura.DataBase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

   //creo la conexión

    private static final String url="jdbc:mysql://localhost:3306/proyecto";
    private static final String user="root";
    private static final String password="admin";

 //creo un método

    public static Connection getconnection()  {
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(url, user, password);

        }catch (SQLException | ClassNotFoundException e){

            throw new RuntimeException(e);

        }





    }




}

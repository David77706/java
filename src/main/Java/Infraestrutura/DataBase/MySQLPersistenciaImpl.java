package Infraestrutura.DataBase;

import Infraestrutura.IPersistencia;
import modelos.Clientes;
import java.sql.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLPersistenciaImpl implements IPersistencia {


    private final Connection connexion;

    public MySQLPersistenciaImpl() {
        this.connexion = DatabaseConnection.getconnection();
    }

    //implemento el método de la Interfaz
    @Override
    public void saveUser(Clientes cliente) {
        String sql="INSERT INTO usuario(nombre,clave,correo)values(?,?,?)";
        try {
            PreparedStatement preparador= this.connexion.prepareStatement(sql);
            preparador.setString(1,cliente.getNombre());
            preparador.setString(2,cliente.getClave());
            preparador.setString(3,cliente.getCorreo());
            preparador.executeUpdate();
            preparador.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //consulto por usuario
    @Override
    public Clientes findByUsername(String nombre) {
        String sql="SELECT *FROM usuario WHERE nombre=?";
        try {
            PreparedStatement preparador= connexion.prepareStatement(sql);
            preparador.setString(1,nombre);
            ResultSet tablaVirtual= preparador.executeQuery();

            if(tablaVirtual.next()){
                Clientes cliente=new Clientes();
                cliente.setId(tablaVirtual.getInt("id"));
                cliente.setNombre(tablaVirtual.getString("nombre"));
                cliente.setClave(tablaVirtual.getString("clave"));
                cliente.setCorreo(tablaVirtual.getString("correo"));
                return cliente;


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }
    // consulta todos los clientes
    @Override
    public ArrayList<Clientes> getAllCliente() {
        String sql="SELECT * From usuario";
        ArrayList<Clientes>clientes=new ArrayList<>();

        try {
            PreparedStatement preparador=connexion.prepareStatement(sql);
            ResultSet tablaResult=preparador.executeQuery();

            while(tablaResult.next()){

                Clientes cliente= new Clientes();
                cliente.setId(tablaResult.getInt("id"));
                cliente.setNombre(tablaResult.getString("nombre"));
                cliente.setClave(tablaResult.getString("clave"));
                cliente.setCorreo(tablaResult.getString("correo"));

                clientes.add(cliente);





            }
            return clientes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
    //borra todos los clientes
    @Override
    public void borrarCliente(int id) {

        String sql="DELETE FROM usuario WHERE id=?";
        try {
            PreparedStatement preparador=connexion.prepareStatement(sql);
            preparador.setInt(1,id);
            preparador.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}


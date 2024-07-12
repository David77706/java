package servicios;

import Infraestrutura.DataBase.MySQLPersistenciaImpl;
import Infraestrutura.IPersistencia;
import modelos.Clientes;

import java.util.ArrayList;

public class UsuarioService implements IPersistencia {

    private IPersistencia persistencia=new MySQLPersistenciaImpl();

    //implemento el método de la Interfaz
    @Override
    public void saveUser(Clientes cliente) {
        persistencia.saveUser(cliente);

    }
    //servicio buscar por nombre
    @Override
    public Clientes findByUsername(String nombre) {
        return persistencia.findByUsername(nombre);
    }

    @Override
    public ArrayList<Clientes> getAllCliente() {
        return persistencia.getAllCliente();
    }

    @Override
    public void borrarCliente(int id) {
        persistencia.borrarCliente(id);

    }




}

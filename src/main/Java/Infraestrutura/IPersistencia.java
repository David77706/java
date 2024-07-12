package Infraestrutura;
import modelos.Clientes;

import java.util.ArrayList;

public interface IPersistencia {

    //métodos sistema persistencia


     void saveUser (Clientes cliente);
     //buscar cliente por nombre
     Clientes findByUsername(String cliente);
     //buscar todos los clientes
     ArrayList<Clientes>getAllCliente();
     //borrar
     void borrarCliente(int id);




}

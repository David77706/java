package Infraestrutura.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import servicios.UsuarioService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import modelos.Clientes;

@WebServlet("/cliente")

public class UsuarioControllers extends HttpServlet {

    private ObjectMapper mapper;
    private UsuarioService service;

    public UsuarioControllers() {
        this.mapper = new ObjectMapper();
        this.service = new UsuarioService();
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      encabezadosCors(resp);
    }
    //encabezados  Cors
    private void encabezadosCors(HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "content-type, authorization");


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        encabezadosCors(resp);
        System.out.println("aca");
       String nombre=req.getParameter("nombre");

       if(nombre!=null){
           Clientes cliente=service.findByUsername(nombre);
           if(cliente!=null){
               resp.setStatus(200);
               resp.setContentType("application/json");
               resp.setCharacterEncoding("UTF-8");

               resp.getWriter().write(mapper.writeValueAsString(cliente));


           }else{
               resp.setStatus(404);
               resp.getWriter().write("usuario no encontrados");
           }

       }else{
           ArrayList<Clientes>clientes=service.getAllCliente();
           resp.setStatus(200);
           resp.setContentType("application/json");
           resp.setCharacterEncoding("UTF-8");

           resp.getWriter().write(mapper.writeValueAsString(clientes));




       }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        encabezadosCors(resp);

       Clientes cliente= mapper.readValue(req.getInputStream(),Clientes.class);
       service.saveUser(cliente);

       resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString=req.getParameter("id");

        if(idString!=null&&idString.isEmpty()){
            int id=Integer.parseInt(idString);
            service.borrarCliente(id);
            resp.setStatus(200);





        }else{

            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Id de Usuario Incorrecto");
        }
    }
}

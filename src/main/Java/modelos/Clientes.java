package modelos;

public class Clientes {

    //creo los argumentos
    private int id;
    private String nombre;
    private String clave;
    private String correo;

    //creo el constructor vacío

    public Clientes(){

    }

    public Clientes(int id,String nombre,String clave,String correo){

        this.id = id;
        this.nombre= nombre;
        this.clave= clave;
        this.correo= correo;

    }
     //creo los métodos getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", Clave='" + clave + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }

}

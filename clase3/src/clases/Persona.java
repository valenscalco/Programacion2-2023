package clases;

public class Persona {
    protected String nombre;
    protected String apellido;

    public Persona(){

    }
    public Persona(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void moverPersona() {
        System.out.println("funcion moverPersona en Persona: "+this.nombre);
    }

    public void mover() {
        System.out.println("funcion mover en Persona: " +this.nombre);
    }
}

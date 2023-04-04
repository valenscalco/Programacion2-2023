package ejercicio1;

public class Persona {
    protected String nombre;
    protected String apellido;
    protected Integer edad;

    public Persona(){

    }
    public Persona(String nombre, String apellido, Integer edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {

        return nombre;
    }

    public String getApellido() {

        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }


    public void moverPersona() {
        System.out.println("funcion moverPersona en Persona: "+this.nombre);
    }

    public void mover() {
        System.out.println("funcion mover en Persona: " +this.nombre);
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre +
                ", Apellido: " + this.apellido +
                ", Edad: " + this.edad +
                "\n";
    }

}

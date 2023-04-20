package ejercicio1;

public class Empleado {

    protected String nombre;
    protected String apellido;
    protected Integer aniosTrabajados;
    protected Integer legajo;

    public Empleado(){

    }
    public Empleado(String nombre, String apellido, Integer aniosTrabajados, Integer legajo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.aniosTrabajados = aniosTrabajados;
        this.legajo = legajo;
    }

    public String getNombre() {

        return nombre;
    }

    public String getApellido() {

        return apellido;
    }

    public Integer getLegajo() {
        return legajo;
    }

    public Integer getAniosTrabajados() {
        return aniosTrabajados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setAniosTrabajados(Integer aniosTrabajados) {
        this.aniosTrabajados = aniosTrabajados;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }


    @Override
    public String toString() {
        return "Nombre: " + this.nombre +
                ", Apellido: " + this.apellido +
                ", Legajo: " + this.legajo +
                ", Anios Trabajados: " + this.aniosTrabajados +
                "\n";
    }

}

package clases;

public class Empleado extends Persona{
    protected String legajo;
    public Empleado(String legajo){
        super();
        this.legajo = legajo;
    }

    public Empleado(String nombre, String apellido, String legajo){
        super(nombre, apellido);
        this.legajo = legajo;
    }
    @Override
    public void mover(){
        System.out.println("funcion mover en Empleado: " +this.nombre);
    }

    public void moverEmpleado(){
        System.out.println("funcion moverEmpleado en Empleado: " +this.nombre);
    }

    @Override
    public String toString(){
        String resultado = "Empleado - nombre: " +this.nombre+" - apellido: "+this.apellido;
        return resultado;
    }
}

import clases.Empleado;
import clases.Persona;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main m = new Main();
        m.arrancar();
    }

    public void arrancar() {
        Persona persona = new Persona( "Fernando", "Villareal");
        persona.mover();
        Empleado empleado = new Empleado("Fernanda",  "Villa",  "5247");
        empleado.mover();

        Persona empleado2 = new Empleado("Facundo",  "Villano",  "5248");
        empleado2.mover();
        Empleado empleado3 = (Empleado)empleado2;
        empleado3.moverEmpleado();
        System.out.println(empleado);
        System.out.println(empleado2); //lugar en memoria
        System.out.println(empleado3);

        String tipo = "Empleado";
        if(persona instanceof Empleado){
            System.out.println("Es un " + tipo);
        }
        else{
            System.out.println("No es un " + tipo);
        }
    }
}
import ejercicio7.Empleado;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Empleado> listaEmpleados = new ArrayList<>();
        Empleado empleado1 = new Empleado("Soledad", "Alone", "15", "58974");
        Empleado empleado2 = new Empleado("Aiden", "Galager", "7", "58976");
        Empleado empleado3 = new Empleado("Cristian", "Ateo", "1", "58978");
        Empleado empleado4 = new Empleado("Kayla", "Silveira", "5", "58977");
        Empleado empleado5 = new Empleado("Esqui", "Mal", "16", "58973");

        listaEmpleados.add(empleado1);
        listaEmpleados.add(empleado2);
        listaEmpleados.add(empleado3);
        listaEmpleados.add(empleado4);
        listaEmpleados.add(empleado5);

        System.out.println(listaEmpleados.toString());

        //List<Empleado> empleado = new ArrayList<>();

        String infoEmpleado = "nombre=Juan,apellido=Perez,legajo=1234,aniosTrabajados=5";
        String infoEmpleado1 = "nombre=Pablo, apellido=Marquez, legajo=E001, aniosTrabajados=10";
        String infoEmpleado2 = "nombre=Pablo,apellido=Marquez, legajo=E001, aniosTrabajados=10";
        String infoEmpleado3 = "nombre=Pablo ,apellido=Marquez , legajo=E001, aniosTrabajados=10";
        String infoEmpleado4 = "Nombre=Pablo,apellidO=Marquez , LEGAJO=E001,ANIOStrabajados=10";
        String infoEmpleado5 = "nombre=Pablo,legajo=E001,apellido=Marquez,aniosTrabajados=10";

        Empleado empleado = Empleado.fromString(infoEmpleado);
        Empleado empleado01 = Empleado.fromString(infoEmpleado1);
        Empleado empleado02 = Empleado.fromString(infoEmpleado2);
        Empleado empleado03 = Empleado.fromString(infoEmpleado3);
        Empleado empleado04 = Empleado.fromString(infoEmpleado4);
        Empleado empleado05 = Empleado.fromString(infoEmpleado5);

        System.out.println(empleado.toString());
        System.out.println(empleado01.toString());
        System.out.println(empleado02.toString());
        System.out.println(empleado03.toString());
        System.out.println(empleado04.toString());
        System.out.println(empleado05.toString());
    }
}
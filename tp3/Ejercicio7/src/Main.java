import ejercicio7.Empleado;
import ejercicio7.Excepciones;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Excepciones {
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

        //System.out.println(listaEmpleados.toString());

        String infoEmpleado1 = "nombre=Pablo, apellido=Marquez, legajo=E001, aniosTrabajados=10";
        String infoEmpleado2 = "nombre=Pablo,apellido=Marquez, legajo=E001, aniosTrabajados=10";
        String infoEmpleado3 = "nombre=Pablo ,apellido=Marquez , legajo=E001, aniosTrabajados=10";
        String infoEmpleado4 = "Nombre=Pablo,apellidO=Marquez , LEGAJO=E001,ANIOStrabajados=10";
        String infoEmpleado5 = "nombre=Pablo,legajo=E001,apellido=Marquez,aniosTrabajados=10";


        Empleado empleado01 = Empleado.fromString(infoEmpleado1);
        Empleado empleado02 = Empleado.fromString(infoEmpleado2);
        Empleado empleado03 = Empleado.fromString(infoEmpleado3);
        Empleado empleado04 = Empleado.fromString(infoEmpleado4);
        Empleado empleado05 = Empleado.fromString(infoEmpleado5);

        System.out.println(empleado01.toString());
        System.out.println(empleado02.toString());
        System.out.println(empleado03.toString());
        System.out.println(empleado04.toString());
        System.out.println(empleado05.toString());
        try {
            String infoEmpleado6 = "legajo=E001,apellido=Marquez,aniosTrabajados=10";
            Empleado empleado6 = Empleado.fromString(infoEmpleado6);

            System.out.println(empleado6.toString());
        }catch (Excepciones e){
            e.printStackTrace();
        }
        try {
            String infoEmpleado7 = "nombre=Pablo, legajo=,apellido=Marquez,aniosTrabajados=10";
            Empleado empleado7 = Empleado.fromString(infoEmpleado7);

            System.out.println(empleado7.toString());
        }catch (Excepciones e){
            e.printStackTrace();
        }
        try {
            String infoEmpleado8 = "nombre=Emilio, legajo=E001,apellido=Marquez,aniosTrabajados=0";
            Empleado empleado8 = Empleado.fromString(infoEmpleado8);
            System.out.println(empleado8.toString());
        }catch (Excepciones e){
            e.printStackTrace();
        }
    }
}
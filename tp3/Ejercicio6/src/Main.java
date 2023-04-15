import ejercicio6.Empleado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Empleado> listaEmpleados = new ArrayList<>();
        Empleado empleado1 = new Empleado("Soledad", "Alone", 15, 58974);
        Empleado empleado2 = new Empleado("Aiden", "Galager", 7, 58976);
        Empleado empleado3 = new Empleado("Cristian", "Ateo", 1, 58978);
        Empleado empleado4 = new Empleado("Kayla", "Silveira", 5, 58977);
        Empleado empleado5 = new Empleado("Esqui", "Mal", 16, 58973);

        listaEmpleados.add(empleado1);
        listaEmpleados.add(empleado2);
        listaEmpleados.add(empleado3);
        listaEmpleados.add(empleado4);
        listaEmpleados.add(empleado5);

        Map<String, Empleado> empleadoMap = new HashMap<>();

        empleadoMap.put(empleado1.getApellido()+", "+ empleado1.getNombre(), empleado1);
        empleadoMap.put(empleado2.getApellido()+", "+ empleado2.getNombre(), empleado2);
        empleadoMap.put(empleado3.getApellido()+", "+ empleado3.getNombre(), empleado3);
        empleadoMap.put(empleado4.getApellido()+", "+ empleado4.getNombre(), empleado4);
        empleadoMap.put(empleado5.getApellido()+", "+ empleado5.getNombre(), empleado5);

        for(Map.Entry<String, Empleado> entrada : empleadoMap.entrySet()) {
            String clave = entrada.getKey();
            Empleado empleado = entrada.getValue();
            System.out.println(clave + ": " + empleado.toString());
        }
    }
}
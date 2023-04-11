import ejercicio1.Empleado;
import ejercicio1.SetEmpleados;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.crearSet();
    }

    public <Iterator> void crearSet() {
        Set<Empleado> setEmpleados = new HashSet<>();

        Empleado empl1 = new Empleado("Soledad", "Alone", 15, 58974);
        Empleado empl2 = new Empleado("Cristian", "Ateo", 1, 58978);
        Empleado empl3 = new Empleado("Aiden", "Galager", 7, 58976);
        Empleado empl4 = new Empleado("Kayla", "Silveira", 5, 58977);
        Empleado empl5 = new Empleado("Cristian", "Ateo", 1, 58978);


        setEmpleados.add(empl1);
        setEmpleados.add(empl2);
        setEmpleados.add(empl3);
        setEmpleados.add(empl4);
        setEmpleados.add(empl5);

        System.out.println(setEmpleados.toString());
        Set<SetEmpleados> EmpleadoSet = new HashSet<>();

        SetEmpleados empleado1 = new SetEmpleados("Soledad", "Alone", 15, 58974);
        SetEmpleados empleado2 = new SetEmpleados("Cristian", "Ateo", 1, 58978);
        SetEmpleados empleado3 = new SetEmpleados("Aiden", "Galager", 7, 58976);
        SetEmpleados empleado4 = new SetEmpleados("Kayla", "Silveira", 5, 58977);
        SetEmpleados empleado5 = new SetEmpleados("Cristian", "Ateo", 1, 58978);


        EmpleadoSet.add(empleado1);
        EmpleadoSet.add(empleado2);
        EmpleadoSet.add(empleado3);
        EmpleadoSet.add(empleado4);
        EmpleadoSet.add(empleado5);

        System.out.println(EmpleadoSet);
    }

}

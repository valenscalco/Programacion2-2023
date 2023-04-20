import ejercicio1.Empleado;
import ejercicio1.SetEmpleado;

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
        Set<SetEmpleado> EmpleadosSet = new HashSet<>();

        SetEmpleado empleado1 = new SetEmpleado("Soledad", "Alone", 15, 58974);
        SetEmpleado empleado2 = new SetEmpleado("Cristian", "Ateo", 1, 58978);
        SetEmpleado empleado3 = new SetEmpleado("Aiden", "Galager", 7, 58976);
        SetEmpleado empleado4 = new SetEmpleado("Kayla", "Silveira", 5, 58977);
        SetEmpleado empleado5 = new SetEmpleado("Cristian", "Ateo", 1, 58978);


        EmpleadosSet.add(empleado1);
        EmpleadosSet.add(empleado2);
        EmpleadosSet.add(empleado3);
        EmpleadosSet.add(empleado4);
        EmpleadosSet.add(empleado5);

        System.out.println(EmpleadosSet.toString());
    }

}

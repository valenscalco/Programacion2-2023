import ejercicio1.Empleado;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.crearSet();
    }

    public void crearSet(){
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
    }
}
/* Integer number = 0;
        Integer numPersona = 0;
        Integer mayorPersona = persona1.getEdad();
        Persona pers = persona1;

        //ITERAR PARA ENCONTRAR PERSONA DE MAYOR EDAD DENTRO DE LISTA DE PERSONAS
        for(Persona persona : listaPersonas) {
            if (mayorPersona < persona.getEdad()){
                mayorPersona = persona.getEdad();
                numPersona = number;
                pers = persona;
                number += 1;
            } else {
                number += 1;
            }
            if (number == 5) {
                System.out.println("La persona de mayor edad en la lista es " +
                        pers.getNombre() + ' ' + pers.getApellido() + " con " + pers.getEdad() + " años.");
            }

    }*/

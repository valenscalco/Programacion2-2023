import ejercicio1.Empleado;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.crearSet();
    }

    public void crearSet(){
        Set<Empleado> setEmpleados = new HashSet<>();

        Empleado empl1 = new Empleado("Juan", "Perez", 25, 58974);
        Empleado empl2 = new Empleado("Juan", "Perez", 25, 58974);
        Empleado empl3 = new Empleado("Juan", "Perez", 25, 58974);


        setEmpleados.add(empl1);
        setEmpleados.add(empl2);
        setEmpleados.add(empl3);

        List<Persona> listaPersonas = new ArrayList<>();
        List<Integer> listaEdad = new ArrayList<>();

        int numero;
        for (int i = 1; i <= 5; i++) {
            numero = (int) (Math.random() * 31 + 20);
            listaEdad.add(numero);
        }
        //System.out.println(listaEdad);

        Persona persona1 = new Persona(listaNombres.get(0), listaApellidos.get(0), listaEdad.get(0));
        Persona persona2 = new Persona(listaNombres.get(1), listaApellidos.get(1), listaEdad.get(1));
        Persona persona3 = new Persona(listaNombres.get(2), listaApellidos.get(2), listaEdad.get(2));
        Persona persona4 = new Persona(listaNombres.get(3), listaApellidos.get(3), listaEdad.get(3));
        Persona persona5 = new Persona(listaNombres.get(4), listaApellidos.get(4), listaEdad.get(4));

        listaPersonas.add(persona1);
        listaPersonas.add(persona2);
        listaPersonas.add(persona3);
        listaPersonas.add(persona4);
        listaPersonas.add(persona5);

        System.out.println(listaPersonas.toString());

        Integer number = 0;
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
        }
    }

}
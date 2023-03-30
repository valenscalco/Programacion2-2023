import ejercicio1.Persona;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.crearLista();
    }

    public void crearLista(){
        List<String> listaNombres = new ArrayList<>();

        listaNombres.add("Soledad");
        listaNombres.add("Lauren");
        listaNombres.add("Aiden");
        listaNombres.add("Kayla");
        listaNombres.add("Cristian");

        //System.out.println(listaNombres);

        List<String> listaApellidos = new ArrayList<>();

        listaApellidos.add("Alone");
        listaApellidos.add("Gimenez");
        listaApellidos.add("Galagar");
        listaApellidos.add("Silveira");
        listaApellidos.add("Ateo");

        //System.out.println(listaApellidos);

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

        //ITERAR PARA ENCONTRAR PERSONA DE MAYOR EDAD DENTRO DE LISTA DE PERSONAS
        for(Persona persona : listaPersonas) {
            if (mayorPersona < persona.getEdad()){
                mayorPersona = persona.getEdad();
                numPersona = number;
                number += 1;
            } else {
                number += 1;
            }
        }

        //IMPRIMIR PERSONA DE MAYOR EDAD SEGUN LA LISTA DE NOMBRES Y EDADES
        /*System.out.println("La persona de mayor edad en la lista es " +
                listaNombres.get(numPersona) + " con " + listaEdad.get(numPersona) + " años.");
        */

        //IMPRIMIR PERSONA DE MAYOR EDAD SEGUN LA LISTA DE PERSONA
        if (numPersona == 0){
            System.out.println("La persona de mayor edad en la lista es " +
                    persona1.getNombre() + " con " + persona1.getEdad() + " años.");
        } else if (numPersona == 1) {
            System.out.println("La persona de mayor edad en la lista es " +
                    persona2.getNombre() + " con " + persona2.getEdad() + " años.");
        } else if (numPersona == 2) {
            System.out.println("La persona de mayor edad en la lista es " +
                    persona3.getNombre() + " con " + persona3.getEdad() + " años.");
        } else if (numPersona == 3) {
            System.out.println("La persona de mayor edad en la lista es " +
                    persona4.getNombre() + " con " + persona4.getEdad() + " años.");
        } else if (numPersona == 4) {
            System.out.println("La persona de mayor edad en la lista es " +
                    persona5.getNombre() + " con " + persona5.getEdad() + " años.");
        }
            /*
            ITERAR PARA ENCONTRAR PERSONA DE MAYOR EDAD DENTRO DE LISTA DE EDAD
        Integer number = 0;
        for (int i = 0; i < 5; i++) {
            if (mayorPersona < listaEdad.get(i)){
                mayorPersona = listaEdad.get(i);
                number = i;
            }
        }
        System.out.println("La persona de mayor edad en la lista es " + listaNombres.get(number) + " con " + listaEdad.get(number) + " años.");
        */

        /* IMPRIMIR LISTA DE PERSONAS SIN USAR TOSTRING
        for (Persona number : listaPersonas) {
            System.out.println("________________________________________");
            System.out.println("Nombre: " +number.getNombre());
            System.out.println("Apellido: " +number.getApellido());
            System.out.println("Edad: " +number.getEdad());
        }*/
    }

}
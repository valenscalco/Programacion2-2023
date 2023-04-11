import ejercicio2.Empleado;
import ejercicio2.ListaGenerica;

public class Main {
    public static void main(String[] args) {
        ListaGenerica<Empleado> listaEmpleados = new ListaGenerica<Empleado>();
        Empleado empleado1 = new Empleado("Soledad", "Alone", 15, 58974);
        Empleado empleado2 = new Empleado("Aiden", "Galager", 7, 58976);
        Empleado empleado3 = new Empleado("Cristian", "Ateo", 1, 58978);
        Empleado empleado4 = new Empleado("Kayla", "Silveira", 5, 58977);

        //1
        listaEmpleados.agregar(empleado1);
        listaEmpleados.agregar(empleado2);
        listaEmpleados.agregar(empleado3);
        listaEmpleados.agregar(empleado4);

        //2
        System.out.println("Lista Empleados: " + "\n" +listaEmpleados.getList().toString());

        //3
        System.out.println("\nTamaño de la lista: " + listaEmpleados.getSize());

        //4
        listaEmpleados.agregarFirst(new Empleado("Rob", "Abank", 8, 58975));
        System.out.println("\nLista con el nuevo empleado en la primer prosicion: ");
        System.out.println(listaEmpleados.getList().toString());

        //5
        listaEmpleados.ordenar();
        System.out.println("Lista ordenada por legajos: " + "\n" + listaEmpleados.getList().toString());


        //6
        listaEmpleados.desordenar();
        System.out.println("Lista desordenada: " + "\n" + listaEmpleados.getList().toString());

        //7
        listaEmpleados.addPosition(new Empleado("Laila", "Ser", 1, 59879), 2);
        System.out.println(listaEmpleados.getList().toString());

        //8
        System.out.println("Cuarto elemento de la lista: " + "\n" + listaEmpleados.obtener(3));

        //9
        System.out.println("Primer elemento de la lista: " + "\n" + listaEmpleados.obtenerFirst());

        //10
        System.out.println("Ultimo elemento de la lista: " + "\n" + listaEmpleados.obtenerLast());

        //11
        listaEmpleados.delete(1);
        System.out.println(listaEmpleados.getList().toString());
    }
}
import ejercicio1.Hilo;
import ejercicio1.Hilo2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner iteraciones = new Scanner(System.in);
        System.out.print("Ingrese un número de iteraciones: ");
        int iteracion = iteraciones.nextInt();
        Scanner demoras = new Scanner(System.in);
        System.out.print("Ingrese el tiempo de demora: ");
        int demora = demoras.nextInt();
        iteraciones.close();
        demoras.close();
        Hilo2 h1_impl = new Hilo2("implement 4", demora, iteracion);
        Thread h1 = new Thread(h1_impl);
        Hilo2 h2_impl = new Hilo2("implement 1", demora, iteracion);
        Thread h2 = new Thread(h2_impl);
        Hilo2 h3_impl = new Hilo2("implement 2", demora, iteracion);
        Thread h3 = new Thread(h3_impl);
        Hilo2 h4_impl = new Hilo2("implement 3", demora, iteracion);
        Thread h4 = new Thread(h4_impl);
        h1.start();
        h2.start();
        h3.start();
        h4.start();

        int demora_h1 = (int) (Math.random() * 950 + 50);
        Hilo h01 = new Hilo("extends 1",demora_h1);
        Hilo h02 = new Hilo("extends 2",demora_h1);
        Hilo h03 = new Hilo("extends 3",demora_h1);
        Hilo h04 = new Hilo("extends 4",demora_h1);
        h01.start();
        h02.start();
        h03.start();
        h04.start();
    }
}
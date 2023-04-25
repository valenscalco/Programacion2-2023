import ejercicio2.Hilo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> listaNum = new ArrayList<>();
        for(int i=0; i<40; i++){
            listaNum.add((int) (Math.random() * 13 + 3));
        }

        Hilo h1 = new Hilo("Extends 1", listaNum);
        Hilo h2 = new Hilo("Extends 2", listaNum);
        Hilo h3 = new Hilo("Extends 3", listaNum);
        h1.start();
        h2.start();
        h3.start();

    }
}
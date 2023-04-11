import java.util.ArrayList;
import java.util.List;
import ejercicio4.Cuadrado;
import ejercicio4.Rectangulo;
import ejercicio4.Triangulo;

public class Main {
    public static void main(String[] args) {
        List<Object> listaGeometrica = new ArrayList<>();
        Cuadrado cuadrado1 = new Cuadrado(4);
        Cuadrado cuadrado2 = new Cuadrado(8);
        Rectangulo rect1 = new Rectangulo(5, 2);
        Rectangulo rect2 = new Rectangulo(4, 7);
        Triangulo triangulo1 = new Triangulo(6, 6);


        listaGeometrica.add(cuadrado1);
        listaGeometrica.add(cuadrado2);
        listaGeometrica.add(rect1);
        listaGeometrica.add(rect2);
        listaGeometrica.add(triangulo1);

        System.out.println(listaGeometrica.toString());
    }
}
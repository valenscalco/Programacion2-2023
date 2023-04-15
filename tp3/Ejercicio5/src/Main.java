import java.util.ArrayList;
import java.util.List;
import ejercicio5.Cuadrado;
import ejercicio5.Excepciones;
import ejercicio5.Rectangulo;
import ejercicio5.Triangulo;

public class Main {
    public static void main(String[] args) {
        List<Object> listaGeometrica = new ArrayList<>();
        try {
            Cuadrado cuadrado1 = new Cuadrado(4, 0, 0);
            Cuadrado cuadrado2 = new Cuadrado(8, 1, 5);
            Rectangulo rect1 = new Rectangulo(5, 2, 0, 1);
            Rectangulo rect2 = new Rectangulo(4, 7, 2, 1);
            Triangulo triangulo1 = new Triangulo(6, 6, 3, 3);

            listaGeometrica.add(cuadrado1);
            listaGeometrica.add(cuadrado2);
            listaGeometrica.add(rect1);
            listaGeometrica.add(rect2);
            listaGeometrica.add(triangulo1);

            System.out.println(listaGeometrica.toString());

        } catch (Excepciones e) {
            System.out.println(e.getMessage());;
        }

        Cuadrado c=null;
        try {
            c = new Cuadrado(-4, 0, 0);
            Cuadrado c1 = new Cuadrado(4, 0, 0);
        }
        catch (Exception e) {

        }
        Cuadrado c1 = null;
        try {
            c1 = new Cuadrado(-1, 0, 0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Rectangulo r = null;
        try {
            r = new Rectangulo(-4, 0, 0, -2);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Triangulo t = null;
        try {
            t = new Triangulo(-4, 0, 0, -2);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
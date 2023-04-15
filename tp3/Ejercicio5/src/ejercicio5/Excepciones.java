package ejercicio5;

public class Excepciones extends Exception{

    // Definición de constructores
    public Excepciones() {
        super("Texto genérico de excepción");
    }
    public Excepciones(String msg) {
        super(msg);
    }
}

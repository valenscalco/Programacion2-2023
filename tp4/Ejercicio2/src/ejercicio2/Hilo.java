package ejercicio2;

import java.util.List;

public class Hilo extends Thread{
    private String nombre;
    private List<Integer> lista;
    private boolean stopHilo;

    public Hilo(String nombre, List<Integer> lista) {
        this.nombre = nombre;
        this.lista = lista;
        this.stopHilo = false;
    }

    public List<Integer> getLista() {
        return lista;
    }

    public void setLista(List<Integer> lista) {
        this.lista = lista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {

        while(!lista.isEmpty()){
            int num =  lista.remove(0);
            int factorial = 1;
            for(int i=1; i <= num; i++){
                factorial *= i;
            }
            System.out.println("\nHilo: "+ this.nombre + ", procesando la lista." + "\n" +
                    "Valor a calcular: " + num + "\n" + "Resultado: " + factorial +
                    "\n" + "Quedan " + lista.size() + " elementos en la lista por procesar.");
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}

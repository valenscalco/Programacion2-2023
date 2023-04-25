package ejercicio1;

import java.util.Scanner;

public class Hilo2 implements Runnable{
    protected String nombre;
    protected int demora;
    protected int iteracion;

    public Hilo2(String nombre, int demora, int iteracion){
        this.nombre = nombre;
        this.demora = demora;
        this.iteracion = iteracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDemora() {
        return demora;
    }

    public void setDemora(int demora) {
        this.demora = demora;
    }

    public int getIteracion() {
        return iteracion;
    }

    public void setIteracion(int iteracion) {
        this.iteracion = iteracion;
    }

    @Override
    public void run() {
        for(int i=0; i < this.iteracion; i++) {
            System.out.println("Este es el hilo " + this.nombre + ", iteracion "
                    + (i+1) + " de " + this.iteracion);
            try {
                Thread.sleep(this.demora);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

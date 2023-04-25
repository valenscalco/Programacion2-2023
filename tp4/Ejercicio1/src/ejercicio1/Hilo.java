package ejercicio1;

public class Hilo extends Thread{
    protected String nombre;
    protected int demora;

    public Hilo(String nombre, int demora){
        this.nombre = nombre;
        this.demora = demora;
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

    @Override
    public void run() {
        int num = (int) (Math.random() * 31 + 10);
        for(int i=0; i < num; i++) {
            System.out.println("Este es el hilo " + this.nombre + ", iteracion " + (i+1) + " de " + num);
            try {
                Thread.sleep(this.demora);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

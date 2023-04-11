package ejercicio4;

public class Cuadrado implements FiguraGeometrica{
    protected Integer largo;


    public Cuadrado(Integer largo){
        this.largo = largo;
    }

    public Integer getLargo() {
        return largo;
    }

    public void setLargo(Integer largo) {
        this.largo = largo;
    }

    @Override
    public float calcularPerimetro() {
        float perimetro = this.largo * 4;
        return perimetro;
    }

    @Override
    public float calcularSuperficie() {
        float superficie = this.largo * this.largo;
        return superficie;
    }


    @Override
    public String toString() {
        return "Medidas del cuadrado: \n Largo de los lados: " + this.largo +
                ", Superficie: " + calcularSuperficie() +
                ", Perimetro: " + calcularPerimetro() +
                "\n";
    }
}

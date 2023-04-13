package ejercicio5;

public class Rectangulo implements FiguraGeometrica{
    protected Integer largo;
    protected Integer ancho;
    protected Integer ejeX;
    protected Integer ejeY;

    public Rectangulo(Integer largo, Integer ancho, Integer ejeX, Integer ejeY){
        this.largo = largo;
        this.ancho = ancho;
        this.ejeX = ejeX;
        this.ejeY = ejeY;
    }


    public Integer getLargo() {
        return largo;
    }

    public void setLargo(Integer largo) {
        this.largo = largo;
    }

    public Integer getAncho() {
        return ancho;
    }

    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }

    public Integer getEjeX() {
        return ejeX;
    }

    public void setEjeX(Integer ejeX) {
        this.ejeX = ejeX;
    }

    public Integer getEjeY() {
        return ejeY;
    }

    public void setEjeY(Integer ejeY) {
        this.ejeY = ejeY;
    }

    @Override
    public float calcularPerimetro() {
        float perimetro = this.largo * 2 + this.ancho * 2;
        return perimetro;
    }

    @Override
    public float calcularSuperficie() {
        float superficie = this.largo * this.ancho;
        return superficie;
    }
    @Override
    public String toString() {
        return "Medidas del rectangulo: \n Largo de los lados: " + this.largo +
                ", Ancho de los lados: " + this.ancho +
                ", Superficie: " + calcularSuperficie() +
                ", Perimetro: " + calcularPerimetro() +
                "\n";
    }
}

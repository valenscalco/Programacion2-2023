package ejercicio5;

public class Triangulo implements FiguraGeometrica{
    protected Integer base;
    protected Integer altura;
    protected Integer ejeX;
    protected Integer ejeY;




    public Triangulo(Integer altura, Integer base, Integer ejeX, Integer ejeY){
        this.base = base;
        this.altura = altura;
        this.ejeX = ejeX;
        this.ejeY = ejeY;
    }

    public Integer getBase() {
        return base;
    }

    public void setBase(Integer base) {
        this.base = base;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
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
        float perimetro = this.altura * 2 + this.base;
        return perimetro;
    }

    @Override
    public float calcularSuperficie() {
        float superficie = (this.base * this.altura) / 2;
        return superficie;
    }
    @Override
    public String toString() {
        return "Medidas del cuadrado: \n Altura de los lados: " + this.altura +
                ", Base: " + this.base +
                ", Superficie: " + calcularSuperficie() +
                ", Perimetro: " + calcularPerimetro() +
                "\n";
    }
}
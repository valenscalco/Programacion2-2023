package ejercicio4;

public class Triangulo implements FiguraGeometrica{
    protected Integer base;
    protected Integer altura;




    public Triangulo(Integer altura, Integer base){
        this.base = base;
        this.altura = altura;
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

package ejercicio5;

public class Cuadrado implements FiguraGeometrica{
    protected Integer largo;
    protected Integer ejeX;
    protected Integer ejeY;


    public Cuadrado(Integer largo, Integer ejeX, Integer ejeY) throws Exception{
        try {
            if (largo > 0 && ejeX >= 0 && ejeY >= 0) {
                this.largo = largo;
                this.ejeX = ejeX;
                this.ejeY = ejeY;
            }
            else {
                throw new Exception("El lado o la pos debe ser mayor a 0");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Integer getLargo() {
        return largo;
    }

    public void setLargo(Integer largo) {
        try {
            if (largo > 0) {
                this.largo = largo;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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
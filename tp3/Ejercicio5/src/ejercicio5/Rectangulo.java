package ejercicio5;

public class Rectangulo implements FiguraGeometrica{
    protected Integer largo;
    protected Integer ancho;
    protected Integer ejeX;
    protected Integer ejeY;

    public Rectangulo(Integer largo, Integer ancho, Integer ejeX, Integer ejeY) throws Excepciones{
        try {
            if (largo > 0 && ancho > 0 && ejeX >= 0 && ejeY >= 0) {
                this.largo = largo;
                this.ancho = ancho;
                this.ejeX = ejeX;
                this.ejeY = ejeY;
            }
            else {
                throw new Excepciones("El lado, el ancho y los ejes debe ser positivos");
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

    public Integer getAncho() {
        return ancho;
    }

    public void setAncho(Integer ancho) {
        try {
            if (ancho > 0) {
                this.ancho = ancho;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Integer getEjeX() {
        return ejeX;
    }

    public void setEjeX(Integer ejeX) {
        try {
            if (ejeX >= 0) {
                this.ejeX = ejeX;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Integer getEjeY() {
        return ejeY;
    }

    public void setEjeY(Integer ejeY) {
        try {
            if (ejeY >= 0) {
                this.ejeY = ejeY;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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

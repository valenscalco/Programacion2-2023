package ejercicio5;

public class Triangulo implements FiguraGeometrica{
    protected Integer base;
    protected Integer altura;
    protected Integer ejeX;
    protected Integer ejeY;




    public Triangulo(Integer altura, Integer base, Integer ejeX, Integer ejeY) throws Excepciones{
        try {
            if (base > 0 && altura > 0 && ejeX >= 0 && ejeY >= 0) {
                this.base = base;
                this.altura = altura;
                this.ejeX = ejeX;
                this.ejeY = ejeY;
            }
            else {
                throw new Excepciones("La base, la altura y los ejes debe ser positivos");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Integer getBase() {
        return base;
    }

    public void setBase(Integer base) {
        try {
            if (base > 0) {
                this.base = base;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        try {
            if (altura > 0) {
                this.altura = altura;
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
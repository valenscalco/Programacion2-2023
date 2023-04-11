package ejercicio1;

public class SetEmpleados extends Empleado{
    public SetEmpleados() {
        super();
    }

    public SetEmpleados(String nombre, String apellido, Integer legajo, Integer aniosTrabajados) {
        super(nombre, apellido, legajo, aniosTrabajados);
    }

    @Override
    public boolean equals(Object obj) { // esta funcion es la que se encarga de comparar los objetos y ver si son
        // iguales o no
        if (obj == null) {
            return false;
        }
        if (obj instanceof SetEmpleados) {
            SetEmpleados empleado = (SetEmpleados) obj;
            if (this.legajo == empleado.getLegajo()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.legajo;
    }

    public String toString() {
        return "Nombre: " + this.nombre +
                ", Apellido: " + this.apellido +
                ", Legajo: " + this.legajo +
                ", Anios Trabajados: " + this.aniosTrabajados +
                "\n";
    }
}

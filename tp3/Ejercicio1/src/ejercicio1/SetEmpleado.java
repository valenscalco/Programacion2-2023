package ejercicio1;

import java.util.Objects;

public class SetEmpleado extends Empleado{
    public SetEmpleado() {
        super();
    }

    public SetEmpleado(String nombre, String apellido, Integer legajo, Integer aniosTrabajados) {
        super(nombre, apellido, legajo, aniosTrabajados);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof SetEmpleado) {
            SetEmpleado empleado = (SetEmpleado) obj;
            if (legajo == empleado.getLegajo()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(legajo);
    }

    public String toString() {
        return "Nombre: " + this.nombre +
                ", Apellido: " + this.apellido +
                ", Legajo: " + this.legajo +
                ", Anios Trabajados: " + this.aniosTrabajados +
                "\n";
    }
}

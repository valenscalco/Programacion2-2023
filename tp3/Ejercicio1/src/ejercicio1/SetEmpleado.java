package ejercicio1;

import java.util.Objects;

public class SetEmpleado extends Empleado{
    public SetEmpleado(String nombre, String apellido, Integer legajo, Integer aniosTrabajados) {
        super(nombre, apellido, legajo, aniosTrabajados);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass()!= obj.getClass()) {
            return false;
        }
        SetEmpleado empleado = (SetEmpleado) obj;
        return Objects.equals(getNombre(), empleado.getNombre())
                && Objects.equals(getApellido(), empleado.getApellido())
                && Objects.equals(getLegajo(), empleado.getLegajo())
                && Objects.equals(getAniosTrabajados(), empleado.getAniosTrabajados());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getApellido(), getLegajo(), getAniosTrabajados());
    }
}

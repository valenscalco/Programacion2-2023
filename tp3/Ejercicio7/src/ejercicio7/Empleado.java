package ejercicio7;


public class Empleado {
    protected String nombre;
    protected String apellido;
    protected String aniosTrabajados;
    protected String legajo;

    public Empleado() {

    }

    public Empleado(String nombre, String apellido, String aniosTrabajados, String legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.aniosTrabajados = aniosTrabajados;
        this.legajo = legajo;
    }

    public String getNombre() {

        return nombre;
    }

    public String getApellido() {

        return apellido;
    }

    public String getLegajo() {
        return legajo;
    }

    public String getAniosTrabajados() {
        return aniosTrabajados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setAniosTrabajados(String aniosTrabajados) {
        this.aniosTrabajados = aniosTrabajados;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }


    public static Empleado fromString(String stringEmpleado) throws Excepciones {
        int i = 0;
        String nombre = "";
        String apellido = "";
        String aniosTrabajados = "";
        String legajo = "";
        stringEmpleado = stringEmpleado.replaceAll(" ", "");
        String[] datos = stringEmpleado.split(",");
        try {
            if (datos.length == 4) {
                for (i = 0; i < 4; i++) {
                    String atributo = datos[i].split("=")[0];
                    if (atributo.equalsIgnoreCase("nombre")) {
                        nombre = datos[i].split("=")[1];
                    } else if (atributo.equalsIgnoreCase("apellido")) {
                        apellido = datos[i].split("=")[1];
                    } else if (atributo.equalsIgnoreCase("legajo")) {
                        legajo = datos[i].split("=")[1];
                    } else {
                        aniosTrabajados = datos[i].split("=")[1];
                    }
                }
            }else{
                throw new Excepciones("Falta uno o varios campos");
            }
            if (Integer.valueOf(aniosTrabajados) <= 0) {
                throw new Excepciones("Cantidad de años invalida");
            }
            /*if (nombre.equals("") || apellido.equals("") || legajo.equals("") || aniosTrabajados.equals("")) {
                throw new Excepciones("Falta completar uno o mas campos");
            }*/
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new Empleado(nombre, apellido, aniosTrabajados, legajo);
    }
        @Override
    public String toString() {
        return "Nombre: " + this.nombre +
                ", Apellido: " + this.apellido +
                ", Legajo: " + this.legajo +
                ", Anios Trabajados: " + this.aniosTrabajados +
                "\n";
    }
}
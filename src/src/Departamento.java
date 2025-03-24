import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String id;
    private String nombre;
    private List<Empleado> listaEmpleados;

    public Departamento(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.listaEmpleados = new ArrayList<>();
    }

    public void asignarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
    }

    public void eliminarEmpleado(Empleado empleado) {
        listaEmpleados.remove(empleado);
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre;
    }
}
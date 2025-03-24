public class Empleado {
    private String id;
    private String nombre;
    private String apellido;
    private String tipoEmpleado;
    private Departamento departamento;

    public Empleado(String id, String nombre, String apellido, String tipoEmpleado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoEmpleado = tipoEmpleado;
    }

    public void asignarDepartamento(Departamento departamento) {
        this.departamento = departamento;
        departamento.asignarEmpleado(this);
    }

    public void modificarEmpleado(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void eliminarEmpleado() {
        if (departamento != null) {
            departamento.eliminarEmpleado(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + " " + apellido + ", Tipo: " + tipoEmpleado + ", Departamento: " + (departamento != null ? departamento.getNombre() : "Ninguno");
    }
}
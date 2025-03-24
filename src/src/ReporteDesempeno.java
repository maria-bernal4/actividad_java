import java.util.List;

public class ReporteDesempeno {
    private String idEmpleado;
    private String metricas;
    private String fecha;

    public ReporteDesempeno(String idEmpleado, String metricas, String fecha) {
        this.idEmpleado = idEmpleado;
        this.metricas = metricas;
        this.fecha = fecha;
    }

    public void generarReporteIndividual() {
        System.out.println("\n--- Reporte Individual ---");
        System.out.println("+------------+------------+------------+");
        System.out.println("| ID Empleado | Métricas   | Fecha      |");
        System.out.println("+------------+------------+------------+");
        System.out.printf("| %-10s | %-10s | %-10s |\n", idEmpleado, metricas, fecha);
        System.out.println("+------------+------------+------------+");
    }

    public void generarReporteDepartamento(List<Empleado> empleados) {
        System.out.println("\n--- Reporte de Desempeño por Departamento ---");
        System.out.println("+------------+------------+------------+------------+");
        System.out.println("| ID Empleado | Nombre     | Apellido   | Métricas   |");
        System.out.println("+------------+------------+------------+------------+");
        for (Empleado empleado : empleados) {
            System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", empleado.getId(), empleado.getNombre(), empleado.getApellido(), "Excelente");
        }
        System.out.println("+------------+------------+------------+------------+");
    }
}
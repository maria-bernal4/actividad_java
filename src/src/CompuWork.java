import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompuWork {
    private static List<Empleado> empleados = new ArrayList<>();
    private static List<Departamento> departamentos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Sistema de Gestión de Recursos Humanos ---");
            System.out.println("1. Crear Empleado");
            System.out.println("2. Modificar Empleado");
            System.out.println("3. Eliminar Empleado");
            System.out.println("4. Crear Departamento");
            System.out.println("5. Asignar Empleado a Departamento");
            System.out.println("6. Generar Reporte de Desempeño Individual");
            System.out.println("7. Generar Reporte de Desempeño por Departamento");
            System.out.println("8. Visualizar Empleados");
            System.out.println("9. Visualizar Departamentos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    crearEmpleado(scanner);
                    break;
                case 2:
                    modificarEmpleado(scanner);
                    break;
                case 3:
                    eliminarEmpleado(scanner);
                    break;
                case 4:
                    crearDepartamento(scanner);
                    break;
                case 5:
                    asignarEmpleadoADepartamento(scanner);
                    break;
                case 6:
                    generarReporteIndividual(scanner);
                    break;
                case 7:
                    generarReporteDepartamento(scanner);
                    break;
                case 8:
                    visualizarEmpleados();
                    break;
                case 9:
                    visualizarDepartamentos();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void crearEmpleado(Scanner scanner) {
        System.out.print("Ingrese ID del empleado: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido del empleado: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese tipo de empleado (Permanente/Temporal): ");
        String tipoEmpleado = scanner.nextLine();

        Empleado empleado = new Empleado(id, nombre, apellido, tipoEmpleado);
        empleados.add(empleado);
        System.out.println("Empleado creado exitosamente.");
    }

    private static void modificarEmpleado(Scanner scanner) {
        System.out.print("Ingrese ID del empleado a modificar: ");
        String id = scanner.nextLine();
        Empleado empleado = buscarEmpleadoPorId(id);

        if (empleado != null) {
            System.out.print("Ingrese nuevo nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese nuevo apellido: ");
            String apellido = scanner.nextLine();
            empleado.modificarEmpleado(nombre, apellido);
            System.out.println("Empleado modificado exitosamente.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void eliminarEmpleado(Scanner scanner) {
        System.out.print("Ingrese ID del empleado a eliminar: ");
        String id = scanner.nextLine();
        Empleado empleado = buscarEmpleadoPorId(id);

        if (empleado != null) {
            empleado.eliminarEmpleado();
            empleados.remove(empleado);
            System.out.println("Empleado eliminado exitosamente.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void crearDepartamento(Scanner scanner) {
        System.out.print("Ingrese ID del departamento: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese nombre del departamento: ");
        String nombre = scanner.nextLine();

        Departamento departamento = new Departamento(id, nombre);
        departamentos.add(departamento);
        System.out.println("Departamento creado exitosamente.");
    }

    private static void asignarEmpleadoADepartamento(Scanner scanner) {
        System.out.print("Ingrese ID del empleado: ");
        String idEmpleado = scanner.nextLine();
        Empleado empleado = buscarEmpleadoPorId(idEmpleado);

        if (empleado != null) {
            System.out.print("Ingrese ID del departamento: ");
            String idDepartamento = scanner.nextLine();
            Departamento departamento = buscarDepartamentoPorId(idDepartamento);

            if (departamento != null) {
                empleado.asignarDepartamento(departamento);
                System.out.println("Empleado asignado al departamento exitosamente.");
            } else {
                System.out.println("Departamento no encontrado.");
            }
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void generarReporteIndividual(Scanner scanner) {
        System.out.print("Ingrese ID del empleado: ");
        String idEmpleado = scanner.nextLine();
        Empleado empleado = buscarEmpleadoPorId(idEmpleado);

        if (empleado != null) {
            ReporteDesempeno reporte = new ReporteDesempeno(empleado.getId(), "Excelente", "2023-10-01");
            reporte.generarReporteIndividual();
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void generarReporteDepartamento(Scanner scanner) {
        System.out.print("Ingrese ID del departamento: ");
        String idDepartamento = scanner.nextLine();
        Departamento departamento = buscarDepartamentoPorId(idDepartamento);

        if (departamento != null) {
            ReporteDesempeno reporte = new ReporteDesempeno(null, null, null);
            reporte.generarReporteDepartamento(departamento.getListaEmpleados());
        } else {
            System.out.println("Departamento no encontrado.");
        }
    }

    private static void visualizarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("\n--- Lista de Empleados ---");
            System.out.println("+------------+------------+------------+------------+------------+");
            System.out.println("| ID         | Nombre     | Apellido   | Tipo        | Departamento |");
            System.out.println("+------------+------------+------------+------------+------------+");
            for (Empleado empleado : empleados) {
                System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-12s |\n",
                        empleado.getId(), empleado.getNombre(), empleado.getApellido(),
                        empleado.getTipoEmpleado(), empleado.getDepartamento() != null ? empleado.getDepartamento().getNombre() : "Ninguno");
            }
            System.out.println("+------------+------------+------------+------------+------------+");
        }
    }

    private static void visualizarDepartamentos() {
        if (departamentos.isEmpty()) {
            System.out.println("No hay departamentos registrados.");
        } else {
            System.out.println("\n--- Lista de Departamentos ---");
            System.out.println("+------------+------------+");
            System.out.println("| ID         | Nombre     |");
            System.out.println("+------------+------------+");
            for (Departamento departamento : departamentos) {
                System.out.printf("| %-10s | %-10s |\n", departamento.getId(), departamento.getNombre());
            }
            System.out.println("+------------+------------+");
        }
    }

    private static Empleado buscarEmpleadoPorId(String id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId().equals(id)) {
                return empleado;
            }
        }
        return null;
    }

    private static Departamento buscarDepartamentoPorId(String id) {
        for (Departamento departamento : departamentos) {
            if (departamento.getId().equals(id)) {
                return departamento;
            }
        }
        return null;
    }
}

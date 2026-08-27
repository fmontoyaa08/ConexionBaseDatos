import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EstudianteDAO dao = new EstudianteDAO();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n========== MENÚ DE OPCIONES ==========");
            System.out.println("1. Insertar nuevo estudiante");
            System.out.println("2. Actualizar datos de estudiante existente");
            System.out.println("3. Consultar estudiantes activos");
            System.out.println("4. Consultar estudiantes inactivos (Nueva opción)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Carnet: ");
                    String carnet = sc.nextLine();
                    System.out.print("Estado (1 para Activo, 0 para Inactivo): ");
                    int activo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Tipo (Pregrado / Posgrado): ");
                    String tipo = sc.nextLine();
                    
                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    dao.insertarEstudiante(nombre, carnet, activo, tipo, edad);
                case 2:
                    System.out.print("ID del estudiante a actualizar: ");
                    int idActualizar = sc.nextInt();
                    System.out.print("Nuevo estado (1 para Activo, 0 para Inactivo): ");
                    int nuevoActivo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo tipo (Pregrado / Posgrado): ");
                    String nuevoTipo = sc.nextLine();
                    
                    dao.actualizarEstudiante(idActualizar, nuevoActivo, nuevoTipo);
                    break;

                case 3:
                    dao.consultarEstudiantesActivos();
                    break;

                case 4:
                    dao.consultarEstudiantesInactivos();
                    break;

                case 5:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
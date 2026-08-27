import java.sql.*;
import java.util.Scanner;

public class EstudianteDAO {
    private Connection conexion;

    public EstudianteDAO() {
        try {
            // Conexión a base de datos yarea5
            String url = "jdbc:mysql://localhost:3306/tarea5_db";
            String usuario = "root";
            String password = "monto123"; // 
            
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("¡Conexión exitosa a la Base de Datos!");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
    public void insertarEstudiante(String nombre, String carnet, int activo, String tipo, int edad) {
        String sql = "INSERT INTO estudiantes (nombre, carnet, activo, tipo, edad) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, carnet);
            stmt.setInt(3, activo);
            stmt.setString(4, tipo);
            stmt.setInt(5, edad);
            stmt.executeUpdate();
            System.out.println("-> Estudiante guardado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }
    // 2. Actualizar estudiantes existentes
    public void actualizarEstudiante(int id, int activo, String tipo) {
        String sql = "UPDATE estudiantes SET activo = ?, tipo = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, activo);
            stmt.setString(2, tipo);
            stmt.setInt(3, id);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("-> Estudiante actualizado con éxito.");
            } else {
                System.out.println("-> No se encontró estudiante con el ID ingresado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    // 3. Consultar SOLO estudiantes ACTIVOS (Requerimiento 3)
    public void consultarEstudiantesActivos() {
        String sql = "SELECT * FROM estudiantes WHERE activo = 1";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- LISTA DE ESTUDIANTES ACTIVOS ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + 
                                   " | Nombre: " + rs.getString("nombre") + 
                                   " | Carnet: " + rs.getString("carnet") + 
                                   " | Tipo: " + rs.getString("tipo"));
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }

    // 4. Consultar SOLO estudiantes INACTIVOS (Requerimiento 4 - Opción extra)
    public void consultarEstudiantesInactivos() {
        String sql = "SELECT * FROM estudiantes WHERE activo = 0";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- LISTA DE ESTUDIANTES INACTIVOS ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + 
                                   " | Nombre: " + rs.getString("nombre") + 
                                   " | Carnet: " + rs.getString("carnet") + 
                                   " | Tipo: " + rs.getString("tipo"));
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }
}

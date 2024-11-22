import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControlEstudiantes {
    private Conexion conexion = new Conexion();

    public void agregarEstudiante(Estudiante estudiante) {
        String sql = "INSERT INTO estudiantes (carnet, materias_inscritas, creditos_inscritos, monto_a_pagar) VALUES (?, ?, ?, ?)";
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, estudiante.getCarnet());
            ps.setInt(2, estudiante.getMateriasInscritas());
            ps.setInt(3, estudiante.getCreditosInscritos());
            ps.setDouble(4, estudiante.getMontoPagar());
            ps.executeUpdate();
            System.out.println("Estudiante registrado en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al agregar estudiante: " + e.getMessage());
        }
    }

    public void limpiarBaseDeDatos() {
        String sql = "DELETE FROM estudiantes";
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
            System.out.println("Todos los registros han sido eliminados de la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al limpiar la base de datos: " + e.getMessage());
        }
    }

    public String generarResumen() {
        // Este método genera un resumen ficticio, como ejemplo
        return "Resumen: Total estudiantes registrados en la base de datos.";
    }
}

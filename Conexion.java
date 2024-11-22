import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
   private static final String URL = "jdbc:mysql://localhost:3306/Universidad";
   private static final String USER = "root";
   private static final String PASSWORD = "042485";

   public Conexion() {
   }

   public Connection getConnection() {
      Connection var1 = null;

      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         var1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Universidad", "root", "042485");
         System.out.println("Conexi\u00f3n exitosa a la base de datos.");
      } catch (SQLException | ClassNotFoundException var3) {
         System.out.println("Error en la conexi\u00f3n: " + var3.getMessage());
      }

      return var1;
   }
}


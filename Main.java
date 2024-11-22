public static void main(String[] args) {
    Connection conexion = Conexion.getConexion();
    if (conexion != null) {
        System.out.println("La conexión fue exitosa.");
    } else {
        System.out.println("La conexión falló.");
    }
}

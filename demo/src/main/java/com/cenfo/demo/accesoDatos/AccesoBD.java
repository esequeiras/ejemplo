package com.cenfo.demo.accesoDatos;
import java.sql.*;
public class AccesoBD {
    private Connection conn = null;
    private Statement stmt = null;

    public AccesoBD(String url,String usuarioBD,String contrasennaBD) throws Exception {
        conn = DriverManager.getConnection(url, usuarioBD, contrasennaBD);
    }

    /**
     * Método que ejecuta las consultas al servidor de base de datos.
     * Debe invocarse si se ejecutan las operaciones de:INSERT,UPDATE,DELETE
     * @param query String con la consulta sql que se debe ejecutar en el servidor.
     * @throws SQLException Expceción SQL que indica los errores de base de datos.
     */
    public void ejecutarSQL(String query) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    /** Método que ejecuta las consultas al servidor de base de datos.
     * @param query String con la consulta sql que se debe ejecutar en el servidor
     * @return ResultSet con la información que se obtiene a partir de una consulta
     * de tipo SELECT
     * @throws SQLException
     */
    public ResultSet ejecutarQuery(String query) throws Exception {
        ResultSet rs = null;
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);

        return rs;
    }
}

package com.cenfo.demo.accesoDatos;

import com.cenfo.demo.modelo.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class UsuarioDao implements DaoInterface<Usuario> {
    private String sqlQuery="";
    @Override
    public String registar(Usuario us) throws Exception {
        try{
             sqlQuery="INSERT INTO Usuario VALUES"+
                    "('"+us.getNombre()+"','"+us.getEdad()+"','"+us.getPeso()+"','"+us.getAltura()+"','"+us.getImc()+"')";

            Conector.getConnector().ejecutarSQL(sqlQuery);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }
        return "Usuario registrado correctamente";
    }

    @Override
    public String modificar(Usuario us) throws Exception {
        //sqlQuery= "UPDATE Usuario SET nombre = '"+us.getNombre()+ "',contrasena='"+us.getContrasena()+"' WHERE identificacion ='" + us.getIdentificacion() +"'";
        //Conector.getConnector().ejecutarSQL(sqlQuery);
        return "Usuario modificado correctamente";
    }

    @Override
    public String eliminar(int id) throws Exception {
        sqlQuery= "DELETE from Usuario "+
                "WHERE identificacion ='" + id + "'";
        Conector.getConnector().ejecutarSQL(sqlQuery);
        return "Usuario eliminado correctamente";
    }

    @Override
    public ArrayList<Usuario> listar() throws Exception {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ResultSet rs = null;
        sqlQuery = "select * from Usuario";

        try {
            rs = Conector.getConnector().ejecutarQuery(sqlQuery);

            while (rs.next()) {

                String nombre= rs.getString("nombre");
                int id = (Integer.parseInt(rs.getString("Identificacion")));
                String correo= rs.getString("Correo");
                // lo parseo a local date ya que la base de datos me devuelve un date
                LocalDate fecha= LocalDate.parse(rs.getString("FechaNacimiento"));
                int edad=rs.getInt("edad");
                String cont=rs.getString("contrasena");
                String sex=rs.getString("sexo");


                //listaUsuarios.add(new Usuario(nombre,correo,id,fecha,edad,cont,sex));

            }

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaUsuarios;
    }
}

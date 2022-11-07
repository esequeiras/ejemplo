package com.cenfo.demo.controlador;

import com.cenfo.demo.accesoDatos.DaoInterface;
import com.cenfo.demo.accesoDatos.UsuarioDao;
import com.cenfo.demo.modelo.Usuario;

import java.util.ArrayList;

public class ControladorUsuario {
    private static DaoInterface datos;

    public ControladorUsuario(){

    }

    /**
     *
     * @param nombre variable que contiene el nombre del usuario
     * @param edad
     * @param altura
     * @param peso
     * @param imc
     * @return
     * @throws Exception
     */
    public static String registrarDatos(String nombre, int edad, double altura, double peso, double imc) throws Exception{
        if (datos==null){
            datos = new UsuarioDao();
        }
        Usuario usuario = new Usuario(nombre,edad,altura,peso,imc);
        return datos.registar(usuario);

    }
    public String modificarUsuario() throws Exception{
        Usuario usuario = new Usuario();
        return datos.modificar(usuario);
    }
    public String eliminarUsuario(int identificacion) throws Exception{
        return datos.eliminar(identificacion);
    }

    public ArrayList<Usuario> listarUsuarios() throws Exception {
        return datos.listar();
    }

}

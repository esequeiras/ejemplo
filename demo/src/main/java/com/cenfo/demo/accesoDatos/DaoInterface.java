package com.cenfo.demo.accesoDatos;

import java.util.ArrayList;

public interface DaoInterface<T> {
    String registar(T datos) throws Exception;
    String modificar(T datos) throws Exception;
    String eliminar(int id) throws Exception;
    ArrayList<T> listar()throws Exception;
}

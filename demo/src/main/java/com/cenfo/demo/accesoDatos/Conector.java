package com.cenfo.demo.accesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conector {
    private static AccesoBD  coneccionBD = null;

    public static  AccesoBD getConnector() throws Exception {
        String nombreBD = "proyecto";
        String ususrioBD = "root";
        String contrasennaBD = "root";
        String url = "jdbc:mysql://localhost:3306/"+nombreBD+"?serverTimezone=UTC";
        try {

            if(coneccionBD == null){
                coneccionBD = new AccesoBD(url,ususrioBD,contrasennaBD);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return coneccionBD;

    }

}

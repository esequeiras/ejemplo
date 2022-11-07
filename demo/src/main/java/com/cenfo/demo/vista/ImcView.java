package com.cenfo.demo.vista;

import com.cenfo.demo.controlador.ControladorUsuario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ImcView {
    @FXML
    private TextField nombre;
    @FXML
    private TextField edad;
    @FXML
    private TextField altura;
    @FXML
    private TextField peso;

    @FXML
    protected void guardarDatos() throws Exception {
       String nom=nombre.getText();
       int ed= Integer.parseInt(edad.getText());
       double alt=Double.parseDouble(altura.getText());
       double pes=Double.parseDouble(peso.getText());
       double imc=calcularIMC(alt,pes);

        ControladorUsuario.registrarDatos(nom,ed,alt,pes,imc);
        mensaje(String.valueOf(imc));
    }

    protected double calcularIMC(double altura,double peso) {
        return peso/Math.pow(altura,2);
    }
    public void mensaje(String texto){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("");
        alert.setContentText(String.valueOf(texto));
        alert.showAndWait();
    }

}
package com.calculadora_imc;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Objects;

public class CalculadoraIMC extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        var labelHeader = new Label("Calculadora de IMC");
        labelHeader.setMaxWidth(Double.MAX_VALUE);
        labelHeader.setAlignment(Pos.CENTER);
        labelHeader.getStyleClass().add("header");

        var labelPeso = new Label("Peso: ");
        labelPeso.getStyleClass().add("label");
        labelPeso.setPadding(new Insets(25));

        var inputPeso = new TextField();
        inputPeso.setPromptText("peso em kg.");
        inputPeso.getStyleClass().add("input");

        var hBoxPeso = new HBox(10, labelPeso, inputPeso);
        hBoxPeso.setAlignment(Pos.CENTER_LEFT);

        var labelAltura = new Label("Altura: ");
        labelAltura.getStyleClass().add("label");
        labelAltura.setPadding(new Insets(25));

        var inputAltura = new TextField();
        inputAltura.setPromptText("altura em metros.");
        inputAltura.getStyleClass().add("input");

        var hboxAltura = new HBox(10, labelAltura, inputAltura);
        hboxAltura.setAlignment(Pos.CENTER_LEFT);

        var labelResultado = new Label();
        labelResultado.getStyleClass().add("label");
        labelResultado.setPadding(new Insets(25));

        var calcularButton = new Button("Calcular");
        calcularButton.getStyleClass().add("button");

        calcularButton.setOnAction(e -> {
            double peso = Double.parseDouble(inputPeso.getText());
            double altura = Double.parseDouble(inputAltura.getText());
            double imc = peso / Math.pow(altura, 2);

            if (imc < 17){
                labelResultado.setText(String.format("Seu IMC é: %.2f \nMuito abaixo do peso.", imc));
            } else if (imc < 18.49) {
                labelResultado.setText(String.format("Seu IMC é: %.2f \nAbaixo do peso.", imc));
            } else if (imc < 24.99) {
                labelResultado.setText(String.format("Seu IMC é: %.2f \nPeso normal.", imc));
            } else if (imc < 29.99) {
                labelResultado.setText(String.format("Seu IMC é: %.2f \nAcima do peso", imc));
            } else if (imc < 34.99) {
                labelResultado.setText(String.format("Seu IMC é: %.2f \nObesidade I.", imc));
            } else if (imc < 39.99) {
                labelResultado.setText(String.format("Seu IMC é: %.2f \nObesidade II (severa).", imc));
            } else {
                labelResultado.setText(String.format("Seu IMC é: %.2f \nObesidade III (mórbida).", imc));
            }

            inputPeso.clear();
            inputAltura.clear();
        });

        var buttonBox = new HBox(calcularButton);
        buttonBox.setAlignment(Pos.CENTER);

        var vBox = new VBox(20, labelHeader, hBoxPeso, hboxAltura, buttonBox, labelResultado);
        vBox.setPadding(new Insets(0));
        vBox.getStyleClass().add("vbox");

        var scene = new Scene(vBox, 550, 450);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());

        primaryStage.setTitle("Calculadora de IMC");
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
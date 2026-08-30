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
        inputPeso.setPromptText("Informe seu peso em kg.");
        inputPeso.getStyleClass().add("input");
        inputPeso.setMaxWidth(Double.MAX_VALUE);

        var labelAltura = new Label("Altura: ");
        labelAltura.getStyleClass().add("label");
        labelAltura.setPadding(new Insets(25));

        var inputAltura = new TextField();
        inputAltura.setPromptText("Informe sua altura em metros.");
        inputAltura.getStyleClass().add("input");
        inputAltura.setMaxWidth(Double.MAX_VALUE);

        var labelResultado = new Label();
        labelResultado.getStyleClass().add("label");
        labelResultado.setPadding(new Insets(25));

        var buttonCalcular = new Button("Calcular");
        buttonCalcular.getStyleClass().add("button");

        buttonCalcular.setOnAction(e -> {
            try {
                double peso = Double.parseDouble(inputPeso.getText().replace(",", "."));
                double altura = Double.parseDouble(inputAltura.getText().replace(",", "."));

                if (peso <= 0 || altura <= 0){
                    labelResultado.setText("Peso e altura devem sem maiores do que 0");
                    inputPeso.clear();
                    inputAltura.clear();
                    return;
                }

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
            } catch (NumberFormatException ex) {
                labelResultado.setText("Entrada inválida! Insira apenas números");
            }

            inputPeso.clear();
            inputAltura.clear();
        });

        var layout = new GridPane();
        var coluna1 = new ColumnConstraints();
        var coluna2 = new ColumnConstraints();
        layout.getColumnConstraints().addAll(coluna1, coluna2);

        coluna1.setHalignment(HPos.RIGHT);
        coluna2.setHgrow(Priority.ALWAYS);

        layout.setPadding(new Insets(20));

        layout.addRow(0, labelHeader);
        layout.addRow(1, labelPeso, inputPeso);
        layout.addRow(2, labelAltura, inputAltura);
        layout.addRow(3, buttonCalcular);
        layout.addRow(4, labelResultado);

        GridPane.setColumnSpan(labelHeader, 2);
        GridPane.setHalignment(labelHeader, HPos.CENTER);

        GridPane.setHgrow(inputPeso, Priority.ALWAYS);
        GridPane.setHgrow(inputAltura, Priority.ALWAYS);

        GridPane.setColumnSpan(buttonCalcular, 2);
        GridPane.setHalignment(buttonCalcular, HPos.CENTER);

        GridPane.setColumnSpan(labelResultado, 2);
        GridPane.setHalignment(labelResultado, HPos.CENTER);

        var scene = new Scene(layout, 550, 400);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());

        primaryStage.setTitle("Calculadora de IMC");
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
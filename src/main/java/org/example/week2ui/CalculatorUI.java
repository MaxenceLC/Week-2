package org.example.week2ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Input fields
        TextField num1Input = new TextField();
        num1Input.setPromptText("Enter first number");
        GridPane.setConstraints(num1Input, 0, 0);

        TextField num2Input = new TextField();
        num2Input.setPromptText("Enter second number");
        GridPane.setConstraints(num2Input, 1, 0);

        // Buttons
        Button addButton = new Button("Add");
        GridPane.setConstraints(addButton, 0, 1);

        Button subtractButton = new Button("Subtract");
        GridPane.setConstraints(subtractButton, 1, 1);

        Button multiplyButton = new Button("Multiply");
        GridPane.setConstraints(multiplyButton, 0, 2);

        Button divideButton = new Button("Divide");
        GridPane.setConstraints(divideButton, 1, 2);

        // Result label
        Label resultLabel = new Label();
        GridPane.setConstraints(resultLabel, 0, 3, 2, 1);

        // Button actions
        addButton.setOnAction(e -> {
            double num1 = Double.parseDouble(num1Input.getText());
            double num2 = Double.parseDouble(num2Input.getText());
            double result = Calculator.add(num1, num2);
            resultLabel.setText("Result: " + result);
        });

        subtractButton.setOnAction(e -> {
            double num1 = Double.parseDouble(num1Input.getText());
            double num2 = Double.parseDouble(num2Input.getText());
            double result = Calculator.subtract(num1, num2);
            resultLabel.setText("Result: " + result);
        });

        multiplyButton.setOnAction(e -> {
            double num1 = Double.parseDouble(num1Input.getText());
            double num2 = Double.parseDouble(num2Input.getText());
            double result = Calculator.multiply(num1, num2);
            resultLabel.setText("Result: " + result);
        });

        divideButton.setOnAction(e -> {
            double num1 = Double.parseDouble(num1Input.getText());
            double num2 = Double.parseDouble(num2Input.getText());
            try {
                double result = Calculator.divide(num1, num2);
                resultLabel.setText("Result: " + result);
            } catch (IllegalArgumentException ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            }
        });

        grid.getChildren().addAll(num1Input, num2Input, addButton, subtractButton, multiplyButton, divideButton, resultLabel);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

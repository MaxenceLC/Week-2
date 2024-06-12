package org.example.calculatorfinal;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorUI extends Application {
    private TextField display;
    private Calculator calculator = new Calculator();
    private double num1 = 0;
    private String operator = "";
    private boolean start = true;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");

        display = new TextField();
        display.setEditable(false);
        display.setStyle("-fx-font-size: 24;");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(8);

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C", "+/-", "%"
        };

        int row = 1;
        int col = 0;
        for (String label : buttonLabels) {
            Button button = createButton(label);
            grid.add(button, col, row);
            col++;
            if (col > 3) {
                col = 0;
                row++;
            }
        }

        grid.add(display, 0, 0, 4, 1);

        Scene scene = new Scene(grid, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createButton(String label) {
        Button button = new Button(label);
        button.setStyle("-fx-font-size: 18;");
        button.setMinSize(60, 60);
        button.setOnAction(e -> processInput(label));
        return button;
    }

    private void processInput(String input) {
        if (input.matches("[0-9]") || input.equals(".")) {
            if (start) {
                display.clear();
                start = false;
            }
            display.appendText(input);
        } else {
            switch (input) {
                case "C":
                    display.clear();
                    num1 = 0;
                    operator = "";
                    start = true;
                    break;
                case "+/-":
                    double currentValue = Double.parseDouble(display.getText());
                    display.setText(String.valueOf(currentValue * -1));
                    break;
                case "%":
                    num1 = Double.parseDouble(display.getText());
                    display.clear();
                    operator = "%";
                    start = true;
                    break;
                case "=":
                    double operand2 = Double.parseDouble(display.getText());
                    double result = calculator.calculate(num1, operand2, operator);
                    display.setText(String.valueOf(result));
                    operator = "";
                    start = true;
                    break;
                default:
                    if (!operator.isEmpty()) {
                        operand2 = Double.parseDouble(display.getText());
                        num1 = calculator.calculate(num1, operand2, operator);
                        display.setText(String.valueOf(num1));
                    } else {
                        num1 = Double.parseDouble(display.getText());
                    }
                    display.clear();
                    operator = input;
                    start = true;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

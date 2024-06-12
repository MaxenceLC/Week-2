package org.example.minetmaxfinal;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class MinETMaxUI extends Application {
    private TextField inputField;
    private Label resultLabel;
    private MinETMax minMaxCalculator = new MinETMax();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Min et Max");

        // Title
        Label titleLabel = new Label("Min et Max Calculator");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        titleLabel.setPadding(new Insets(10, 0, 20, 0));

        // Input Field
        Label inputLabel = new Label("Enter numbers separated by commas:");
        inputField = new TextField();
        inputField.setPromptText("e.g. 1,2,3,4,5");
        inputField.setPrefWidth(300);

        // Buttons
        Button minButton = new Button("Min");
        minButton.setMinWidth(100);
        minButton.setOnAction(e -> calculateMin());

        Button maxButton = new Button("Max");
        maxButton.setMinWidth(100);
        maxButton.setOnAction(e -> calculateMax());

        HBox buttonBox = new HBox(20); // Adding spacing between buttons
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(minButton, maxButton);

        // Result Label
        resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: blue;");
        resultLabel.setPadding(new Insets(20, 0, 0, 0));

        // Layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(inputLabel, 0, 0, 2, 1);
        gridPane.add(inputField, 0, 1, 2, 1);
        gridPane.add(buttonBox, 0, 2, 2, 1); // Adding the buttonBox here
        gridPane.add(resultLabel, 0, 3, 2, 1);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.getChildren().addAll(titleLabel, gridPane);

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateMin() {
        double[] numbers = parseInput(inputField.getText());
        if (numbers != null) {
            double min = minMaxCalculator.min(numbers);
            resultLabel.setText("Min: " + min);
        } else {
            resultLabel.setText("Invalid input! Please enter numbers separated by commas.");
        }
    }

    private void calculateMax() {
        double[] numbers = parseInput(inputField.getText());
        if (numbers != null) {
            double max = minMaxCalculator.max(numbers);
            resultLabel.setText("Max: " + max);
        } else {
            resultLabel.setText("Invalid input! Please enter numbers separated by commas.");
        }
    }

    private double[] parseInput(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

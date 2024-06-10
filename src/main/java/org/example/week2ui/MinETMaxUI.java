package org.example.week2ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Arrays;

public class MinETMaxUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Min & Max Finder");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Input field
        TextField numbersInput = new TextField();
        numbersInput.setPromptText("Enter numbers separated by commas");
        GridPane.setConstraints(numbersInput, 0, 0, 2, 1);

        // Buttons
        Button findMinButton = new Button("Find Min");
        GridPane.setConstraints(findMinButton, 0, 1);

        Button findMaxButton = new Button("Find Max");
        GridPane.setConstraints(findMaxButton, 1, 1);

        // Result labels
        Label resultLabel = new Label();
        GridPane.setConstraints(resultLabel, 0, 2, 2, 1);

        // Button actions
        findMinButton.setOnAction(e -> {
            try {
                String input = numbersInput.getText();
                int[] numbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int min = MinETMax.findMin(numbers);
                resultLabel.setText("Min: " + min);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input. Please enter numbers separated by commas.");
            }
        });

        findMaxButton.setOnAction(e -> {
            try {
                String input = numbersInput.getText();
                int[] numbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int max = MinETMax.findMax(numbers);
                resultLabel.setText("Max: " + max);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input. Please enter numbers separated by commas.");
            }
        });

        grid.getChildren().addAll(numbersInput, findMinButton, findMaxButton, resultLabel);

        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

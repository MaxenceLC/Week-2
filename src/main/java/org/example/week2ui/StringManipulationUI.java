package org.example.week2ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StringManipulationUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("String Manipulation");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Input field
        TextField inputField = new TextField();
        inputField.setPromptText("Enter a string");
        GridPane.setConstraints(inputField, 0, 0, 2, 1);

        // Buttons
        Button toUpperCaseButton = new Button("To Upper Case");
        GridPane.setConstraints(toUpperCaseButton, 0, 1);

        Button toLowerCaseButton = new Button("To Lower Case");
        GridPane.setConstraints(toLowerCaseButton, 1, 1);

        Button reverseStringButton = new Button("Reverse String");
        GridPane.setConstraints(reverseStringButton, 0, 2, 2, 1);

        // Result label
        Label resultLabel = new Label();
        GridPane.setConstraints(resultLabel, 0, 3, 2, 1);

        // Button actions
        toUpperCaseButton.setOnAction(e -> {
            String input = inputField.getText();
            String result = StringManipulation.toUpperCase(input);
            resultLabel.setText("Result: " + result);
        });

        toLowerCaseButton.setOnAction(e -> {
            String input = inputField.getText();
            String result = StringManipulation.toLowerCase(input);
            resultLabel.setText("Result: " + result);
        });

        reverseStringButton.setOnAction(e -> {
            String input = inputField.getText();
            String result = StringManipulation.reverseString(input);
            resultLabel.setText("Result: " + result);
        });

        grid.getChildren().addAll(inputField, toUpperCaseButton, toLowerCaseButton, reverseStringButton, resultLabel);

        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

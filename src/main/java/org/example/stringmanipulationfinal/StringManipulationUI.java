package org.example.stringmanipulationfinal;

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

            public class StringManipulationUI extends Application {
                private TextField inputField;
                private Label resultLabel;
                private StringManipulation stringManipulator = new StringManipulation();

                @Override
                public void start(Stage primaryStage) {
                    primaryStage.setTitle("String Manipulation");

                    // Title
                    Label titleLabel = new Label("String Manipulation");
                    titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
                    titleLabel.setPadding(new Insets(10, 0, 20, 0));

                    // Input Field
                    Label inputLabel = new Label("Enter a string:");
                    inputField = new TextField();
                    inputField.setPromptText("e.g. Hello World");
                    inputField.setPrefWidth(300);

                    // Buttons
                    Button upperCaseButton = new Button("To Uppercase");
                    upperCaseButton.setMinWidth(100);
                    upperCaseButton.setOnAction(e -> convertToUpperCase());

                    Button lowerCaseButton = new Button("To Lowercase");
                    lowerCaseButton.setMinWidth(100);
                    lowerCaseButton.setOnAction(e -> convertToLowerCase());

                    Button reverseButton = new Button("Reverse");
                    reverseButton.setMinWidth(100);
                    reverseButton.setOnAction(e -> reverseString());

                    HBox buttonBox = new HBox(20); // Adding spacing between buttons
                    buttonBox.setAlignment(Pos.CENTER);
                    buttonBox.getChildren().addAll(upperCaseButton, lowerCaseButton, reverseButton);

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
                    gridPane.add(inputLabel, 0, 0, 3, 1);
                    gridPane.add(inputField, 0, 1, 3, 1);
                    gridPane.add(buttonBox, 0, 2, 3, 1); // Adding the buttonBox here
                    gridPane.add(resultLabel, 0, 3, 3, 1);

                    VBox vbox = new VBox(10);
                    vbox.setPadding(new Insets(20));
                    vbox.setAlignment(Pos.TOP_CENTER);
                    vbox.getChildren().addAll(titleLabel, gridPane);

                    Scene scene = new Scene(vbox, 400, 300);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                }

                private void convertToUpperCase() {
                    String input = inputField.getText();
                    if (!input.isEmpty()) {
                        String upperCase = stringManipulator.toUpperCase(input);
                        resultLabel.setText("Uppercase: " + upperCase);
                    } else {
                        resultLabel.setText("Invalid input! Please enter a string.");
                    }
                }

                private void convertToLowerCase() {
                    String input = inputField.getText();
                    if (!input.isEmpty()) {
                        String lowerCase = stringManipulator.toLowerCase(input);
                        resultLabel.setText("Lowercase: " + lowerCase);
                    } else {
                        resultLabel.setText("Invalid input! Please enter a string.");
                    }
                }

                private void reverseString() {
                    String input = inputField.getText();
                    if (!input.isEmpty()) {
                        String reversed = stringManipulator.reverse(input);
                        resultLabel.setText("Reversed: " + reversed);
                    } else {
                        resultLabel.setText("Invalid input! Please enter a string.");
                    }
                }

                public static void main(String[] args) {
                    launch(args);
                }
            }

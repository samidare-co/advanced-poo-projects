package com.example.calculator;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Calculator extends Application {
    private StringBuilder inputBuffer = new StringBuilder();
    private String currentOperator = "";
    private double result = 0;

    private Label display;

      @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(5);
        grid.setVgap(5);

        display = new Label("0");
        display.setPrefSize(150, 30);

        Button[] digitButtons = new Button[10];
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new Button(Integer.toString(i));
            digitButtons[i].setPrefSize(50, 30);
            final int digit = i;
            digitButtons[i].setOnAction(event -> onDigitClick(digit));
            if (i ==0){
                grid.add(digitButtons[i], 0, 4, 1,1 );
            }
            else if (i!=0)
            grid.add(digitButtons[i], (i-1)%3, ((i-1)/3) + 1,1,1) ;
        }
    Button deleteButton = createOperatorButton("C");
        Button pointButton = createOperatorButton(".");
        Button addButton = createOperatorButton("+");
        Button subtractButton = createOperatorButton("-");
        Button multiplyButton = createOperatorButton("*");
        Button divideButton = createOperatorButton("/");
        Button equalsButton = createOperatorButton("=");
        equalsButton.setOnAction(event -> onEqualsClick());
display.setMaxWidth(Double.MAX_VALUE);
        display.setAlignment(Pos.BASELINE_RIGHT);

        deleteButton.setOnAction(event->onDeleteClick());
        grid.add(display, 0, 0, 5, 1);
        grid.add(deleteButton, 4,1,1,1) ;
        grid.add(pointButton, 1,4,1,1);
grid.add(addButton, 4,2,1,1);
grid.add(subtractButton, 4,3,1,1);
grid.add(multiplyButton, 4,4,1,1);
grid.add(divideButton, 4,5,1,1);
grid.add(equalsButton, 2,4,1,1);
        //grid.addColumn(3,equalsButton, digitButtons[3]);
         // grid.addRow(1, digitButtons[1], digitButtons[2], digitButtons[3], multiplyButton);
          //grid.addRow(2, digitButtons[4], digitButtons[5], digitButtons[6], subtractButton);
       // grid.addRow(3, digitButtons[7], digitButtons[8], digitButtons[9], addButton);
        //grid.addRow(4, digitButtons[0], equalsButton, divideButton);

        Scene scene = new Scene(grid, 210, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        private Button createOperatorButton(String operator) {
            Button button = new Button(operator);
            button.setPrefSize(50, 30);
            button.setOnAction(event -> onOperatorClick(operator));
            return button;
        }
    private void onDigitClick(int digit) {
        inputBuffer.append(digit);
        updateDisplay();
    }
    private void onDeleteClick(){
          display.setText("0"); ;
          result= 0 ;
          currentOperator = "";
          inputBuffer = new StringBuilder();
    }

    private void onOperatorClick(String operator) {
        if (inputBuffer.length() > 0) {
            if (!currentOperator.isEmpty()) {
                onEqualsClick();
            }
            currentOperator = operator;
            result = Double.parseDouble(inputBuffer.toString());
            inputBuffer.setLength(0);
        }
    }

    private void onEqualsClick() {
        if (inputBuffer.length() > 0) {
            double operand = Double.parseDouble(inputBuffer.toString());
            switch (currentOperator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                case "*":
                    result *= operand;
                    break;
                case "/":
                    if (operand != 0) {
                        result /= operand;
                    } else {
                        inputBuffer.setLength(0);
                        inputBuffer.append("Error");
                        updateDisplay();
                        return;
                    }
                    break;
            }
            inputBuffer.setLength(0);
            inputBuffer.append(result);
            currentOperator = "";
            updateDisplay();
        }
    }

    private void updateDisplay() {
        String displayText = inputBuffer.length() > 0 ? inputBuffer.toString() : Double.toString(result);
        displayText = displayText.length() > 10 ? displayText.substring(0, 10) : displayText;
        display.setText(displayText);
    }
    public static void main(String[] args) {
        launch();
    }
}
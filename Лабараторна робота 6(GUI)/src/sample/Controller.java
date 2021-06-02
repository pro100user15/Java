package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;

public class Controller {

    @FXML
    private Label result;

    @FXML
    private TextField fieldX;

    @FXML
    private Button button1;

    @FXML
    private TextField fieldNomer;

    @FXML
    private Button button2;

    public void button1_click(javafx.event.ActionEvent event) {
        try {
            result.setText(Task.task1(fieldX.getText()));
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Лабараторна робота №6");
            alert.setHeaderText("Увага :");
            alert.setContentText(ex.getMessage());
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        }
        fieldX.setText("");
    }

    public void button2_click(ActionEvent event) {
        try {
            String line = Task.task2(fieldNomer.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Лабараторна робота №6");
            alert.setHeaderText("Завдання 2 :");
            alert.setContentText(line);
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Лабараторна робота №6");
            alert.setHeaderText("Увага :");
            alert.setContentText(ex.getMessage());
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        }
        fieldNomer.setText("");
    }
}

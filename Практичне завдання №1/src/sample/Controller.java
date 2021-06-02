package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Button button;

    @FXML
    private TextField field_a;

    @FXML
    private TextField field_b;

    @FXML
    private TextField field_c;

    //22 Алгоритм, який серед заданих трьох чисел a, b, c знаходить максимальне.
    @FXML
    public void button_click(ActionEvent event) {
        try {
            if (field_a.getText().equals("") || field_a.getText().equals("") || field_a.getText().equals(""))
                throw new IllegalArgumentException("Введіть число!");

            if (!field_a.getText().matches("\\d+") || !field_a.getText().matches("\\d+") || !field_a.getText().matches("\\d+"))
                throw new IllegalArgumentException("Введіть число!");


            int a = Integer.parseInt(field_a.getText());
            int b = Integer.parseInt(field_b.getText());
            int c = Integer.parseInt(field_c.getText());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Практичне завдання №1");
            alert.setHeaderText("Завдання :");

            if(a > b) {
                if(a > c)
                    alert.setContentText("'a' — найбільше число!");
                else alert.setContentText("'c' — найбільше число!");
            }else if(b > c)
                alert.setContentText("'b' — найбільше число!");
            else alert.setContentText("'c' — найбільше число!");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        }
        catch (IllegalArgumentException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Практичне завдання №1");
            alert.setHeaderText("Завдання :");
            alert.setContentText(ex.getMessage());
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        }
    }
}

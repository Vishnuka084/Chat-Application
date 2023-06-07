package lk.ijse.play_tech.ChatApp.Controller;


import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginForm1Controller {

    public AnchorPane loginContext;
    public JFXTextField txtName;
    public static String name;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        name = txtName.getText();
        loginContext.getChildren().clear();
        Stage stage = (Stage) loginContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ClientForm1.fxml"))));
    }
}

package java.fr.univ_amu.iut.exercice2;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class LoginControl extends GridPane {
    @FXML
    private TextField userId;

    @FXML
    private PasswordField pwd;

    public LoginControl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/fr/univ_amu/iut/exercice2/LoginView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    private void initialize() {
        getStylesheets().add(getClass().getClassLoader().getResource("Login.css").toExternalForm());
    }

    @FXML
    private void okClicked() {
        System.out.println("Ok cliked");
    }

    @FXML
    private void cancelClicked() {
        System.out.println("Cancel cliked");
    }

    public String getUserId() {
        return userId.getText();
    }

    public StringProperty userIdProperty() {
        return userId.textProperty();
    }

    public String getPassword() {
        return pwd.getText();
    }

    public StringProperty passwordProperty() {
        return pwd.styleProperty();
    }
}
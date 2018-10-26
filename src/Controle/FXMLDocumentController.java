package Controle;

import Persistencia.PVendedor;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import Principal.SoftwareCrediario;
import com.jfoenix.controls.JFXPasswordField;

public class FXMLDocumentController implements Initializable {

    @FXML
    private BorderPane borda;

    @FXML
    private JFXTextField userVendedor;

    @FXML
    private JFXButton entrar;

    @FXML
    private JFXButton cadastrar;
    @FXML
    private JFXPasswordField senha;
    @FXML
    private JFXButton teste;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void entrar() throws IOException {
        PVendedor con = new PVendedor();
        if (con.LoginFromVendedor(userVendedor.getText(), senha.getText()) == true) {
            mudarTela2();
        }
    }

    @FXML
    private void mudarTela() throws IOException {
        Parent CadastroVendedor = FXMLLoader.load(getClass().getResource("/Visao/CadastroVendedor.fxml"));
        Scene scene = new Scene(CadastroVendedor);
        SoftwareCrediario.getStagePrincipal().setScene(scene);
    }

    @FXML
    private void mudarTela2() throws IOException {
        Parent Menu = FXMLLoader.load(getClass().getResource("/Visao/Menu.fxml"));
        Scene scene = new Scene(Menu);
        SoftwareCrediario.getStagePrincipal().setScene(scene);
    }
}

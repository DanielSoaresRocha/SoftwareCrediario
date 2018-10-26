package Controle;


import Persistencia.PVendedor;
import Principal.SoftwareCrediario;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
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

public class CadastroVendedorController2 implements Initializable {

    @FXML
    private BorderPane borda2;

    @FXML
    private JFXTextField nome;
    @FXML
    private JFXTextField cpf;

    @FXML
    private JFXButton cadastrar;
    @FXML
    private JFXButton voltar;
    @FXML
    private JFXPasswordField senha;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void cadastrarVendedor() {    
        int i = Integer.parseInt(cpf.getText());
        PVendedor con = new PVendedor();
        System.out.println(nome.getText());
        System.out.println(senha.getText());
        System.out.println(i);
        con.insertIntoVendedor(nome.getText(), i, senha.getText());
 
    }

    @FXML
    private void voltar() throws IOException {
        Parent TelaInicial = FXMLLoader.load(getClass().getResource("/Visao/FXMLDocument.fxml"));
        Scene scene = new Scene(TelaInicial);
        SoftwareCrediario.getStagePrincipal().setScene(scene);
    }

}

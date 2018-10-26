package Controle;

import Principal.SoftwareCrediario;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class MenuController implements Initializable {
    @FXML
    private JFXButton logoff;
    @FXML
    private Label labelPrincipal;
    @FXML
    private JFXButton consultarClientes;
    @FXML
    private JFXButton realizarVenda;
    @FXML
    private JFXButton cobrancas;
    @FXML
    private BorderPane bordaPrincipal;
    @FXML
    private AnchorPane anchorInicial;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void CadastrarClientes() {
        try {
            Parent CadastroCliente = FXMLLoader.load(getClass().getResource("/Visao/CadastroCliente.fxml"));
            bordaPrincipal.setCenter(CadastroCliente);
            labelPrincipal.setText("CADASTRAR CLIENTES");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    @FXML
    private void ConsultarClientes() {
        try {
            Parent ConsultaCliente = FXMLLoader.load(getClass().getResource("/Visao/ConsultaCliente.fxml"));
            bordaPrincipal.setCenter(ConsultaCliente);
            labelPrincipal.setText("CONSULTAR CLIENTES");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    
    @FXML
    private void Sair() throws IOException {
        Parent TelaInicial = FXMLLoader.load(getClass().getResource("/Visao/FXMLDocument.fxml"));
        Scene scene = new Scene(TelaInicial);
        SoftwareCrediario.getStagePrincipal().setScene(scene);
    }
}

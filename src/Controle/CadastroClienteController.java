package Controle;

import Persistencia.PCliente;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

public class CadastroClienteController implements Initializable {

    @FXML
    private JFXTextField cliente;
    @FXML
    private JFXTextField cpf;
    @FXML
    private JFXTextField endereco;
    @FXML
    private JFXTextField numero;
    @FXML
    private JFXTextField nomeMae;
    @FXML
    private JFXButton cadastrar;
    @FXML
    private JFXButton limpar;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //cliente.setVisible(false);
    }

    public void aviso() {
        alert.setTitle("Atenção");
        alert.setHeaderText("Não foi possível cadastrar o cliente");
        alert.setContentText("Verifique se algum campo obrigatório está em branco");
        alert.showAndWait();
    }

    @FXML
    private void limpar() {
        cliente.setText("");
        cpf.setText("");
        endereco.setText("");
        numero.setText("");
        nomeMae.setText("");
    }

    @FXML
    public void cadastraCliente() {
        System.out.println(endereco);
        PCliente con = new PCliente();
        //int i = Integer.parseInt(cpf.getText());
        //int j = Integer.parseInt(numero.getText());

        if (cliente.getText().isEmpty()) {
            aviso();
        } else if (endereco.getText().isEmpty()) {
            aviso();
        } else if (numero.getText().isEmpty()) {
            aviso();
        } else if (con.insertIntoCliente(cliente.getText(), cpf.getText(), endereco.getText(), numero.getText(), nomeMae.getText()) == true) {
            alert.setTitle("Atenção");
            alert.setHeaderText("O Cliente " + cliente.getText() + " foi adicionado com sucesso!");
            alert.showAndWait();

            limpar();
        }

    }
}

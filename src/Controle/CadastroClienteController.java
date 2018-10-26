package Controle;

import Persistencia.PCliente;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void cadastraCliente() {
        PCliente con = new PCliente();
        int i = Integer.parseInt(cpf.getText());
        int j = Integer.parseInt(numero.getText());
        System.out.println(cliente.getText());
        System.out.println(i);
        System.out.println(endereco.getText());
        System.out.println(j);
        System.out.println(nomeMae.getText());
        con.insertIntoCliente(cliente.getText(), i , endereco.getText(), j, nomeMae.getText());
    }
}

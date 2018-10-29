package Controle;

import Modelo.Cliente;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class EditarClienteController implements Initializable {

    @FXML
    private JFXTextField nome;
    @FXML
    private JFXTextField cpf;
    
    Cliente c2;
    @FXML
    private JFXTextField endereco;
    @FXML
    private JFXTextField telefone;
    @FXML
    private JFXTextField nomeMae;
    /**
     * Initializes the controller class.
     */
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c2 = ConsultaClienteController.c1.c2;
        nome.setText(c2.getNome());
        String i = String.valueOf(c2.getCpf());
        cpf.setText(i);
    }    
    
}

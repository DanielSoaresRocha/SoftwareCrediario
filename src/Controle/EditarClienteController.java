package Controle;

import Modelo.Cliente;
import Persistencia.PCliente;
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
    @FXML
    private JFXTextField endereco;
    @FXML
    private JFXTextField telefone;
    @FXML
    private JFXTextField nomeMae;
    
    PCliente c = new PCliente();
    Cliente c2;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c2 = ConsultaClienteController.c1.c2;
        nome.setText(c2.getNome());
        String i = String.valueOf(c2.getCpf());
        cpf.setText(i);
        endereco.setText(c2.getEndereco());
        i = String.valueOf(c2.getNumero());
        telefone.setText(i);
        nomeMae.setText(c2.getNomeMae());
    }    
    
    public void salvar(){
        int cpff = Integer.parseInt(cpf.getText());
        int telefonee = Integer.parseInt(telefone.getText());
        c.editCliente(c2, nome.getText(),cpff, endereco.getText(), telefonee, nomeMae.getText());
        //ConsultaClienteController.atualizar();
    }
}

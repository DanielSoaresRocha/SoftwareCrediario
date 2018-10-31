package Controle;

import Modelo.Cliente;
import Persistencia.PCliente;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;


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
    @FXML
    private JFXButton salvar;
    @FXML
    private JFXButton cancelar;
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
    
    @FXML
    public void salvar(){
        int cpff = Integer.parseInt(cpf.getText());
        int telefonee = Integer.parseInt(telefone.getText());
        c.editCliente(c2, nome.getText(),cpff, endereco.getText(), telefonee, nomeMae.getText());
        ConsultaClienteController.c1.stage.close();
        MenuController.menu.ConsultarClientes();
//ConsultaClienteController.atualizar();
    }

    @FXML
    private void sair(ActionEvent event) {
        ConsultaClienteController.c1.stage.close();
        /*
        Outro método  
        Stage s = (Stage)cancelar.getScene().getWindow();
        s.close();
          */      
    }
}

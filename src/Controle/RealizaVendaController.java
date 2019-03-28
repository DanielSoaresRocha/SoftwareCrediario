package Controle;

import Modelo.Cliente;
import Persistencia.PVenda;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

public class RealizaVendaController implements Initializable {

    @FXML
    private JFXTextField nomeCliente;
    @FXML
    private JFXTextField nomeMercadoria;
    @FXML
    private JFXTextField valorMercadoria;
    @FXML
    private JFXTextField numParcelas;
    @FXML
    private JFXTextField valorParcelas;
    @FXML
    private JFXDatePicker dataVenda;
    @FXML
    private JFXButton confirmar;
    @FXML
    private JFXButton cancelar;

    Cliente c;
    PVenda v = new PVenda();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c = ConsultaClienteController.c1.c2;
        nomeCliente.setText(c.getNome());

    }

    
    public void limpar(){
        nomeCliente.setText("");
        nomeMercadoria.setText("");
        valorMercadoria.setText("");
        valorParcelas.setText("");
        numParcelas.setText("");
        dataVenda.setValue(null);
    }
    
    @FXML
    public void cancelar() {
        MenuController.menu.ConsultarClientes();
    }

    @FXML
    public void confirmar() {
        System.out.println("nome da m: " + nomeMercadoria);
        if (nomeMercadoria == null) {
            ConsultaClienteController.c1.aviso();
         
        } else {
            Date date = java.sql.Date.valueOf(dataVenda.getValue());
            double valorM = Double.parseDouble(valorMercadoria.getText());
            int numP = Integer.parseInt(numParcelas.getText());
            double valorP = Double.parseDouble(valorParcelas.getText());
            v.insertIntoVenda("nao",nomeMercadoria.getText(), valorM, numP, valorP, date, date, 0, c.getIdCliente());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText("Venda Realizada com sucesso");
            //alert.setContentText("Venda concluida");
            alert.showAndWait();
            limpar();

        }
    }
}

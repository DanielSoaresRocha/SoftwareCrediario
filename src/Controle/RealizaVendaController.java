package Controle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

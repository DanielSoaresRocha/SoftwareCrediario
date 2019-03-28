package Controle;

import Modelo.Pendencias;
import Persistencia.PVenda;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class ConfirmaVendaController implements Initializable {

    @FXML
    private Label nomeCliente;
    @FXML
    private Label nomeMercadoria;
    @FXML
    private JFXCheckBox status;
    @FXML
    private JFXTextField vPago;
    @FXML
    private JFXDatePicker data;
    @FXML
    private JFXButton salvar;
    @FXML
    private JFXButton cancelar;

    Pendencias p2;
    PVenda p = new PVenda();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p2 = PendenciasController.p1.p;
        nomeCliente.setText(p2.getNome());
        nomeMercadoria.setText(p2.getNomeMercadoria());
        String VM = String.valueOf(p2.getMensalidade());
        vPago.setText(VM);

    }

    @FXML
    private void salvar(ActionEvent event) throws IOException {
        if (vPago.getText().isEmpty()) {
            PendenciasController.p1.aviso();
        } else if (data.getValue() == null) {
            PendenciasController.p1.aviso();
        } else {

            double vp = Double.parseDouble(vPago.getText());
            Date date = java.sql.Date.valueOf(data.getValue());
            if (p.confirmaVenda(p2, vp, date) == true) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Atenção");
                alert.setHeaderText("A venda de " + p2.getNome() + " foi\nconfirmada com sucesso!!");
                //alert.setContentText("Verifique se algum campo está em branco");
                alert.showAndWait();
                
                PendenciasController.p1.stage.close();
                MenuController.menu.Pendencias();
            }
        }

    }

    @FXML
    private void sair(ActionEvent event) {
        PendenciasController.p1.stage.close();
    }

}

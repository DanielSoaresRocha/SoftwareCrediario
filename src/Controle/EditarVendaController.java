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

public class EditarVendaController implements Initializable {

    @FXML
    private JFXCheckBox status;
    @FXML
    private JFXTextField mercadoria;
    @FXML
    private JFXTextField vMercadoria;
    @FXML
    private JFXTextField vParcelas;
    @FXML
    private JFXTextField valorP;
    @FXML
    private JFXDatePicker data;
    @FXML
    private JFXDatePicker dataCobranca;
    @FXML
    private JFXButton salvar;
    @FXML
    private JFXButton cancelar;
    @FXML
    private JFXTextField numParcelas;

    Pendencias p2;
    PVenda p = new PVenda();
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p2 = PendenciasController.p1.p;
        String VT = String.valueOf(p2.getValorTotal());
        String VP = String.valueOf(p2.getMensalidade());
        String VP2 = String.valueOf(p2.getValorPago());
        vMercadoria.setText(VT);
        vParcelas.setText(VP);
        valorP.setText(VP2);
        mercadoria.setText(p2.getNomeMercadoria());
        //Date date = java.sql.Date.valueOf(data.getValue());
        
        System.out.println(data.getValue());
    }

    @FXML
    private void salvar(ActionEvent event) throws IOException {
        if (numParcelas.getText().isEmpty()) {
            PendenciasController.p1.aviso();
        } else if (data.getValue() == null) {
            PendenciasController.p1.aviso();
        } else {
            double vt = Double.parseDouble(vMercadoria.getText());
            int np = Integer.parseInt(numParcelas.getText());
            double vp = Double.parseDouble(vParcelas.getText());
            Date date = java.sql.Date.valueOf(data.getValue());
            Date date2 = java.sql.Date.valueOf(dataCobranca.getValue());
            double vp2 = Double.parseDouble(valorP.getText());
            System.out.println(data.getValue().getDayOfYear());
            if (p.editVenda(p2, "sim", mercadoria.getText(), vt, np, vp, date, date2, vp2) == true) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Atenção");
                alert.setHeaderText("A venda de " + p2.getNome() + " foi\neditada com sucesso!!");
                //alert.setContentText("Verifique se algum campo está em branco");
                alert.showAndWait();
            }

            PendenciasController.p1.stage.close();
            MenuController.menu.Pendencias();
        }
    }

    @FXML
    private void sair(ActionEvent event) throws IOException {
        PendenciasController.p1.stage.close();
    }

}

package Controle;

import static Controle.ConsultaClienteController.lista;
import Modelo.Pendencias;
import Persistencia.PVenda;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PendenciasController implements Initializable {

    static ObservableList<Pendencias> listaP = FXCollections.observableArrayList();

    @FXML
    private TableView<Pendencias> tableViewP;
    //@FXML
    //private TableColumn<Pendencias, Integer> idColum;
    @FXML
    private TableColumn<Pendencias, Date> dataVendaColum;
    @FXML
    private TableColumn<Pendencias, Date> dataCobrancaColum;
    @FXML
    private TableColumn<Pendencias, String> nomeColum;
    @FXML
    private TableColumn<Pendencias, String> mercadoriaColum;
    @FXML
    private TableColumn<Pendencias, Double> valorTColum;
    @FXML
    private TableColumn<Pendencias, Double> valorPColum;
    @FXML
    private TableColumn<Pendencias, Double> valorRColum;
    @FXML
    private TableColumn<Pendencias, Double> mensalidadeColum;
    @FXML
    private JFXButton buscar;
    @FXML
    private JFXDatePicker dataV;
    @FXML
    private JFXButton editaInformacao;
    @FXML
    private JFXButton confirmaCobranca;
    @FXML
    private JFXButton excluir;
    @FXML
    private Label totalVenda;
    @FXML
    private Label cobraHoje;
    @FXML
    private JFXTextField nomeC;
    @FXML
    private JFXTextField nomeM;

    static PendenciasController p1;
    Stage stage = new Stage();
    PVenda c = new PVenda();
    Pendencias p;
    String str = String.valueOf(c.somaTotalVenda());
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p1 = this;
        //idColum.setCellValueFactory(new PropertyValueFactory<Pendencias, Integer>("id"));
        dataVendaColum.setCellValueFactory(new PropertyValueFactory<Pendencias, Date>("dataVenda"));
        dataCobrancaColum.setCellValueFactory(new PropertyValueFactory<Pendencias, Date>("dataCobranca"));
        nomeColum.setCellValueFactory(new PropertyValueFactory<Pendencias, String>("nome"));
        mercadoriaColum.setCellValueFactory(new PropertyValueFactory<Pendencias, String>("nomeMercadoria"));
        valorTColum.setCellValueFactory(new PropertyValueFactory<Pendencias, Double>("valorTotal"));
        valorPColum.setCellValueFactory(new PropertyValueFactory<Pendencias, Double>("valorPago"));
        valorRColum.setCellValueFactory(new PropertyValueFactory<Pendencias, Double>("valorRestante"));
        mensalidadeColum.setCellValueFactory(new PropertyValueFactory<Pendencias, Double>("mensalidade"));

        listaP.clear();
        listaP.addAll(c.listVenda());
        tableViewP.setItems(listaP);

        totalVenda.setText(str);

    }

    public void aviso() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Atenção");
        alert.setHeaderText("Campos em branco");
        alert.setContentText("Verifique se algum campo está em branco");
        alert.showAndWait();
    }

    public boolean confirma() {
        if (tableViewP.getSelectionModel().isEmpty()) {
            aviso();
            return true;
        } else {
            return false;
        }
    }

    @FXML
    public void buscar() {
        listaP.clear();
        if (dataV.getValue() != null) {
            Date date = java.sql.Date.valueOf(dataV.getValue());
            listaP.addAll(c.listDataVenda(date));
            String str2 = String.valueOf(c.somaTotalParcelas(date));
            cobraHoje.setText(str2);
        } else if (!nomeC.getText().isEmpty()) {
            listaP.addAll(c.listNomeClienteVenda(nomeC.getText())); 
        }else if(!nomeM.getText().isEmpty()){
            listaP.addAll(c.listNomeVenda(nomeM.getText()));
           }
        
        tableViewP.setItems(listaP);
    }

    @FXML
    public void editarInformacoes() throws IOException {
        if (confirma() == true) {

        } else {
            p = tableViewP.getSelectionModel().getSelectedItem();

            Parent root = FXMLLoader.load(getClass().getResource("/Visao/EditarVenda.fxml"));
            Scene janela1 = new Scene(root);

            stage.setScene(janela1);
            stage.show();
            stage.setTitle("Editar Venda");
        }

    }

    @FXML
    public void confirmarCobranca() throws IOException {
        if (confirma() == true) {

        } else {
            p = tableViewP.getSelectionModel().getSelectedItem();
            Parent root = FXMLLoader.load(getClass().getResource("/Visao/ConfirmaVenda.fxml"));
            Scene janela2 = new Scene(root);

            //Stage stage = new Stage();
            stage.setScene(janela2);
            stage.show();
            stage.setTitle("Confirmação de venda");
        }
    }

    @FXML
    private void excluirVenda(ActionEvent event) throws IOException {
        if (confirma() == true) {

        } else {
            p = tableViewP.getSelectionModel().getSelectedItem();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Atenção");
            alert.setHeaderText("Exclusão de Venda");
            alert.setContentText("Deseja realmente excluir\n a venda de " + p.getNomeMercadoria()
                    + " do cliente " + p.getNome() + " ?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                c.DeleteFromVenda(p);
                MenuController.menu.Pendencias();
            }
        }
    }
}

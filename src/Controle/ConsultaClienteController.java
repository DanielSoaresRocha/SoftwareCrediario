package Controle;

import Modelo.Cliente;
import Persistencia.PCliente;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

;

public class ConsultaClienteController implements Initializable {

    private ObservableList<Cliente> lista = FXCollections.observableArrayList();

    @FXML
    private TableView<Cliente> TableView;
    @FXML
    private TableColumn<Cliente, Integer> idClienteColum;
    @FXML
    private TableColumn<Cliente, String> nomeClienteColum;
    @FXML
    private TableColumn<Cliente, Integer> cpfClienteColum;
    @FXML
    private TableColumn<Cliente, String> enderecoClienteColum;
    @FXML
    private TableColumn<Cliente, Integer> NumeroClienteColum;
    @FXML
    private TableColumn<Cliente, String> NomeMaeColum;
    @FXML
    private JFXTextField consulta;
    @FXML
    private JFXButton busca;
    @FXML
    private JFXButton editar;
    @FXML
    private JFXButton excluir;

    PCliente c = new PCliente();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        idClienteColum.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("IdCliente"));
        nomeClienteColum.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        cpfClienteColum.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("cpf"));
        enderecoClienteColum.setCellValueFactory(new PropertyValueFactory<Cliente, String>("endereco"));
        NumeroClienteColum.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("numero"));
        NomeMaeColum.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nomeMae"));

        lista.addAll(c.listCliente());
        TableView.setItems(lista);
    }

    //USAR LIKE NA BUSCA DO CLIENTE POR NOME
    @FXML
    public void consultar() {
        System.out.println("Entrouuu");
        lista.clear();
        lista.addAll(c.consultaCliente(consulta.getText()));
        TableView.setItems(lista);
    }

    @FXML
    public void excluirCliente() {
        c.DeleteFromCliente(TableView.getSelectionModel().getSelectedItem());
        lista.clear();
        lista.addAll(c.listCliente());
        TableView.setItems(lista);
    }
    
    @FXML
    public void editarCliente() throws IOException {
        if (TableView.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção");
            alert.setHeaderText("Campos em branco");
            alert.setContentText("Verifique se algum campo está em branco");
            alert.showAndWait();
        }else{
             Parent root = FXMLLoader.load(getClass().getResource("/Visao/EditarCliente.fxml"));
             Scene janela = new Scene(root);
       
            Stage stage = new Stage();
            stage.setScene(janela);
            stage.show();
            stage.setTitle("Editar Cliente");
        }
    }

}

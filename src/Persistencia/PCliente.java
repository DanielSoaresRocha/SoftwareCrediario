package Persistencia;

import Modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PCliente {

    private PConexao con = new PConexao();

    public void insertIntoCliente(String nome, int cpf, String endereco, int numero, String nomemae) {
        System.out.println("entrou");
        con.dbConnection();
        String query = "INSERT INTO CLIENTE(nome, cpf, endereco, numero, nomemae) VALUES (?,?,?,?,?);";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            pst.setString(1, nome);
            pst.setInt(2, cpf);
            pst.setString(3, endereco);
            pst.setInt(4, numero);
            pst.setString(5, nomemae);
            pst.executeUpdate();
            System.out.println("Cliente Adicionado");
        } catch (SQLException ex) {
            Logger.getLogger(PVendedor.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("N deu certo");
        }
        con.closeConnection();
    }

    public void readCliente() {
        con.dbConnection();
        String query = " SELECT * FROM CLIENTE;";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + ":" + rs.getString(2) + " : " + rs.getInt(3) + " : " + rs.getString(4) + ":"
                        + rs.getInt(5) + ":" + rs.getString(6));
            }
        } catch (SQLException ex) {
            System.out.println("N foi possivel");
            Logger.getLogger(PVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.closeConnection();
    }

    public ArrayList<Cliente> consultaCliente(String cliente) {
        ArrayList<Cliente> lista = new ArrayList<>();
        con.dbConnection();
        try {
            String query = " SELECT * FROM cliente"
                + " WHERE UPPER(nome) LIKE '%' || UPPER('"+cliente+"')||'%';";
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            //System.out.println("pst " + pst.toString());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String x = rs.getString(2);
                //if ((x.equals(cliente))) {
                    Cliente a = new Cliente(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
                            rs.getInt(5), rs.getString(6));
                    lista.add(a);
                //    System.out.println("Encontrado");

                //}
            }
        } catch (SQLException ex) {
            Logger.getLogger(PVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Não encontrado");
        con.closeConnection();
        return lista;
    }

    public ArrayList<Cliente> listCliente() {
        ArrayList<Cliente> lista = new ArrayList<>();
        con.dbConnection();
        String query = " SELECT * FROM CLIENTE ORDER BY NOME;";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) { //enquanto houver registro
                Cliente a = new Cliente(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
                        rs.getInt(5), rs.getString(6));
                lista.add(a);
            }
            // DESCONECTA
            con.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Collections.sort(lista);
        return lista;
    }
     public void DeleteFromCliente(Cliente c) {
        con.dbConnection();
        String query = "DELETE FROM CLIENTE WHERE idcliente = ?;";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            pst.setInt(1, c.getIdCliente());
            pst.executeUpdate();
            System.out.println("Cliente excluido");
        } catch (SQLException ex) {
            System.out.println("n deu certo");
            Logger.getLogger(PVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.closeConnection();
    }
}

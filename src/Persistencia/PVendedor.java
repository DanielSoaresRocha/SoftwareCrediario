package Persistencia;

import Persistencia.PConexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PVendedor {

    private PConexao con = new PConexao();

    public void insertIntoVendedor(String nome, int cpf, String senha) {
        con.dbConnection();
        String query = "INSERT INTO VENDEDOR(nome, cpf, senha ) VALUES (?,?,?);";

        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            pst.setString(1, nome);
            pst.setInt(2, cpf);
            pst.setString(3, senha);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.closeConnection();
    }

    public void DeleteFromVendedor(String nome) {
        con.dbConnection();
        String query = "DELETE FROM VENDEDOR WHERE nome = ?;";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            pst.setString(1, nome);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.closeConnection();
    }

    public void ReadVendedor() {
        con.dbConnection();
        String query = " SELECT * FROM vendedor;";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + " : " + rs.getInt(2) + " : " + rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.closeConnection();
    }

    public boolean LoginFromVendedor(String user, String senha) {
        con.dbConnection();
        String query = " SELECT * FROM vendedor;";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String x = rs.getString(1);
                String y = rs.getString(3);
                if ((x.equals(user)) && y.equals(senha)) {
                    System.out.println("Encontrado");
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Não encontrado");
        con.closeConnection();
        return false;
    }
}

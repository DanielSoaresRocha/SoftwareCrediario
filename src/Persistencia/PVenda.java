package Persistencia;

import Modelo.Pendencias;
import Modelo.Venda;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PVenda {

    private PConexao con = new PConexao();

    //Inserindo venda no banco
    public void insertIntoVenda(String status, String nomeM, double valorM, int numP, double valorP, Date dataV, Date dataC, double vPago, int idC) {
        System.out.println("entrou");
        con.dbConnection();
        String query = "INSERT INTO venda(status, nomemercadoria, valormercadoria, numparcelas, valorparcelas, datavenda, datacobranca,valorPago, IdCliente) VALUES (?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            pst.setString(1, status);
            pst.setString(2, nomeM);
            pst.setDouble(3, valorM);
            pst.setInt(4, numP);
            pst.setDouble(5, valorP);
            pst.setDate(6, (java.sql.Date) dataV);
            pst.setDate(7, (java.sql.Date) dataC);
            pst.setDouble(8, vPago);
            pst.setInt(9, idC);
            pst.executeUpdate();
            System.out.println("Venda Adicionada");
        } catch (SQLException ex) {
            Logger.getLogger(PVendedor.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("N deu certo");
        }
        con.closeConnection();
    }

    //Lista para pendencias
    public ArrayList<Pendencias> listVenda() {
        ArrayList<Pendencias> lista = new ArrayList<>();
        con.dbConnection();
        String query = "select V.idvenda, V.datavenda, V.datacobranca, C.nome,V.nomemercadoria, V.valormercadoria, V.valorpago, (V.valormercadoria-V.valorpago) AS valorrestante, valorparcelas\n"
                + "from venda V, cliente C\n"
                + "where C.idcliente = V.idcliente\n"
                + "order by C.nome;";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) { //enquanto houver registro
                Pendencias a = new Pendencias();
                a.setId(rs.getInt(1));
                a.setDataVenda(rs.getDate(2));
                a.setDataCobranca(rs.getDate(3));
                a.setNome(rs.getString(4));
                a.setNomeMercadoria(rs.getString(5));
                a.setValorTotal(rs.getDouble(6));
                a.setValorPago(rs.getDouble(7));
                a.setValorRestante(rs.getDouble(8));
                a.setMensalidade(rs.getDouble(9));
                lista.add(a);
                System.out.println("valor " + a.getNome() + " " + a.getValorTotal());
            }
            // DESCONECTA
            con.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Collections.sort(lista);
        return lista;

    }

    //Lista para pendencias pela data selecionada
    public ArrayList<Pendencias> listDataVenda(Date data) {
        ArrayList<Pendencias> lista = new ArrayList<>();
        con.dbConnection();
        String query = "select V.idvenda, V.datavenda, V.datacobranca, C.nome,V.nomemercadoria, V.valormercadoria, V.valorpago, (V.valormercadoria-V.valorpago) AS valorrestante, valorparcelas\n"
                + "from venda V, cliente C\n"
                + "where C.idcliente = V.idcliente\n"
                + "and V.datacobranca = ?\n"
                + "order by C.nome;";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);

            pst.setDate(1, data);
            // pst.executeUpdate;
            ResultSet rs = pst.executeQuery();
            while (rs.next()) { //enquanto houver registro
                Pendencias a = new Pendencias();
                a.setId(rs.getInt(1));
                a.setDataVenda(rs.getDate(2));
                a.setDataCobranca(rs.getDate(3));
                a.setNome(rs.getString(4));
                a.setNomeMercadoria(rs.getString(5));
                a.setValorTotal(rs.getDouble(6));
                a.setValorPago(rs.getDouble(7));
                a.setValorRestante(rs.getDouble(8));
                a.setMensalidade(rs.getDouble(9));
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

    //Lista para pendencias pelo nome do cliente
    public ArrayList<Pendencias> listNomeClienteVenda(String nome) {
        ArrayList<Pendencias> lista = new ArrayList<>();
        con.dbConnection();
        String query = "select V.idvenda, V.datavenda, V.datacobranca, C.nome,V.nomemercadoria, V.valormercadoria, V.valorpago, (V.valormercadoria-V.valorpago) AS valorrestante, valorparcelas\n"
                + "from venda V, cliente C\n"
                + "where C.idcliente = V.idcliente\n"
                + "and UPPER(C.nome) LIKE '%' || UPPER('"+nome+"') || '%' \n"
                + "order by C.nome;";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);

            //pst.setString(1, nome);
            // pst.executeUpdate;
            ResultSet rs = pst.executeQuery();
            while (rs.next()) { //enquanto houver registro
                Pendencias a = new Pendencias();
                a.setId(rs.getInt(1));
                a.setDataVenda(rs.getDate(2));
                a.setDataCobranca(rs.getDate(3));
                a.setNome(rs.getString(4));
                a.setNomeMercadoria(rs.getString(5));
                a.setValorTotal(rs.getDouble(6));
                a.setValorPago(rs.getDouble(7));
                a.setValorRestante(rs.getDouble(8));
                a.setMensalidade(rs.getDouble(9));
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

    //Lista para pendencias pelo nome da venda
    public ArrayList<Pendencias> listNomeVenda(String nome) {
        ArrayList<Pendencias> lista = new ArrayList<>();
        con.dbConnection();
        String query = "select V.idvenda, V.datavenda, V.datacobranca, C.nome,V.nomemercadoria, V.valormercadoria, V.valorpago, (V.valormercadoria-V.valorpago) AS valorrestante, valorparcelas\n"
                + "from venda V, cliente C\n"
                + "where C.idcliente = V.idcliente\n"
                + "and UPPER(V.nomemercadoria) LIKE '%' || UPPER('"+nome+"') || '%' \n"
                + "order by C.nome;";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);

            //pst.setString(1, nome);
            // pst.executeUpdate;
            ResultSet rs = pst.executeQuery();
            while (rs.next()) { //enquanto houver registro
                Pendencias a = new Pendencias();
                a.setId(rs.getInt(1));
                a.setDataVenda(rs.getDate(2));
                a.setDataCobranca(rs.getDate(3));
                a.setNome(rs.getString(4));
                a.setNomeMercadoria(rs.getString(5));
                a.setValorTotal(rs.getDouble(6));
                a.setValorPago(rs.getDouble(7));
                a.setValorRestante(rs.getDouble(8));
                a.setMensalidade(rs.getDouble(9));
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
    //somatório de vendas
    public double somaTotalVenda() {
        con.dbConnection();
        double result = 0;
        String query = "select sum (V.valormercadoria)\n"
                + "from venda V;";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                result = rs.getDouble(1);
            }

            return result;

            // DESCONECTA
        } catch (SQLException e) {
            e.printStackTrace();
        }
        con.closeConnection();
        return 1;
    }

    //Soma o total a cobrar no dia da tada selecionada
    public double somaTotalParcelas(Date data) {
        con.dbConnection();
        double result = 0;
        String query = "select sum(valorparcelas)\n"
                + "from venda\n"
                + "where datacobranca = ?;";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            pst.setDate(1, data);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                result = rs.getDouble(1);
            }

            return result;

            // DESCONECTA
        } catch (SQLException e) {
            e.printStackTrace();
        }
        con.closeConnection();
        return 1;
    }

    public void DeleteFromVenda(Pendencias p) {
        con.dbConnection();
        String query = "DELETE FROM VENDA WHERE idvenda = ?;";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            pst.setInt(1, p.getId());
            pst.executeUpdate();
            System.out.println("Venda excluida");
        } catch (SQLException ex) {
            System.out.println("n deu certo");
            Logger.getLogger(PVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.closeConnection();
    }

    //editar venda 
    public boolean editVenda(Pendencias p, String status, String nomeM, double valorM, int numP, double valorP,
            Date data, Date dataCobranca, double valorPago) {
        con.dbConnection();
        String query = "UPDATE venda SET status = ?, nomemercadoria= ?, valormercadoria = ?, numparcelas = ?,\n"
                + "valorparcelas = ?, datavenda = ?, datacobranca = ?, valorpago = ?\n"
                + "WHERE idvenda = ?;";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            pst.setString(1, status);
            pst.setString(2, nomeM);
            pst.setDouble(3, valorM);
            pst.setInt(4, numP);
            pst.setDouble(5, valorP);
            pst.setDate(6, data);
            pst.setDate(7, dataCobranca);
            pst.setDouble(8, valorPago);
            pst.setInt(9, p.getId());
            System.out.println(pst.toString());
            pst.executeUpdate();
            System.out.println("Venda editada");
            return true;
        } catch (SQLException ex) {
            System.out.println("n deu certo");
            Logger.getLogger(PVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        con.closeConnection();
        return false;
    }

    //confirmando venda
    public boolean confirmaVenda(Pendencias p, double valorP, Date data) {
        con.dbConnection();
        String query = "update venda \n"
                + "set valorpago = (valorpago + ?), datacobranca = ?\n"
                + "where idvenda = ?;";
        try {
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            pst.setDouble(1, valorP);
            pst.setDate(2, data);
            pst.setInt(3, p.getId());
            System.out.println(pst.toString());
            pst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println("n deu certo");
            Logger.getLogger(PVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.closeConnection();
        return false;
    }
}

package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PConexao {
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/sis_vendas";
    private String user = "postgres";
    private String password = "postgre";

    public void dbConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected");
        } catch (SQLException ex) {
            Logger.getLogger(PVendedor.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Not connected");
        }

    }
    
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(PConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    
}

package MODEL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

    private static final String NOME_DO_BANCO = "gestaodelanchonete";
    private static final String USUARIO = "root";
    private static final String SENHA = "Ledson88171178..";
    private static final String URL = "jdbc:mysql://localhost:3306/" + NOME_DO_BANCO + "?allowPublicKeyRetrieval=true&useSSL=false";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("❌ Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException("❌ Erro ao conectar: " + e.getMessage());
        }
    }
}
    
    
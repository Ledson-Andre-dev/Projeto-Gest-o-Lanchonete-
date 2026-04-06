package MODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FuncionariosDB {

public boolean checkLogin(String login, String senha) {
    String sql = "SELECT * FROM funcionarios WHERE login = ? AND senha = ?";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, login);
        stmt.setString(2, senha);

        try (ResultSet rs = stmt.executeQuery()) {
            return rs.next(); 
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao verificar login: "+ e.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);
        return false;
    }
}

public int searchID(String login){

     String sql = "SELECT id FROM funcionarios WHERE login = ?";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, login);
       

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
             return rs.getInt("id"); 
            }
            else{
                return -1;
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao consultar banco de dados: "+ e.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);
        return -1;
    }

}

public String searchAccessLevel(int id){
    String sql = "SELECT nivel_acesso FROM funcionarios WHERE id = ?";
    try (Connection conn = ConexaoMySQL.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
        

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                return rs.getString("nivel_acesso") ; 
                }
                else{
                    return "";
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar banco de dados: "+ e.getMessage());
            return "";
        }


}

public List<Object[]> getAllFuncionarios() {
    List<Object[]> lista = new ArrayList<>();
    String sql = "SELECT * FROM funcionarios";

     try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("cargo"),
                    rs.getString("nivel_acesso"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("ativo")
                };
                lista.add(row);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar banco de dados: " + e.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);
        }

        return lista;
    }

public void addFuncionario(String nome , String cpf , String cargo, int nivel_acesso, String login , String senha, String telefone , String email, int status ){
     String sql = "INSERT INTO funcionarios ( nome, cpf, cargo, nivel_acesso, login, senha, telefone, email, ativo) VALUES(?,?,?,?,?,?,?,?,?)";
    try (Connection conn = ConexaoMySQL.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, cargo);
            stmt.setInt(4, nivel_acesso);
            stmt.setString(5, login);
            stmt.setString(6, senha);
            stmt.setString(7, telefone);
            stmt.setString(8, email);
            stmt.setInt(9, status);

        

            int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Funcionário adicionado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum funcionário foi adicionado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar banco de dados: "+ e.getMessage() , "Erro",JOptionPane.ERROR_MESSAGE);
        }


}

public String[] prencherAtulizarFuncionario(int id) {
    String[] vetor = new String[9];
    String sql = "SELECT * FROM funcionarios WHERE id = ?";

     try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);){
         stmt.setInt(1, id);
        try(ResultSet rs = stmt.executeQuery()){
            while (rs.next()) {    
                vetor[0] = rs.getString("nome");
                vetor[1] =  rs.getString("cpf");
                vetor[2] = rs.getString("cargo");
                vetor[3] = rs.getString("nivel_acesso");
                vetor[4] = rs.getString("login");
                vetor[5] = rs.getString("senha");
                vetor[6] = rs.getString("telefone");
                vetor[7] = rs.getString("email");
                vetor[8] = rs.getString("ativo");
                };
             
            }
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar banco de dados: " + e.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);
        }

        return vetor;
    }

public void updateFuncionario(String nome , String cpf , String cargo, int nivel_acesso, String login , String senha, String telefone , String email, int status , int id ){
    String sql = "UPDATE funcionarios SET nome = ?, cpf = ?, cargo = ?, nivel_acesso = ?, login = ?, senha = ?, telefone = ?, email = ?, ativo = ? WHERE id = ?";
    try (Connection conn = ConexaoMySQL.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, cargo);
            stmt.setInt(4, nivel_acesso);
            stmt.setString(5, login);
            stmt.setString(6, senha);
            stmt.setString(7, telefone);
            stmt.setString(8, email);
            stmt.setInt(9, status);
            stmt.setInt(10, id);    
        

            int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum funcionário foi atualizado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar banco de dados: "+ e.getMessage() , "Erro",JOptionPane.ERROR_MESSAGE);
        }


}

public boolean removeFuncionario(int id) {
    
    String sql = "DELETE FROM funcionarios WHERE id = ?";

     try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ) {
            stmt.setInt(1, id);
            int rs = stmt.executeUpdate();
            return rs > 0;
        }

        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar banco de dados: " + e.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

public List<Object[]> searchFuncionarios(String filtro, String valor) {
    List<Object[]> funcionarios = new ArrayList<>();

    String sql;

    switch (filtro) {
        case "Nome":
            sql = "SELECT * FROM funcionarios WHERE nome LIKE ?";
            break;
        case "Cargo":
            sql = "SELECT * FROM funcionarios WHERE cargo LIKE ?";
            break;
        case "CPF":
            sql = "SELECT * FROM funcionarios WHERE cpf LIKE ?";
            break;
        case "ID":
            sql = "SELECT * FROM funcionarios WHERE CAST(id AS CHAR) LIKE ?";
            break;
        case "Sem filtro":
        default:
            sql = "SELECT * FROM funcionarios " +
                  "WHERE nome LIKE ? " +
                  "   OR cargo LIKE ? " +
                  "   OR cpf LIKE ? " +
                  "   OR CAST(id AS CHAR) LIKE ?";
            break;
    }

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        String like = "%" + valor + "%";

        if (filtro.equals("Sem filtro")) {
            stmt.setString(1, like); 
            stmt.setString(2, like); 
            stmt.setString(3, like); 
            stmt.setString(4, like); 
        } else {
            stmt.setString(1, like);
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Object[] linha = {
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("cargo"),
                rs.getString("nivel_acesso"),
                rs.getString("login"),
                rs.getString("senha"),
                rs.getString("telefone"),
                rs.getString("email"),
                rs.getString("ativo") 
            };
            funcionarios.add(linha);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return funcionarios;
}

}
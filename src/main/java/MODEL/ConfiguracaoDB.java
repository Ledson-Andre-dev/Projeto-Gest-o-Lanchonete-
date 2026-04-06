package MODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConfiguracaoDB {

    public void updateConfiguracao(String nome, String descricao, String logo, String banner) {
    String sql = "UPDATE configuracao_empresa SET nome = ?, descricao = ?, logo = ?, banner = ? WHERE id = 1";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nome);
        stmt.setString(2, descricao != null ? descricao : "");
        stmt.setString(3, logo != null ? logo : "");
        stmt.setString(4, banner != null ? banner : "");

        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Configuração atualizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma configuração foi atualizada!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar configuração: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}

    public String[] preencherConfigurar() {
    String[] vetor = new String[4]; 
    String sql = "SELECT nome, descricao, logo, banner FROM configuracao_empresa WHERE id = 1";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        if (rs.next()) {
            vetor[0] = rs.getString("nome");
            vetor[1] = rs.getString("descricao");
            vetor[2] = rs.getString("logo");   
            vetor[3] = rs.getString("banner"); 
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao consultar configuração: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    return vetor;
}


    
}

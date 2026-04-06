package MODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ProdutosDB {
    
public List<Object[]> getAllProdutos() {
    List<Object[]> lista = new ArrayList<>();
    String sql = "SELECT id, nome, preco, categoria, ativo FROM produtos";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Object[] row = {
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getDouble("preco"),
                rs.getString("categoria"),
                rs.getString("ativo")       
            };
            lista.add(row);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao consultar produtos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    return lista;
}

public boolean removeProduto(int id) {
    String sql = "DELETE FROM produtos WHERE id = ?";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, id);
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0; // true se removeu pelo menos 1 linha

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao excluir produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}

public List<Object[]> searchProdutos(String filtro, String valor) {
    List<Object[]> produtos = new ArrayList<>();

    String sql;

    switch (filtro) {
        case "Nome":
            sql = "SELECT id, nome, preco, categoria, ativo FROM produtos WHERE nome LIKE ?";
            break;
        case "ID":
            sql = "SELECT id, nome, preco, categoria, ativo FROM produtos WHERE CAST(id AS CHAR) LIKE ?";
            break;
        case "Lanches":
        case "Porções":
        case "Bebidas":
        case "Sobremesas":
        case "Acompanhamentos":
            sql = "SELECT id, nome, preco, categoria, ativo FROM produtos WHERE categoria = ?";
            break;
        case "Sem filtro":
        default:
            sql = "SELECT id, nome, preco, categoria, ativo FROM produtos " +
                  "WHERE nome LIKE ? OR CAST(id AS CHAR) LIKE ?";
            break;
    }

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        if (filtro.equals("Sem filtro")) {
            String like = "%" + valor + "%";
            stmt.setString(1, like); 
            stmt.setString(2, like); 
        } else if (filtro.equals("Lanches") || filtro.equals("Porções") ||
                   filtro.equals("Bebidas") || filtro.equals("Sobremesas") ||
                   filtro.equals("Acompanhamentos")) {
            stmt.setString(1, filtro); 
        } else {
            String like = "%" + valor + "%";
            stmt.setString(1, like);
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Object[] row = {
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getDouble("preco"),  
                rs.getString("categoria"),
                rs.getString("ativo")
            };
            produtos.add(row);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return produtos;
}

public void addProduto(String nome, double preco, String categoria, String descricao, 
                       String status, String caminhoImagem, int idFuncionario) {
    String sqlSetFuncionario = "SET @id_funcionario = ?";
    String sqlInsert = "INSERT INTO produtos (nome, preco, categoria, descricao, ativo, image) " +
                       "VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmtSet = conn.prepareStatement(sqlSetFuncionario);
         PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)) {

        // Passa o id do funcionário para a variável de sessão
        stmtSet.setInt(1, idFuncionario);
        stmtSet.execute();

        // Insere o produto normalmente
        stmtInsert.setString(1, nome);
        stmtInsert.setDouble(2, preco);
        stmtInsert.setString(3, categoria);
        stmtInsert.setString(4, descricao);
        stmtInsert.setString(5, status);
        stmtInsert.setString(6, caminhoImagem != null ? caminhoImagem : "");

        int rowsAffected = stmtInsert.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum produto foi adicionado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao adicionar produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}


public String[] preencherAtualizarProduto(int id) {
    String[] vetor = new String[6];
    String sql = "SELECT * FROM produtos WHERE id = ?";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                vetor[0] = rs.getString("nome");
                vetor[1] = String.valueOf(rs.getDouble("preco"));
                vetor[2] = rs.getString("categoria");
                vetor[3] = rs.getString("descricao");
                vetor[4] = rs.getString("ativo");       // "Ativo" ou "Inativo"
                vetor[5] = rs.getString("image");       // caminho da imagem
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao consultar banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    return vetor;
}

public void updateProduto(String nome, double preco, String categoria, String descricao,
                          String status, String caminhoImagem, int id, Integer idFuncionario) {

    String setFuncionario = "SET @id_funcionario = ?";
    String sql = "UPDATE produtos SET nome = ?, preco = ?, categoria = ?, descricao = ?, ativo = ?, image = ? WHERE id = ?";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmtSet = conn.prepareStatement(setFuncionario);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        // Se idFuncionario for null, seta como NULL no MySQL
        if (idFuncionario != null) {
            stmtSet.setInt(1, idFuncionario);
        } else {
            stmtSet.setNull(1, java.sql.Types.INTEGER);
        }
        stmtSet.execute();

        stmt.setString(1, nome);
        stmt.setDouble(2, preco);
        stmt.setString(3, categoria);
        stmt.setString(4, descricao);
        stmt.setString(5, status); // "Ativo" ou "Inativo"
        stmt.setString(6, caminhoImagem != null ? caminhoImagem : "");
        stmt.setInt(7, id);

        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum produto foi atualizado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}


public String[] getDescricaoECaminhoImagem(int id) {
    String[] resultado = new String[2]; // [0] = descricao, [1] = caminhoImagem
    String sql = "SELECT descricao, image FROM produtos WHERE id = ?";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                resultado[0] = rs.getString("descricao");
                resultado[1] = rs.getString("image");
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao consultar produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    return resultado;
}

}

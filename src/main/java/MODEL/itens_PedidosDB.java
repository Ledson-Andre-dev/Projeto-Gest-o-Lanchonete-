package MODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class itens_PedidosDB {
    
public List<Object[]> getAllItensPedido(int idPedido) {
    List<Object[]> lista = new ArrayList<>();
    String sql = "SELECT ip.id, ip.id_produto, pr.nome AS nome_produto, ip.quantidade, ip.subtotal " +
                 "FROM itens_pedido ip " +
                 "JOIN produtos pr ON ip.id_produto = pr.id " +
                 "WHERE ip.id_pedido = ?";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idPedido);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),          
                    rs.getInt("id_produto"),  
                    rs.getString("nome_produto"),
                    rs.getInt("quantidade"),
                    rs.getDouble("subtotal")
                };
                lista.add(row);
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao consultar itens do pedido: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    return lista;
}

public Object[] getDetalhesItemParaTabela(String nomeProduto, int quantidade) {
    Object[] row = null; 
    
    
    String sql = "SELECT id, nome, preco FROM produtos WHERE nome = ?";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

   
        stmt.setString(1, nomeProduto);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) { 
                int idProduto = rs.getInt("id");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco"); 
                
              
                double subtotal = preco * quantidade;

               
                row = new Object[]{
                    "Pendente",  
                    idProduto,   
                    nome,        
                    quantidade,  
                    subtotal     
                };
            } else {
               
                JOptionPane.showMessageDialog(null, "Produto não encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    return row;
}

public boolean removeItemPedido(int id) {
    String sql = "DELETE FROM itens_pedido WHERE id = ?";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao remover item do pedido: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}

public void addItemPedido(int idPedido, String nomeProduto, int quantidade) {
    String sqlProduto = "SELECT id, preco FROM produtos WHERE nome = ?";
    String sqlInsert = "INSERT INTO itens_pedido (id_produto, id_pedido, quantidade, subtotal) VALUES (?, ?, ?, ?)";

    try (Connection conn = ConexaoMySQL.getConnection()) {

        int idProduto;
        double preco;

        
        try (PreparedStatement stmtProduto = conn.prepareStatement(sqlProduto)) {
            stmtProduto.setString(1, nomeProduto);
            ResultSet rsProduto = stmtProduto.executeQuery();
            if (rsProduto.next()) {
                idProduto = rsProduto.getInt("id");
                preco = rsProduto.getDouble("preco");
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        double subtotal = preco * quantidade;

        // Insere o item do pedido
        try (PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)) {
            stmtInsert.setInt(1, idProduto);
            stmtInsert.setInt(2, idPedido);
            stmtInsert.setInt(3, quantidade);
            stmtInsert.setDouble(4, subtotal);

            int rowsAffected = stmtInsert.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Item adicionado ao pedido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum item foi adicionado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao adicionar item do pedido: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}

public boolean inserirItemDireto(int idPedido, int idProduto, int quantidade, double subtotal) {
    String sql = "INSERT INTO itens_pedido (id_pedido, id_produto, quantidade, subtotal) VALUES (?, ?, ?, ?)";
    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, idPedido);
        stmt.setInt(2, idProduto);
        stmt.setInt(3, quantidade);
        stmt.setDouble(4, subtotal);
        
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        System.out.println("Erro ao inserir item: " + e.getMessage());
        return false;
    }
}

}




package MODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PedidosDB {


public Integer getUltimoPedidoVazio() {
    String sql = "SELECT id, valor_pedido, nome, situação FROM pedidos ORDER BY id DESC LIMIT 1";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        if (rs.next()) {
            double valorPedido = rs.getDouble("valor_pedido");
            String nome = rs.getString("nome");
            String situacao = rs.getString("situação");

            if (valorPedido == 0.0 && nome == null && situacao == null) {
                return rs.getInt("id"); 
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao verificar último pedido: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    return null; 
}
    
public void atualizarPedido(int idPedido, Integer idCliente, String nome, double valorPedido, String situacao) {
    String sql = "UPDATE pedidos SET id_cliente = ?, nome = ?, valor_pedido = ?, situação = ? WHERE id = ?";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        if (idCliente != null) {
            stmt.setInt(1, idCliente);
        } else {
            stmt.setNull(1, java.sql.Types.INTEGER);
        }

        stmt.setString(2, nome);
        stmt.setDouble(3, valorPedido);
        stmt.setString(4, situacao);
        stmt.setInt(5, idPedido);

        stmt.executeUpdate(); 

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar pedido: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}

public Object[] buscarIDeNomeCliente(String cpf) {
    String sql = "SELECT id, nome FROM clientes WHERE cpf = ?";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, cpf);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                int idCliente = rs.getInt("id");
                String nomeCliente = rs.getString("nome");
                return new Object[]{idCliente, nomeCliente};
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado pelo CPF!", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar cliente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        return null;
    }
}

public List<Object[]> getAllPedidos() {
    List<Object[]> lista = new ArrayList<>();
    String sql = "SELECT id, id_cliente, nome, valor_pedido, situação FROM pedidos";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Integer idCliente = (rs.getObject("id_cliente") != null) ? rs.getInt("id_cliente") : null;

            Object[] row = {
                rs.getInt("id"),
                idCliente,
                rs.getString("nome"),
                rs.getDouble("valor_pedido"),
                rs.getString("situação")
            };
            lista.add(row);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao consultar pedidos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    return lista;
}

public boolean removePedido(int id) {
    String sqlItens = "DELETE FROM itens_pedido WHERE id_pedido = ?";
    String sqlPedido = "DELETE FROM pedidos WHERE id = ?";

    try (Connection conn = ConexaoMySQL.getConnection()) {
        conn.setAutoCommit(false); 
        try (PreparedStatement stmtItens = conn.prepareStatement(sqlItens)) {
            stmtItens.setInt(1, id);
            stmtItens.executeUpdate();
        }

        int rowsAffected;
        try (PreparedStatement stmtPedido = conn.prepareStatement(sqlPedido)) {
            stmtPedido.setInt(1, id);
            rowsAffected = stmtPedido.executeUpdate();
        }

        conn.commit();
        return rowsAffected > 0;

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao remover pedido: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}

public List<Object[]> searchPedidos(String filtro, String valor) {
    List<Object[]> pedidos = new ArrayList<>();

    String sql;

    switch (filtro) {
        case "Nome do cliente":
            sql = "SELECT p.id, p.id_cliente, p.nome, p.valor_pedido, p.situação " +
                  "FROM pedidos p " +
                  "JOIN clientes c ON p.id_cliente = c.id " +
                  "WHERE c.nome LIKE ?";
            break;

        case "CPF":
            sql = "SELECT p.id, p.id_cliente, p.nome, p.valor_pedido, p.situação " +
                  "FROM pedidos p " +
                  "JOIN clientes c ON p.id_cliente = c.id " +
                  "WHERE c.cpf LIKE ?";
            break;

        case "ID do Cliente":
            sql = "SELECT p.id, p.id_cliente, p.nome, p.valor_pedido, p.situação " +
                  "FROM pedidos p " +
                  "WHERE CAST(p.id_cliente AS CHAR) LIKE ?";
            break;

        case "ID do Pedido":
            sql = "SELECT p.id, p.id_cliente, p.nome, p.valor_pedido, p.situação " +
                  "FROM pedidos p " +
                  "WHERE CAST(p.id AS CHAR) LIKE ?";
            break;

        case "Sem filtro":
        default:
            sql = "SELECT p.id, p.id_cliente, p.nome, p.valor_pedido, p.situação " +
                  "FROM pedidos p " +
                  "LEFT JOIN clientes c ON p.id_cliente = c.id " +
                  "WHERE p.nome LIKE ? " +               
                  "   OR CAST(p.id AS CHAR) LIKE ? " +   
                  "   OR CAST(p.id_cliente AS CHAR) LIKE ? " + 
                  "   OR c.nome LIKE ? " +               
                  "   OR c.cpf LIKE ?";                  
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
            stmt.setString(5, like); 
        } else {
            stmt.setString(1, like);
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Object[] linha = {
                rs.getInt("id"),
                rs.getInt("id_cliente"),
                rs.getString("nome"),
                rs.getDouble("valor_pedido"),
                rs.getString("situação")
            };
            pedidos.add(linha);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return pedidos;
}

public String[] preencherAtualizarPedido(int idPedido) {
    String[] vetor = new String[2]; 
    String sql = "SELECT p.id_cliente, p.nome, p.situação, c.cpf " +
                 "FROM pedidos p " +
                 "LEFT JOIN clientes c ON p.id_cliente = c.id " +
                 "WHERE p.id = ?";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, idPedido);
        
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {    
                rs.getInt("id_cliente");
                if (rs.wasNull()) { 
                    vetor[0] = rs.getString("nome");
                } else {
                    vetor[0] = rs.getString("cpf");
                }
                vetor[1] = rs.getString("situação"); 
            }
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao consultar pedido: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    return vetor;
}

public int criarPedidoRetornandoId(Integer idCliente, String nomeCliente, double valorTotal, String situacao) {
    int idGerado = -1; 
    String sql = "INSERT INTO pedidos (id_cliente, nome, valor_pedido, situação) VALUES (?, ?, ?, ?)";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

       
        if (idCliente != null) {
            stmt.setInt(1, idCliente);
        } else {
            stmt.setNull(1, java.sql.Types.INTEGER); 
        }
        
        stmt.setString(2, nomeCliente);
        stmt.setDouble(3, valorTotal);
        stmt.setString(4, situacao);

        if (stmt.executeUpdate() > 0) {
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) idGerado = rs.getInt(1); 
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao criar pedido: " + e.getMessage());
    }
    return idGerado;
}

}

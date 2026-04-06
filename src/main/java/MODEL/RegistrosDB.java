package MODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

public class RegistrosDB {
 

    
public List<Object[]> getAllRegistrosPedidos() {
        List<Object[]> lista = new ArrayList<>();
        String sql = "SELECT id, id_cliente, id_pedido, nome, valor_pedido, situação, data_hora, condicao FROM registros_pedidos";

        // 1. Cria o formatador com o padrão desejado (sem os segundos)
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        try (Connection conn = ConexaoMySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                
                // 2. Pega a data do banco como Timestamp
                Timestamp timestampBanco = rs.getTimestamp("data_hora");
                
                // 3. Converte para String formatada (fazendo uma checagem caso venha null do banco)
                String dataHoraFormatada = (timestampBanco != null) ? sdf.format(timestampBanco) : null;

                Object[] row = {
                    rs.getInt("id"),                                      // ID
                    rs.getObject("id_cliente") != null ? rs.getInt("id_cliente") : null, // ID_Cliente
                    rs.getObject("id_pedido") != null ? rs.getInt("id_pedido") : null,   // ID_Pedido
                    rs.getString("nome"),                                 // Nome
                    rs.getBigDecimal("valor_pedido"),                     // Valor_Pedido
                    rs.getString("situação"),                             // Situação
                    dataHoraFormatada,                                    // Data_Hora (Agora é uma String limpa!)
                    rs.getString("condicao")                              // Condição
                };
                lista.add(row);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar registros de pedidos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return lista;
    }

public List<Object[]> searchRegistrosPedidos(String filtro, String valor) {
    List<Object[]> registros = new ArrayList<>();
    String sql;

    switch (filtro) {
        case "Nome do cliente":
            sql = "SELECT r.id, r.id_cliente, r.id_pedido, r.nome, r.valor_pedido, r.situação, r.data_hora, r.condicao " +
                  "FROM registros_pedidos r " +
                  "LEFT JOIN clientes c ON r.id_cliente = c.id " +
                  "WHERE c.nome LIKE ?";
            break;
        case "CPF":
            sql = "SELECT r.id, r.id_cliente, r.id_pedido, r.nome, r.valor_pedido, r.situação, r.data_hora, r.condicao " +
                  "FROM registros_pedidos r " +
                  "LEFT JOIN clientes c ON r.id_cliente = c.id " +
                  "WHERE c.cpf LIKE ?";
            break;
        case "ID do Cliente":
            sql = "SELECT r.id, r.id_cliente, r.id_pedido, r.nome, r.valor_pedido, r.situação, r.data_hora, r.condicao " +
                  "FROM registros_pedidos r " +
                  "WHERE CAST(r.id_cliente AS CHAR) LIKE ?";
            break;
        case "ID do Pedido":
            sql = "SELECT r.id, r.id_cliente, r.id_pedido, r.nome, r.valor_pedido, r.situação, r.data_hora, r.condicao " +
                  "FROM registros_pedidos r " +
                  "WHERE CAST(r.id_pedido AS CHAR) LIKE ?";
            break;
        case "Sem filtro":
        default:
            sql = "SELECT r.id, r.id_cliente, r.id_pedido, r.nome, r.valor_pedido, r.situação, r.data_hora, r.condicao " +
                  "FROM registros_pedidos r " +
                  "LEFT JOIN clientes c ON r.id_cliente = c.id " +
                  "WHERE c.nome LIKE ? " +
                  "   OR c.cpf LIKE ? " +
                  "   OR CAST(r.id_cliente AS CHAR) LIKE ? " +
                  "   OR CAST(r.id_pedido AS CHAR) LIKE ?";
            break;
    }

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        String like = "%" + valor + "%";

        if ("Sem filtro".equals(filtro)) {
            stmt.setString(1, like); // c.nome
            stmt.setString(2, like); // c.cpf
            stmt.setString(3, like); // r.id_cliente
            stmt.setString(4, like); // r.id_pedido
        } else {
            stmt.setString(1, like);
        }

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getObject("id_cliente") != null ? rs.getInt("id_cliente") : null,
                    rs.getObject("id_pedido") != null ? rs.getInt("id_pedido") : null,
                    rs.getString("nome"),
                    rs.getBigDecimal("valor_pedido"),
                    rs.getString("situação"),
                    rs.getTimestamp("data_hora"),
                    rs.getString("condicao")
                };
                registros.add(row);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null,
            "Erro ao consultar registros de pedidos: " + e.getMessage(),
            "Erro", JOptionPane.ERROR_MESSAGE);
    }

    return registros;
}


public boolean removeRegistroPedido(int id) {
    String sql = "DELETE FROM registros_pedidos WHERE id = ?";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, 
                "Registro de pedido removido com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, 
                "Nenhum registro de pedido encontrado com o ID informado.", 
                "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, 
            "Erro ao remover registro de pedido: " + e.getMessage(), 
            "Erro", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}

public List<Object[]> getAllRegistrosProdutos() {
    List<Object[]> lista = new ArrayList<>();
    String sql = "SELECT id, id_funcionario, id_produto, nome, preco, categoria, ativo, data_hora, condicao FROM registros_produtos";

    // 1. Cria o formatador com o padrão desejado (dia/mês/ano hora:minuto)
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            
            // 2. Pega a data do banco
            Timestamp timestampBanco = rs.getTimestamp("data_hora");
            
            // 3. Converte para String formatada (com verificação para evitar erro caso seja nulo)
            String dataHoraFormatada = (timestampBanco != null) ? sdf.format(timestampBanco) : null;

            Object[] row = {
                rs.getInt("id"),                                                           // ID
                rs.getObject("id_funcionario") != null ? rs.getInt("id_funcionario") : null, // ID_Funcionário
                rs.getObject("id_produto") != null ? rs.getInt("id_produto") : null,       // ID_Produto
                rs.getString("nome"),                                                      // Nome
                rs.getBigDecimal("preco"),                                                 // Preço
                rs.getString("categoria"),                                                 // Categoria
                rs.getString("ativo"),                                                     // Ativo
                dataHoraFormatada,                                                         // Data_Hora (String formatada sem os segundos)
                rs.getString("condicao")                                                   // Condição
            };
            lista.add(row);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, 
            "Erro ao consultar registros de produtos: " + e.getMessage(), 
            "Erro", JOptionPane.ERROR_MESSAGE);
    }

    return lista;
}

public List<Object[]> searchRegistrosProdutos(String filtro, String valor) {
    List<Object[]> registros = new ArrayList<>();
    String sql;

    switch (filtro) {
        case "Nome do produto":
            sql = "SELECT r.id, r.id_funcionario, r.id_produto, r.nome, r.preco, r.categoria, " +
                  "r.ativo, r.data_hora, r.condicao " +
                  "FROM registros_produtos r " +
                  "WHERE r.nome LIKE ?";
            break;
        case "Categoria":
            sql = "SELECT r.id, r.id_funcionario, r.id_produto, r.nome, r.preco, r.categoria, " +
                  "r.ativo, r.data_hora, r.condicao " +
                  "FROM registros_produtos r " +
                  "WHERE r.categoria LIKE ?";
            break;
        case "ID":
            sql = "SELECT r.id, r.id_funcionario, r.id_produto, r.nome, r.preco, r.categoria, " +
                  "r.ativo, r.data_hora, r.condicao " +
                  "FROM registros_produtos r " +
                  "WHERE CAST(r.id AS CHAR) LIKE ?";
            break;
        case "Sem filtro":
        default:
            sql = "SELECT r.id, r.id_funcionario, r.id_produto, r.nome, r.preco, r.categoria, " +
                  "r.ativo, r.data_hora, r.condicao " +
                  "FROM registros_produtos r " +
                  "WHERE r.nome LIKE ? " +
                  "   OR r.categoria LIKE ? " +
                  "   OR CAST(r.id AS CHAR) LIKE ?";
            break;
    }

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        String like = "%" + valor + "%";

        if (filtro.equals("Sem filtro")) {
            stmt.setString(1, like); // nome
            stmt.setString(2, like); // categoria
            stmt.setString(3, like); // id
        } else {
            stmt.setString(1, like);
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Object[] row = {
                rs.getInt("id"),                                 // ID
                rs.getObject("id_funcionario") != null ? rs.getInt("id_funcionario") : null, // ID_Funcionario
                rs.getObject("id_produto") != null ? rs.getInt("id_produto") : null,       // ID_Produto
                rs.getString("nome"),                            // Nome
                rs.getBigDecimal("preco"),                       // Preço
                rs.getString("categoria"),                       // Categoria
                rs.getString("ativo"),                           // Ativo
                rs.getTimestamp("data_hora"),                    // Data_Hora
                rs.getString("condicao")                         // Condição
            };
            registros.add(row);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return registros;
}


public boolean removeRegistroProduto(int id) {
    String sql = "DELETE FROM registros_produtos WHERE id = ?";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, 
                "Registro de produto removido com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, 
                "Nenhum registro de produto encontrado com o ID informado.", 
                "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, 
            "Erro ao remover registro de produto: " + e.getMessage(), 
            "Erro", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}


}

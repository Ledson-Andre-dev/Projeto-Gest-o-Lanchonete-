package MODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import javax.swing.JOptionPane;

public class ClientesDB {  

public List<Object[]> getAllClientes() {
    List<Object[]> lista = new ArrayList<>();
    String sql = "SELECT id, nome, cpf, data_nascimento, cep, telefone, email, ativo FROM clientes";

    
    DateTimeFormatter formatadorBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            
            
            Date dataBanco = rs.getDate("data_nascimento");
            String dataFormatada = null;
            
            
            if (dataBanco != null) {
                dataFormatada = dataBanco.toLocalDate().format(formatadorBR);
            }

            Object[] row = {
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("cpf"),
                dataFormatada,        
                rs.getString("cep"),
                rs.getString("telefone"),
                rs.getString("email"),
                rs.getString("ativo")
            };
            lista.add(row);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao consultar clientes: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    return lista;
}

public void addCliente(String nome, String cpf, String dataNascimento, String cep, String estado, String cidade, String bairro, String rua, String numRua, String complemento, String telefone, String email, String status) {
    String sql = "INSERT INTO clientes (nome, cpf, data_nascimento, cep, estado, cidade, bairro, rua, num_rua, complemento, telefone, email, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nome);
        stmt.setString(2, cpf);
        stmt.setDate(3, java.sql.Date.valueOf(dataNascimento)); 
        stmt.setString(4, cep);
        stmt.setString(5, estado);
        stmt.setString(6, cidade);
        stmt.setString(7, bairro);
        stmt.setString(8, rua);
        stmt.setString(9, numRua);
        stmt.setString(10, complemento);
        stmt.setString(11, telefone);
        stmt.setString(12, email);
        stmt.setString(13, status); 

        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum cliente foi adicionado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao adicionar cliente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}

public String[] preencherAtualizarCliente(int id) {
    String[] vetor = new String[13];
    String sql = "SELECT * FROM clientes WHERE id = ?";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, id);
        
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {    
                vetor[0] = rs.getString("nome");
                vetor[1] = rs.getString("cpf");
                vetor[2] = rs.getString("data_nascimento");
                vetor[3] = rs.getString("cep");
                vetor[4] = rs.getString("estado");
                vetor[5] = rs.getString("cidade");
                vetor[6] = rs.getString("bairro");
                vetor[7] = rs.getString("rua");
                vetor[8] = rs.getString("num_rua");
                vetor[9] = rs.getString("complemento");
                vetor[10] = rs.getString("telefone");
                vetor[11] = rs.getString("email");
                vetor[12] = rs.getString("ativo"); 
            }
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao consultar banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    return vetor;
}

public void updateCliente(String nome, String cpf, String dataNascimento, String cep,String estado, String cidade, String bairro, String rua,String numRua, String complemento, String telefone, String email,String status, int id) {

    String sql = "UPDATE clientes SET nome = ?, cpf = ?, data_nascimento = ?, cep = ?, estado = ?, cidade = ?, bairro = ?, rua = ?, num_rua = ?, complemento = ?, telefone = ?, email = ?, ativo = ? WHERE id = ?";

    try (Connection conn = ConexaoMySQL.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nome);
        stmt.setString(2, cpf);
        stmt.setString(3, dataNascimento); 
        stmt.setString(4, cep);
        stmt.setString(5, estado);
        stmt.setString(6, cidade);
        stmt.setString(7, bairro);
        stmt.setString(8, rua);
        stmt.setString(9, numRua);
        stmt.setString(10, complemento != null ? complemento : ""); 
        stmt.setString(11, telefone);
        stmt.setString(12, email);
        stmt.setString(13, status);
        stmt.setInt(14, id);

        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum cliente foi atualizado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao consultar banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}

public boolean removeCliente(int idCliente) {
    String sqlUpdatePedidos = "UPDATE registros_pedidos SET id_cliente = NULL WHERE id_cliente = ?";
    String sqlDeleteCliente = "DELETE FROM clientes WHERE id = ?";

    try (Connection conn = ConexaoMySQL.getConnection()) {
        conn.setAutoCommit(false); 

        try (PreparedStatement stmtUpd = conn.prepareStatement(sqlUpdatePedidos);
             PreparedStatement stmtDel = conn.prepareStatement(sqlDeleteCliente)) {

            
            stmtUpd.setInt(1, idCliente);
            stmtUpd.executeUpdate();

            
            stmtDel.setInt(1, idCliente);
            int rowsAffected = stmtDel.executeUpdate();

            conn.commit();
            return rowsAffected > 0;
        } catch (SQLException e) {
            conn.rollback();
            JOptionPane.showMessageDialog(null,
                "Erro ao remover cliente: " + e.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,
            "Erro ao conectar ao banco: " + e.getMessage(),
            "Erro", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}

public List<Object[]> searchClientes(String filtro, String valor) {
    List<Object[]> clientes = new ArrayList<>();

    String sql;

    switch (filtro) {
        case "Nome":
            sql = "SELECT * FROM clientes WHERE nome LIKE ?";
            break;
        case "CPF":
            sql = "SELECT * FROM clientes WHERE cpf LIKE ?";
            break;
        case "ID":
            sql = "SELECT * FROM clientes WHERE CAST(id AS CHAR) LIKE ?";
            break;
        case "Sem filtro":
        default:
            sql = "SELECT * FROM clientes " +
                  "WHERE nome LIKE ? " +
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
        } else {
            stmt.setString(1, like);
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Object[] linha = {
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("data_nascimento"),
                rs.getString("cep"),
                rs.getString("telefone"),
                rs.getString("email"),
                rs.getString("ativo")
            };
            clientes.add(linha);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return clientes;
}

}

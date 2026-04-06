package CONTROLLER;

import java.util.List;

import MODEL.itens_PedidosDB;

public class Itens_Pedidos {
    
public List<Object[]> getAllItensPedidoController(int id) {
    itens_PedidosDB ip = new itens_PedidosDB();
    return ip.getAllItensPedido(id);
}

public boolean removeItemPedidoController(int id) {
    itens_PedidosDB ip = new itens_PedidosDB();
    return ip.removeItemPedido(id);
}

public void addItemPedidoController(int idPedido, String nomeProduto, int quantidade) {
        itens_PedidosDB ip = new itens_PedidosDB();
        ip.addItemPedido(idPedido, nomeProduto, quantidade);
    }

public Object[] getDetalhesItemParaTabelaController(String nomeProduto, int quantidade) {
    // Instancia a classe responsável pela comunicação com o banco
    // (Ajuste o nome 'itens_PedidosDB' se você tiver colocado a função em outra classe, como 'produtosDB')
    itens_PedidosDB ip = new itens_PedidosDB(); 
    
    // Chama o método do banco passando os parâmetros e retorna o resultado para a View
    return ip.getDetalhesItemParaTabela(nomeProduto, quantidade);
}

public boolean inserirItemDiretoController(int idPedido, int idProduto, int quantidade, double subtotal) {
    // Instancia a classe que fala com o banco de dados dos Itens
    itens_PedidosDB ip = new itens_PedidosDB();
    
    // Manda inserir e retorna true se deu certo, ou false se deu erro
    return ip.inserirItemDireto(idPedido, idProduto, quantidade, subtotal);
}

}

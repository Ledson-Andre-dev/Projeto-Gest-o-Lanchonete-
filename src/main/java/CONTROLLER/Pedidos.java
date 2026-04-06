package CONTROLLER;

import java.util.List;

import MODEL.PedidosDB;

public class Pedidos {


public Integer getUltimoPedidoVazioController() {
    PedidosDB p = new PedidosDB();
    return p.getUltimoPedidoVazio();
}

public void atualizarPedidoController(int idPedido, Integer idCliente, String nome, double valorPedido, String situacao) {
        PedidosDB p = new PedidosDB();
        p.atualizarPedido(idPedido, idCliente, nome, valorPedido, situacao);
    }

public Object[] buscarIDeNomeClienteController(String cpf) {
    PedidosDB p = new PedidosDB();
    return p.buscarIDeNomeCliente(cpf);
}

public List<Object[]> getAllPedidosController() {
        PedidosDB p = new PedidosDB();
        return p.getAllPedidos();
    }

public boolean removePedidoController(int id) {
        PedidosDB p = new PedidosDB();
        return p.removePedido(id);
    }

public List<Object[]> searchPedidosController(String filtro, String valor) {
        PedidosDB p = new PedidosDB();
        return p.searchPedidos(filtro, valor);
    }

public String[] preencherAtualizarPedidoController(int idPedido) {
    PedidosDB p = new PedidosDB();
    return p.preencherAtualizarPedido(idPedido);
}

public int criarPedidoRetornandoIdController(Integer idCliente, String nomeCliente, double valorTotal, String situacao) {
    // Instancia a classe que fala com o banco de dados dos Pedidos
    // (Ajuste "pedidoDB" para o nome exato da sua classe DB, se for diferente)
    PedidosDB p = new PedidosDB(); 
    
    // Chama a função do banco e retorna o ID gerado direto para a View
    return p.criarPedidoRetornandoId(idCliente, nomeCliente, valorTotal, situacao);
}

}

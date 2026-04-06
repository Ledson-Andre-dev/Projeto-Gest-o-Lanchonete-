package CONTROLLER;

import MODEL.RegistrosDB;
import java.util.List;

public class Registros {
    public Registros(){}

    public List<Object[]> getAllRegistrosPedidosController() {
        RegistrosDB rdb = new RegistrosDB();
        return rdb.getAllRegistrosPedidos();
    }

    public List<Object[]> searchRegistrosPedidosController(String filtro, String valor) {
        RegistrosDB rdb = new RegistrosDB();
        return rdb.searchRegistrosPedidos(filtro, valor);
    }

    public boolean removeRegistroPedidoController(int id) {
        RegistrosDB rdb = new RegistrosDB();
        return rdb.removeRegistroPedido(id);
    }

    public List<Object[]> getAllRegistrosProdutosController() {
        RegistrosDB rdb = new RegistrosDB();
        return rdb.getAllRegistrosProdutos();
    }

    public List<Object[]> searchRegistrosProdutosController(String filtro, String valor) {
        RegistrosDB rdb = new RegistrosDB();
        return rdb.searchRegistrosProdutos(filtro, valor);
    }

    public boolean removeRegistroProdutoController(int id) {
        RegistrosDB rdb = new RegistrosDB();
        return rdb.removeRegistroProduto(id);
    }
    
}

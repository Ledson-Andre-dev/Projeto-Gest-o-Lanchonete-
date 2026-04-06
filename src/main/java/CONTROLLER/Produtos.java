package CONTROLLER;
import java.util.List;

import MODEL.ProdutosDB;

public class Produtos {

public List<Object[]> getAllProdutosController() {
        ProdutosDB p = new ProdutosDB();
        return p.getAllProdutos();
    }

public boolean removeProdutoController(int id) {
        ProdutosDB p = new ProdutosDB();
        return p.removeProduto(id);
    }

public List<Object[]> searchProdutosController(String filtro, String valor) {
        ProdutosDB p = new ProdutosDB();
        return p.searchProdutos(filtro, valor);
    }

public void addProdutoController(String nome, double preco, String categoria, String descricao, String status, String caminhoImagem, Integer idFuncionario){
        ProdutosDB p = new ProdutosDB();
        p.addProduto(nome, preco, categoria, descricao, status, caminhoImagem,idFuncionario);
    }

public void updateProduto(String nome, double preco, String categoria, String descricao, String status, String caminhoImagem, int id,Integer idFuncionario) {
ProdutosDB p = new ProdutosDB();
p.updateProduto(nome, preco, categoria, descricao, status, caminhoImagem, id,idFuncionario);
}

public String[] preencherAtualizarProduto(int id) {
ProdutosDB p = new ProdutosDB();
return p.preencherAtualizarProduto(id);
}

public String[] getDescricaoECaminhoImagemController(int id) {
ProdutosDB p = new ProdutosDB();
return p.getDescricaoECaminhoImagem(id);
}

}


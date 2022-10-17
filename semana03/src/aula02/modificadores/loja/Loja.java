package aula02.modificadores.loja;

import aula02.modificadores.produto.Produto;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    // [produto]
    List<Produto> listaProdutos = new ArrayList<>();

    //default
    //void não tem retorno
    void adicionaProduto(Produto produto){
        //produto existe
        //produtos existe
        listaProdutos.add(produto);
    }

    // Modificador | Tipo de Retorno | Nome | Parametros
    public Produto removeProdutoPorId(int id){ //  Assinatura do método
        //produto não existe
        //produtos existe

        // corpo de execução do método
        Produto resultado = listaProdutos.remove(id);
        return resultado;
    }
}


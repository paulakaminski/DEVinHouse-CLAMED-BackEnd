package aula02.loja;

import aula02.produto.Produto;

public class MainLoja {
    public static void main(String[] args) {
        Loja lojaObjeto = new Loja();
        System.out.println(lojaObjeto.listaProdutos);
        //                          produto
        lojaObjeto.adicionaProduto(new Produto());

        Produto pastaProduto = new Produto();
        pastaProduto.nome = "Pasta de Dente";
        lojaObjeto.adicionaProduto(pastaProduto);
        System.out.println(lojaObjeto.listaProdutos);

        lojaObjeto.removeProdutoPorId(0);
        System.out.println(lojaObjeto.listaProdutos);
    }
}

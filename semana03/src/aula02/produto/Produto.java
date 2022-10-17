package aula02.produto;

public class Produto {
    //Classe Produto, nome, data vencimento, preço
    String nome;
    String dataVcto;
    Double preco;

    //método verifica vencimento, retorna a data de vencimento
    public void verificaVcto(Integer mes, Integer ano) {
        Integer mesVcto = Integer.parseInt(this.dataVcto.substring(0, 2));
        Integer anoVcto = Integer.parseInt(this.dataVcto.substring(3, 7));

        if (mesVcto < mes && anoVcto < ano) {
            System.out.println("Produto vencido");
        } else {
            System.out.println("Produto dentro da validade");
        }
    }

    //2 construtores, 1 vazio e 1 com todos os atributos
    public Produto() {
    }

    public Produto(String nome, String dataVcto, Double preco) {
        this.nome = nome;
        this.dataVcto = dataVcto;
        this.preco = preco;
    }
}


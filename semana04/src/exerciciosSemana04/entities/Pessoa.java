//exercicio 01
//Vamos criar um sistema de gerenciamento das pessoas que participam do DEVinHouse, alunos, mentores e coordenadores.
// Crie uma superclasse "pessoa" com os atributos básicos nome e idade. Lembre-se dos construtores, getters e setters.

//exercicio 03
//Crie um método na superclasse para obter as informações da pessoa. Este método pode se chamar obterInformacoes().
// Utilize a mesma identificação do método nas subclasses.

package exerciciosSemana04.entities;

public class Pessoa {
    //atributos
    private String nome;
    private Integer idade;

    //construtor padrão
    public Pessoa(){}

    //construtor argumentos
    public Pessoa(String nome, Integer idade){
        this.nome = nome;
        this.idade = idade;
    }

    //getters e setters
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Integer getIdade(){
        return idade;
    }

    public void setIdade(Integer idade){
        this.idade = idade;
    }

    //métodos
    //exercicio 03
    public void obterInformacoes() {
        if ((nome == null) || (nome.isEmpty() == true || (nome.split(" ").length < 2))) {
            throw new IllegalArgumentException("Deve ser informado o nome completo.");
        } else {
            System.out.println("Informações da Pessoa:");
            System.out.println("Nome: " + nome + "\nIdade: " + idade);
        }
    }
}

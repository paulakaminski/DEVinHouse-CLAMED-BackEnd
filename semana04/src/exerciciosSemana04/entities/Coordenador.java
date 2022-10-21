//exercicio 02
//Agora que temos a superclasse pessoa, crie subclasses para cada tipo de participante do DEVinHouse:
// 1. Aluno (atributos: curso, matricula);
// 2. Mentor (atributos: linguagemDeProgramacao);
// 3. Coordenador (atributos: quantidadeCursosCoord).
// Cada subclasse deve herdar os atributos e métodos da superclasse e adicionar os atributos de cada subclasse.
// Lembre-se dos construtores, getters e setters.

//exercicio 03
//Crie um método na superclasse para obter as informações da pessoa. Este método pode se chamar obterInformacoes().
// Utilize a mesma identificação do método nas subclasses.

package exerciciosSemana04.entities;

public class Coordenador extends Pessoa {
    //atributos
    private Integer qtdeCursosCoord;

    //construtor padrao
    public Coordenador(){
        super();
    }

    //construtor argumentos
    public Coordenador(String nome, Integer idade, Integer qtdeCursosCoord){
        super(nome, idade);
        this.qtdeCursosCoord = qtdeCursosCoord;
    }

    //getters e setters
    public Integer getQtdeCursosCoord(){
        return qtdeCursosCoord;
    }

    public void setQtdeCursosCoord(Integer qtdeCursosCoord){
        this.qtdeCursosCoord = qtdeCursosCoord;
    }

    //métodos
    //exercicio 03

    @Override
    public void obterInformacoes(){
        if ((getNome() == null) || (getNome().isEmpty() == true) || (getNome().split(" ").length < 2)) {
            throw new IllegalArgumentException("Deve ser informado o nome completo.");
        } else {System.out.println("Informações do Coordenador:");
            System.out.println("Nome: " + getNome() + "\nIdade: " + getIdade() + "\nQuantidade de cursos coordenados: " + qtdeCursosCoord);
        }
    }
}

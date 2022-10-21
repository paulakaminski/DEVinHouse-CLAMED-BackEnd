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

public class Aluno extends Pessoa{
    //atributos
    private String curso;
    private Integer matricula;

    //construtor padrão
    public Aluno(){
        super();
    }

    //construtor argumentos
    public Aluno(String nome, Integer idade, String curso, Integer matricula){
        super(nome, idade);
        this.curso = curso;
        this.matricula = matricula;
    }

    //getters e setters
    public String getCurso(){
        return curso;
    }

    public void setCurso(String curso){
        this.curso = curso;
    }

    public Integer getMatricula(){
        return matricula;
    }

    public void setMatricula(Integer matricula){
        this.matricula = matricula;
    }

    //métodos
    //exercicio 03
    @Override
    public void obterInformacoes() {
        if ((getNome() == null) || (getNome().isEmpty() == true) || (getNome().split(" ").length < 2)) {
            throw new IllegalArgumentException("Deve ser informado o nome completo.");
        } else {
            System.out.println("Informações do Aluno:");
            System.out.println("Nome: " + getNome() + "\nIdade: " + getIdade() + "\nCurso: " + curso + "\nMatrícula: " + matricula);
        }
    }
}

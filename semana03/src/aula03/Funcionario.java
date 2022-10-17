package aula03;

public class Funcionario {
    //Atributos
    private String nome;
    private String funcional;
    private Double salario;
    private Double saldo;

    //Constutores

    //Construtor vazio ou default
    Funcionario(){}

    //Construtores com parametros
    public Funcionario(String nome, String funcional, Double salario){
        this.nome = nome;
        this.funcional = funcional;
        this.salario = salario;
    }

    public Funcionario(String nome, String funcional){
        this.nome = nome;
        this.funcional = funcional;
    }

    //Métodos

    // modificador(public) / tipo(string) / nome(addValorNome) / parametros(dentro dos parenteses)
    public String addValorNome(String novoNome){
        this.nome = novoNome;
        return this.nome;
    }

//    public Double recebeSalario(){
//        return saldo += salario;
//    }

    //Getter e Setter sempre serão assim conforme abaixo
    public String getNome(){
        return nome;
    }

    public String getFuncional(){
        return funcional;
    }

    public Double getSalario(){
        return salario;
    }

    public Double getSaldo(){
        return saldo;
    }


    public void setNome(String nome){
    this.nome = nome;
    }
}

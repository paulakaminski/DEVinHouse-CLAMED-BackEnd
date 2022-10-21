//exercicio de fixação
//Uma empresa possui funcionários próprios e terceirizados. Para cada funcionário, deseja-se registrar nome,
// horas trabalhadas e valor por hora. Funcionários terceirizados possuem uma despesa adicional.
// O pagamento dos funcionários é correspondente ao valor da hora trabalho multiplicado pelas horas trabalhadas.
// Os funcionários terceirizados recebem um bônus de 10% do valor de sua despesa adicional.
// Vamos criar um programa para ler os dados de N funcionários (quantidade a ser fornecida pelo usuário) e
// armazená-los em uma lista. Em seguida, vamos apresentar todos os dados (nome e pagamento) de cada funcionário,
// na ordem em que foram digitados.
// Entidades: Funcionario - nome, horas, valorPorHora - pagamento();
// FuncionarioTerc - subclasse de funcionario, + despesaAdicional.
// obs: começar escrevendo as classes. depois escrever o programa.


package aula02.entities;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private String nome;
    protected Double horasMes;
    protected Double valorHora;

    public Funcionario(){}

    public Funcionario(String nome, Double horasMes, Double valorHora){
        this.nome = nome;
        this.horasMes = horasMes;
        this.valorHora = valorHora;
    }

    public String getNome() {
        return nome;
    }

    public Double getHorasMes() {
        return horasMes;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHorasMes(Double horasMes) {
        this.horasMes = horasMes;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public Double pagamento(){
        Double valorPagamento = horasMes*valorHora;
        return valorPagamento;
    }
}

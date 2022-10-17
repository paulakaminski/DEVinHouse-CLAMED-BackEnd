//Exercicio 01
//Vamos criar um sistema para uma Clinica de Emagrecimento.
// Crie uma classe Cliente que contenha os atributos peso, altura e idade.

//Exercicio 02
//Crie um método que calcule o IMC de uma pessoa. O IMC é calculado pela formula IMC = peso / (altura)².
// Esse método deve retorna o IMC com base na tabela em anexo.

//exercicio 05
//Adicione um encpasulamento nas classes criadas anteriormente.

//Exercicio 06
//Adicionar construtores e cada classe anterior. Adicione na Classe Cliente um construtor que receba apenas altura
// e peso e um construtor que receba todos os atributos.

package ExerciciosSemana03;

//exercicio 01
public class Cliente {
    //atributos
    private String nome;
    private Double peso;
    private Double altura;
    private Integer idade;

    //exercicio 02
    //métodos
    public String Imc() {
        Double resultado = peso / (altura * altura);

        if (resultado < 18.5) {
            return "Muito magro";
        } else if (resultado <= 24.9) {
            return "Normal";
        } else if (resultado <= 29.9) {
            return "Sobrepeso";
        } else if (resultado <= 34.9) {
            return "Obeso grau I";
        } else if (resultado <= 39.9) {
            return "Obeso grau II";
        } else {
            return "Obeso grau III ou mórbido";
        }
    }

    //exercicio 05
    //getters
    public String getNome() {
        return nome;
    }

    public Double getPeso() {
        return peso;
    }

    public Double getAltura() {
        return altura;
    }

    public Integer getIdade() {
        return idade;
    }

    //setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    //exercício 06
    //construtores
    public Cliente() {
    }

    public Cliente(Double altura, Double peso) {
        this.altura = altura;
        this.peso = peso;
    }

    public Cliente(String nome, Double peso, Double altura, Integer idade) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
    }
}


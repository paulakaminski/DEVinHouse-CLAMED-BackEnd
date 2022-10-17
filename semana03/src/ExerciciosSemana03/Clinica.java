//exercicio 03
//Crie uma Classe chamada Clinica, que deve ter os atributo: Lista de Clientes e deve ter o nome do dono da Clinica.

//exercicio 04
//Crie um método na Classe Clinicia chamado Categorizar Clientes, esse método deve exibir cada Cliente na tela e
// ao lado do cliente deve exibir também o seu IMC. Os Cliente devem ser agrupados pelo IMC.

//exercicio 05
//Adicione um encpasulamento nas classes criadas anteriormente.

//exercicio 06
//Adicioner construtores e cada classe anterior. Adicione na Classe Clinica um construtor que recebe apenas o
// nome do dono e um construtor que rebe o nome do dono e um Lista de Clientes.

//Exercicio 07
//Crie um método chamado tratamento que receba um Cliente, esse método vai reduzir o peso do Cliente em 5 quilos
// e após isso irá retornar o novo peso do Cliente.

//Exercicio 08
//Crie um método chamado tratamento que receba um Cliente e um valor numérico, esse método vai reduzir o peso do
// Cliente pelo valor recebido no método e após isso irá retornar o novo peso do Cliente.

package ExerciciosSemana03;

import java.util.ArrayList;
import java.util.List;

//exercicio 03
public class Clinica {
    //atributos
    private List<Cliente> listaClientes = new ArrayList<>();
    private String donoClinica;


    //métodos
    //exercicio 04
    public void categorizarClientes() {
        List<Cliente> categoriaMuitoMagro = new ArrayList<>();
        List<Cliente> categoriaNormal = new ArrayList<>();
        List<Cliente> categoriaSobrepeso = new ArrayList<>();
        List<Cliente> categoriaObesoI = new ArrayList<>();
        List<Cliente> categoriaObesoII = new ArrayList<>();
        List<Cliente> categoriaObesoIII = new ArrayList<>();

        for (Cliente cliente : listaClientes) {
            switch (cliente.Imc()) {
                case "Muito magro":
                    categoriaMuitoMagro.add(cliente);
                    break;
                case "Normal":
                    categoriaNormal.add(cliente);
                    break;
                case "Sobrepeso":
                    categoriaSobrepeso.add(cliente);
                    break;
                case "Obeso grau I":
                    categoriaObesoI.add(cliente);
                    break;
                case "Obeso grau II":
                    categoriaObesoII.add(cliente);
                    break;
                case "Obeso grau III ou mórbido":
                    categoriaObesoIII.add(cliente);
                    break;
            }
        }
        categoriaMuitoMagro.forEach(cliente -> System.out.println("Categoria: Muito magro" + "\n" + cliente.getNome() + " - " + cliente.Imc()));
        categoriaNormal.forEach(cliente -> System.out.println("Categoria: Normal" + "\n" + cliente.getNome() + " - " + "IMC " + cliente.Imc()));
        categoriaSobrepeso.forEach(cliente -> System.out.println("Categoria: Sobrepeso" + "\n" + cliente.getNome() + " - " + "IMC " + cliente.Imc()));
        categoriaObesoI.forEach(cliente -> System.out.println("Categoria: Obeso grau I" + "\n" + cliente.getNome() + " - " + "IMC " + cliente.Imc()));
        categoriaObesoII.forEach(cliente -> System.out.println("Categoria: obeso grau II" + "\n" + cliente.getNome() + " - " + "IMC " + cliente.Imc()));
        categoriaObesoIII.forEach(cliente -> System.out.println("Categoria: Obeso grau III" + "\n" + cliente.getNome() + " - " + "IMC " + cliente.Imc()));
    }

    //exercicio 07
    public Double Tratamento(Cliente cliente) {
        cliente.setPeso(cliente.getPeso() - 5.0);
        return cliente.getPeso();
    }

    public Double Tratamento(Cliente cliente, Double pesoReduzir) {
        cliente.setPeso(cliente.getPeso() - pesoReduzir);
        return cliente.getPeso();
    }

    //exercicio 05
    //getters
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public String getDonoClinica() {
        return donoClinica;
    }

    //setters
    public void setListaClientes(Cliente cliente) {
        this.listaClientes = listaClientes;
    }

    public void setDonoClinica(String donoClinica) {
        this.donoClinica = donoClinica;
    }

    //exercicio 06
    //construtores
    public Clinica() {
    }

    public Clinica(String donoClinica) {
        this.donoClinica = donoClinica;
    }

    public Clinica(String donoClinica, List<Cliente> listaClientes) {
        this.donoClinica = donoClinica;
        this.listaClientes = listaClientes;
    }
}

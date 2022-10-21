package aula02.application;

import aula02.entities.Funcionario;
import aula02.entities.FuncionarioTerc;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Funcionario> listaDeFuncionarios = new ArrayList();

        Funcionario funcionario = new Funcionario("Paula", 220.0, 25.0);
        Funcionario funcionario1 = new FuncionarioTerc("Marcel", 220.0, 25.0,0.10);

        listaDeFuncionarios.add(funcionario);
        listaDeFuncionarios.add(funcionario1);

        listaDeFuncionarios.forEach(f -> System.out.println("Funcionário: " + f.getNome() + " - Valor do pagamento: " + f.pagamento()));
    }
}

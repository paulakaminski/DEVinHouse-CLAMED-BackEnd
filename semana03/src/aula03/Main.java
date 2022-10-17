package aula03;

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        Funcionario funcionario2 = new Funcionario("Paula", "10731", 5500.00);
        Funcionario funcionario3 = new Funcionario("Teste", "10731");

        funcionario.addValorNome("Marcel");
//        funcionario2.recebeSalario();

        System.out.println("Nome do funcionário: "+ funcionario.getNome());
        System.out.println("Nome do funcionário: "+ funcionario2.getNome());
        System.out.println("Saldo do funcionário: "+ funcionario2.getSaldo());
        System.out.println("Nome do funcionário: "+ funcionario3.getNome());

        System.out.println(funcionario);
    }
}

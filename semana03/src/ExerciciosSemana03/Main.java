package ExerciciosSemana03;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Paula");
        cliente.setPeso(67.0);
        cliente.setAltura(1.69);
        cliente.setIdade(30);

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Marcel");
        cliente1.setPeso(110.0);
        cliente1.setAltura(1.83);
        cliente1.setIdade(29);

        Clinica clinica = new Clinica();
        clinica.getListaClientes().add(cliente);
        clinica.getListaClientes().add(cliente1);

        clinica.categorizarClientes();

        System.out.println("Peso ideal após tratamento: " + clinica.Tratamento(cliente));
        System.out.println("Peso ideal após tratamento: " + clinica.Tratamento(cliente1, 30.0));

        System.out.println("IMC após tratamento:");
        clinica.categorizarClientes();
    }
}

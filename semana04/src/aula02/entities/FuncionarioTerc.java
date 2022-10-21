package aula02.entities;

public class FuncionarioTerc extends Funcionario {
    private Double despesaAdicional;

    public FuncionarioTerc(){
        super();
    }

    public FuncionarioTerc(String nome, Double horasMes, Double valorHora, Double despesaAdicional){
        super(nome, horasMes, valorHora);
        this.despesaAdicional = despesaAdicional;
    }

    public Double getDespesaAdicional() {
        return despesaAdicional;
    }

    public void setDespesaAdicional(Double despesaAdicional) {
        this.despesaAdicional = despesaAdicional;
    }

    @Override
    public Double pagamento(){
        Double valorAdicional = horasMes*valorHora*despesaAdicional;
        Double valorPagamento = horasMes*valorHora+valorAdicional;
        return valorPagamento;
    }
}

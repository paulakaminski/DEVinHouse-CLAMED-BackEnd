package aula01.entities;

//subclasse
//           Classe atual      -     classe que está sendo recebida como herança
public class BusinessAccount extends Account {

    //essa classe possui limite de empréstimo
    private Double loanLimit;

    public BusinessAccount(){
        //vale a pena inserir o construtor padrão por questões futuras
        super(); //tudo o que colocar de lógica na superclasse, herda aqui tbm com o super
    }

    public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit){
        super(number, holder, balance); //está pegando os atributos da superclasse
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    //métodos
    public void loan(Double amount){
        if(amount <= loanLimit){
            deposit(amount);
        }
    }

    public void withdraw(Double amount){
        balance -= amount + 2;
    }
}

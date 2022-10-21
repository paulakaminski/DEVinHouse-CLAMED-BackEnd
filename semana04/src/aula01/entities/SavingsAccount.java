package aula01.entities;

//subclasse
public class SavingsAccount extends Account {
    private Double interestRate;

    public SavingsAccount(){
        super();
    }

    public SavingsAccount(Integer number, String holder, Double balance, Double interestRate){
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public Double getInterestRate(){
        return interestRate;
    }

    public void setInterestRate(){
        this.interestRate = interestRate;
    }

    //métodos
    public void updateBalance(){
        balance += balance * interestRate;
    }

    @Override
    public void withdraw(Double amount){
        balance -= amount;
    }
}

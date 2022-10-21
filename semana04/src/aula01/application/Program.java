package aula01.application;

import aula01.entities.Account;
import aula01.entities.BusinessAccount;
import aula01.entities.SavingsAccount;

public class Program {
    public static void main(String[] args) {
        //upcast - no exemplo abaixo a variável bacc foi instanciada na classe filha, e foi transformada na superclasse (account)
        BusinessAccount bacc = new BusinessAccount(1000, "Natalia", 0.0, 500.0);
        Account acc = bacc;

        //acc.setLoanLimit(200.00); não é possível, pq agora ela é uma Account
        bacc.setLoanLimit(200.00); //nesse caso é possível, pq foi tipada como BusinessAccounts

        Account acc1 = new Account(1001, "Jose", 1000.0);
        Account acc2 = new BusinessAccount(1002, "Fred", 0.0, 200.00);
        Account acc3 = new SavingsAccount(1003, "Bryan", 500.0, 0.01);

        //downcast - no exemplo abaixo as contas estão descendo para os filhos da conta padrão (account)
        SavingsAccount accs = (SavingsAccount) acc3;
        System.out.println(accs.getInterestRate());

        BusinessAccount acc4 = (BusinessAccount) acc2;
        acc4.setLoanLimit(2000.0);
        acc4.loan(500.0);
        System.out.println(acc4.getBalance());

        acc4.withdraw(100.0);
        System.out.println(acc4.getBalance());

        //testes sobrescrita
        acc1.withdraw(250.0);
        System.out.println(acc1.getBalance());

        acc3.withdraw(300.00);
        System.out.println(acc3.getBalance());

        acc2.withdraw(200.0);
        System.out.println(acc2.getBalance());

    }
}

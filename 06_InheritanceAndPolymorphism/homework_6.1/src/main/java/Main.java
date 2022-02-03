public class Main {

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();
        bankAccount.put(70000.0);
        bankAccount.take(12000.0);
        System.out.println("Баланс: " + bankAccount.getAmount()+ "\n");


        CardAccount cardAccount = new CardAccount();
        cardAccount.put(560000.0);
        cardAccount.take(84000.0);
        System.out.println("Баланс: " + cardAccount.getAmount() + "\n");

        DepositAccount depositAccount = new DepositAccount();
        depositAccount.put(10000.0);
        System.out.println(depositAccount.getLastIncome());
        depositAccount.take(300000.0);
        System.out.println("Баланс: " + depositAccount.getAmount()+ "\n");

        System.out.println(
        bankAccount.sendMoney(cardAccount,4000.0) + "\t" +
        cardAccount.sendMoney(depositAccount,47000.0)+ "\t" +
        depositAccount.sendMoney(bankAccount,3000.0));





    }
}

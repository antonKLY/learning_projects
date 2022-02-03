public class CardAccount extends BankAccount {

    public CardAccount(){
        super();
    }

    public boolean take(double amountToTake) {
            return super.take(amountToTake + amountToTake * TRANSACTIONS_PERCENT);
    }

}

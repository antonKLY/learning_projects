import java.time.LocalDate;
public class DepositAccount extends BankAccount {

    public DepositAccount(){
        super();
    }

    public boolean put(double amountToPut){
        return super.put(amountToPut);
    }

    public boolean take(double amountToTake) {
        boolean canTake = monthFromLastPut();
        if (canTake) {
            return super.take(amountToTake);
        }
        System.out.println("Невозможно снять деньги");
        return false;
    }
}

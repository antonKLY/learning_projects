import java.time.LocalDate;

public class BankAccount {

  protected double balance;
  private LocalDate lastIncome ;
  private boolean canTakeMoney;
  private boolean canPutMoney;
  protected static final double TRANSACTIONS_PERCENT = 0.01;

  public BankAccount(){
   balance = 0;
  }

  public double getAmount() {
    return balance;
  }

  public boolean monthFromLastPut(){
    return lastIncome.plusMonths(1).isBefore(LocalDate.now());
  }

  public LocalDate getLastIncome(){
    return lastIncome;
  }

  public boolean put(double amountToPut) {
    canPutMoney = amountToPut >= 0;
    if (canPutMoney){
      lastIncome = LocalDate.now();
      balance += amountToPut;
      System.out.println("Баланс пополнен на сумму: " + amountToPut);
      return true;
    }
    return false;
  }

  public boolean take(double amountToTake) {
    canTakeMoney = amountToTake <= balance && amountToTake > 0;
    if (canTakeMoney){
      balance -= amountToTake;
      System.out.println("Со счёта снято: " + amountToTake);
      return true;
    }
    return false;
  }

  public boolean sendMoney(BankAccount accountName , double amountToSend){
    if (take(amountToSend)) {
      accountName.put(amountToSend);
      return true;
    } return false;
  }
}

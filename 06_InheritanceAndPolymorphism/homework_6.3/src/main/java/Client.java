public abstract class Client {

    private double balance;


    abstract String information();

    public boolean put(double amountToPut){
        boolean canPutMoney = amountToPut >= 0;
        if (canPutMoney){
            balance += amountToPut;
            return true;
        }
        return false;
    }

    public boolean take(double amountToTake){
        boolean canTakeMoney = amountToTake <= balance && amountToTake > 0;
        if (canTakeMoney){
            balance -= amountToTake;
            return true;
        }
        return false;
    }

    public double getAmount(){
        return balance;
    }



}

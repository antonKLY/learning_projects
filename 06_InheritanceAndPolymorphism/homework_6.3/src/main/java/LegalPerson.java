public class LegalPerson extends Client {

    private static final double TRANSACTIONS_PERCENT = 0.01;

    public LegalPerson(){
        System.out.println(information());
    }


    @Override
    public String information() {
        return "\t\t\t~~~\nПополнение счёта: Без комиссии\n" +
                "Снятие средств: Комиссия 1%\nБаланс: " + getAmount() + "\n\t\t\t~~~";
    }

    public boolean take(double amountToTake){
       return super.take(amountToTake + amountToTake * TRANSACTIONS_PERCENT);
    }
}

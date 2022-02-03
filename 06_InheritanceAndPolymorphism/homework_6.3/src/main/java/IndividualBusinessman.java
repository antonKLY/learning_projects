public class IndividualBusinessman extends Client {

    private static final double HIGH_TRANSACTIONS_PERCENT = 0.01;
    private static final double LOW_TRANSACTIONS_PERCENT = 0.005;

    public IndividualBusinessman(){
        System.out.println(information());
    }

    @Override
    public String information() {
        return "\t\t\t~~~\nПополнение счёта: До 1000р. комиссия "
                + (HIGH_TRANSACTIONS_PERCENT * 100) +  "%, больше 1000р. - "
                + (LOW_TRANSACTIONS_PERCENT * 100) + "%\n" +
                "Снятие средств: Без комиссии\nБаланс: " + getAmount() + "\n\t\t\t~~~";
    }

    public boolean put(double amountToPut) {
        return amountToPut >= 1000 ? super.put(amountToPut - amountToPut * LOW_TRANSACTIONS_PERCENT) :
                super.put(amountToPut - amountToPut * HIGH_TRANSACTIONS_PERCENT);
    }


}

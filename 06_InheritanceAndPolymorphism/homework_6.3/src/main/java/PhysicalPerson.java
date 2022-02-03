public class PhysicalPerson extends Client {

    public PhysicalPerson(){
        System.out.println(information());
    }

    @Override
    public String information() {
        return "\t\t\t~~~\nПополнение счёта: Без комиссии\n" +
                "Снятие средств: Без комиссии\nБаланс: " + getAmount() + "\n\t\t\t~~~";
    }

}

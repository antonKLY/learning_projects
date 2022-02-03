public class Main {
    public static void main(String[] args) {


        PhysicalPerson physicalPerson = new PhysicalPerson();
        LegalPerson legalPerson = new LegalPerson();
        IndividualBusinessman individualBusinessman = new IndividualBusinessman();

        System.out.println(physicalPerson.put(-350000.0));
        System.out.println(legalPerson.put(740000.0));
        System.out.println(individualBusinessman.put(430000.0));

//        System.out.println(physicalPerson.take(240000.0));
        System.out.println(legalPerson.take(87000.0));
        System.out.println(individualBusinessman.take(1750000.0));
        System.out.println();
        System.out.println("Баланс: " + physicalPerson.getAmount());
        System.out.println("Баланс: " + legalPerson.getAmount());
        System.out.println("Баланс: " + individualBusinessman.getAmount());



    }
}

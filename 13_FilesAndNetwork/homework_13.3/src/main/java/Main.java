public class Main {
    public static void main(String[] args) {

        String path = "src/test/resources/movementList.csv";

        Movements movements = new Movements(path);

        movements.printAllOperations();
        movements.getIncomeSum();
        movements.getExpenseSum();
        movements.getCompaniesExpenseFromFile(path);
    }
}

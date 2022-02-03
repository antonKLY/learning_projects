import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Movements {

    private double income,expense;
    private String company;
    List<Movements> listOfMovementOperation = new ArrayList<>();
    Map<String,Double> companiesExpense = new HashMap<>();

    public Movements(String pathMovementsCsv) {
        readLinesFromFile(pathMovementsCsv);
    }

    private Movements (double income, double expense, String company){
        this.income = income;
        this.expense = expense;
        this.company = company;
    }

    private void readLinesFromFile (String pathToFile){
        try {
            List <String> operationList = Files.readAllLines(Paths.get(pathToFile));
            for (String lines : operationList){
                String[] fragments = lines.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if (!fragments[0].equals("Тип счёта")) {
                    listOfMovementOperation.add(
                            new Movements(Double.parseDouble(fragments[6].replaceAll("\"","").replaceAll(",","."))
                            ,Double.parseDouble(fragments[7].replaceAll("\""," ").replaceAll(",","."))
                            ,fragments[5]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        return "\n\n\tСумма доходов: " + income + " руб."
                + "\n\tСумма расходов: "
                + expense + " руб."
                + "\n\tТип операции: " + company;
    }

    public double getExpenseSum() {
        double totalExpense = 0.00;
        for (Movements movements : listOfMovementOperation){
            totalExpense += movements.expense;
        }
        System.out.println("Общая сумма расходов: " + totalExpense);
        return totalExpense;
    }

    public double getIncomeSum() {
        double totalIncome = 0.00;
        for (Movements movements : listOfMovementOperation){
            totalIncome += movements.income;
        }
        System.out.println("Общая сумма прихода: " + totalIncome);
        return totalIncome;
    }

    public void printAllOperations (){
        for (Movements movements : listOfMovementOperation) {
            System.out.println(movements);
        }
    }

    public void getCompaniesExpenseFromFile (String pathToFile){
        try {
            List <String> operationList = Files.readAllLines(Paths.get(pathToFile));
            for (String lines : operationList){
                String[] fragments = lines.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if (fragments[0].equals("Тип счёта") || fragments[7].equals("0")) {
                    continue;
                }
                companiesExpense.put
                        (fragments[5], Double.parseDouble(fragments[7]
                                .replaceAll("\"", " ")
                                .replaceAll(",", ".")));
                for(Map.Entry<String, Double> entry: companiesExpense.entrySet()) {
                    int companyNameBeginIndex = 19;
                    int indexBeforeDate = entry.getKey().indexOf(".") - 2;
                    System.out.println(entry.getKey().substring(companyNameBeginIndex,indexBeforeDate).trim()
                            + "\t\t\t\t" + entry.getValue() + " руб.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

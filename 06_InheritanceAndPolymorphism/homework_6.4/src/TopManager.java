public class TopManager extends OfficeEmployee
        implements Employee
{
    private final double BONUS_PERCENT = 1.5;

    public String toString(){
        return "TopManager{ " + getMonthSalary() +" р. " + getAge() + " y.o }";
    }

    @Override
    public String salaryInfo() {
        return "\t\t\t\t=====\nТоп-менеджер получает фиксированную ставку " + FIX_SALARY_PART + " р."
                + "\nИ " + (BONUS_PERCENT * 100) + "% от заработной платы, " +
                "если компания заработала больше 10 000 000р." +
                "\n\t\t\t\t=====";
    }

    @Override
    public int getMonthSalary() {
        if (company.getIncome() > 10000000) {
            return (int) (FIX_SALARY_PART + (FIX_SALARY_PART * BONUS_PERCENT));
        }
        return FIX_SALARY_PART;
    }

}

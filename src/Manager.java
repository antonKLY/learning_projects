public class Manager extends OfficeEmployee
        implements Employee,EarnMoney {

    private final double BONUS_PERCENT = 0.05;
    private int canEarnMoneyForCompany;

    public String toString(){
        return "Manager{ " + getMonthSalary() +" р. " + getAge() + " y.o }";
    }

    @Override
    public String salaryInfo() {
        return "\t\t\t\t=====\nМенеджер получает фиксированную ставку " + FIX_SALARY_PART + " р."
                + "\nИ " + Math.round(BONUS_PERCENT * 100) + "% от заработаннных для компании денег" +
                "\n\t\t\t\t=====";
    }

    private void earnedMoneyForCompany() {
        int min = 115000;
        int max = 140000;
        max -= min;
        canEarnMoneyForCompany = (int) (Math.random() * ++max) + min;
    }

    @Override
    public int getEarnedMoneyForCompany(){
        return canEarnMoneyForCompany;
    }

    @Override
    public int getMonthSalary() {
        return FIX_SALARY_PART + (int)(getEarnedMoneyForCompany() * BONUS_PERCENT);
    }

    @Override
    public void recruit(Company company) {
        super.recruit(company);
        earnedMoneyForCompany();
    }

}

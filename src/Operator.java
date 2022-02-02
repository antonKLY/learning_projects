public  class Operator extends OfficeEmployee
{
    public String toString(){
        return "Operator{ " + getMonthSalary() +" р. " + getAge() + " y.o }";
    }

    public String salaryInfo() {
        return "\t\t\t\t=====\nОператор получает фиксированную ставку " + FIX_SALARY_PART
                + " р." + "\n\t\t\t\t=====";
    }

    public int getMonthSalary() {
        return FIX_SALARY_PART;
    }




}

abstract class OfficeEmployee implements Employee, Comparable<OfficeEmployee> {

    public final int FIX_SALARY_PART = 80000;
    private int age;
    Company company;

    public abstract String toString();
    public abstract String salaryInfo();
    public abstract int getMonthSalary();

    public OfficeEmployee(){
        setAge();
    }

    public void recruit(Company company) {
        this.company = company;
    }

    private void setAge() {
        int min = 18;
        int max = 65;
        max -= min;
        age = (int) (Math.random() * ++max) + min;
    }
    public int getAge(){
        return age;
    }

    public int compareTo(OfficeEmployee o) {
        return o.getMonthSalary() - this.getMonthSalary();
    }
}

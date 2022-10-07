public class Employee {

    private final String name;
    private int salary;
    private final int workHours;
    private final int hireYear;

    private int bonus;
    private int tax;
    private int salaryIncrease;

    public Employee(String name, int salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public int tax() {
        this.tax = salary > 1000 ? salary * 3 / 100 : 0;
        return tax;
    }

    public int bonus() {
        this.bonus = workHours > 40 ? (workHours - 40) * 30 : 0;
        return bonus;
    }

    public void raiseSalary() {
        int currentYear = 2021;
        this.salaryIncrease = salary;
        int totalWorkedYear = currentYear - hireYear;

        salary += bonus() - tax();
        if (totalWorkedYear < 10) {
            salary += salary * 5 / 100;
        } else if (totalWorkedYear > 9 && totalWorkedYear < 20) {
            salary += salary * 10 / 100;
        } else {
            salary += salary * 15 / 100;
        }
        this.salaryIncrease = salary - salaryIncrease;
    }

    @Override
    public String toString() {
        return  "İsim= " + name +
                "\n Maasi = " + (salary - salaryIncrease) +" TL" +
                "\n Haftalik Calisma saati = " + workHours +" Saat" +
                "\n İse Baslangic yili = " + hireYear +
                "\n Odenecek Vergi = " + tax +" TL" +
                "\n Aldigi Bonus = " + bonus +" TL" +
                "\n Maasina yapilacak zam = " + salaryIncrease +" TL" +
                "\n Veri ve bonusla toplam maaş = " + salary+" TL" ;


    }

    public static void main(String[] args) {
        Employee employee = new Employee("Ahmet Anil DEMIRYUREK" , 15000, 70,2010 );
        employee.raiseSalary();
        System.out.println(employee.toString());
    }
}

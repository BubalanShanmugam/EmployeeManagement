public class Employee {
    private int employeeid;
    private String employeename;
    private double salary;
    private String department;

    public Employee(int employeeid, String employeename,double salary,String department){
        this.employeeid =employeeid;
        this.employeename=employeename;
        this.salary=salary;
        this.department=department;
    }

    public int getEmployeeid(){
        return employeeid;
    }
    public String getEmployeename(){
        return employeename;
    }
    public String getDepartment(){
        return department;
    }
    public double getSalary(){
        return salary;
    }

    @Override
    public String toString(){
        String formattedsalary = String.format("%.2f",this.getSalary());
            return "Employee Id:" + this.employeeid + "   Employee Name:" + this.employeename + "   Employee Department:" + this.department + "  Employee Salary:" + formattedsalary ;
    }
}

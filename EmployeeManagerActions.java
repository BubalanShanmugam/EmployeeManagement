import java.util.*;

public class EmployeeManagerActions {
    public static void start() {
        Scanner scanner = new Scanner(System.in);

        label:
        while (true) {
            System.out.println("1.Add Employee \n2.Remove Employee \n3.Search Employee \n4.Sort Employee \n5.Exit");
            System.out.println("Enter you choice:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    add(scanner);
                    break;
                case 2:
                    remove(scanner);
                    break;
                case 3:
                    search(scanner);
                    break;
                case 4:
                    sorting(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break label;
            }
        }
    }

    public static class Compare implements Comparator<Employee> {

        @Override
        public int compare(Employee emp1, Employee emp2) {
            if (emp1.getEmployeeid() != emp2.getEmployeeid())
                return Integer.compare(emp1.getEmployeeid(), emp2.getEmployeeid());
            return 0;
        }
    }
//    public static class Compare implements Comparator<Employee> {
//
//        @Override
//        public int compare(Employee emp1, Employee emp2) {
//            if (emp1.getSalary() != emp2.getSalary()){
//                return Double.compare(emp1.getSalary(), emp2.getSalary());
//                  }
//                else if (emp1.getEmployeename().compareTo(emp2.getEmployeename()) != 0) {
//                    return emp1.getEmployeename().compareTo(emp2.getEmployeename());
//                }
//                else if (emp1.getDepartment().compareTo(emp2.getDepartment())!=0) {
//                    return emp1.getDepartment().compareTo(emp2.getDepartment());
//                }
//                else{
//                    return Long.compare(emp1.getEmployeeid(), emp2.getEmployeeid());
//                }
//          }
//    }

    public static class NameCompare implements Comparator<Employee> {

        @Override
        public int compare(Employee emp1, Employee emp2) {
            if (emp1.getEmployeename().compareTo(emp2.getEmployeename()) != 0) {
                return emp1.getEmployeename().compareTo(emp2.getEmployeename());
            }
            return 0;
        }
    }

    public static class SalaryCompare implements Comparator<Employee> {

        @Override
        public int compare(Employee emp1, Employee emp2) {
            if (emp1.getSalary() != emp2.getSalary())
                return Double.compare(emp1.getSalary(), emp2.getSalary());

            return 0;
        }
    }

    public static class DepartmentCompare implements Comparator<Employee> {

        @Override
        public int compare(Employee emp1, Employee emp2) {
            if (emp1.getEmployeename().compareTo(emp2.getEmployeename()) != 0) {
                return emp1.getEmployeename().compareTo(emp2.getEmployeename());
            }
            return 0;
        }
    }
    private static void sorting(Scanner scanner) {

//        ArrayList<Employee> employees = new ArrayList<>(EmployeeManager.getEmployeeHashMap().values());
//        Collections.sort(employees,new Compare());//can we use as,  employees.sort(new Compare());

        System.out.println("Sort by ? \n1.ID \n2.Name \n3.Salary \n4.Department");
        int choice = Integer.parseInt(scanner.nextLine());
        ArrayList<Employee> employees = new ArrayList<>(EmployeeManager.getEmployeeHashMap().values());
        if(choice ==1)
            employees.sort(new Compare());//we can use as,  employees.sort(new Compare());
        else if(choice==2)
            employees.sort(new NameCompare());
        else if(choice==3)
            employees.sort(new SalaryCompare());
        else
            employees.sort(new DepartmentCompare());

            for(var i: employees){
                System.out.println(i);
            }
    }

    private static void search(Scanner scanner) {
        System.out.println("Enter the employee ID to search:");
        int empid = Integer.parseInt(scanner.nextLine());

        try{
                Employee employee = EmployeeManager.getEmployeeHashMap().get(empid);
                System.out.println(employee.toString());
        }
        catch (NullPointerException e){
            System.out.println("No employee found !");
        }
    }

    private static void remove(Scanner scanner) {
        System.out.println("Enter the employee ID to delete:");
        int empid = Integer.parseInt(scanner.nextLine());

        if(EmployeeManager.getEmployeeHashMap().containsKey(empid)){
            EmployeeManager.getEmployeeHashMap().remove(empid);
        }
        else{
            System.out.println("No employee found to delete !");
        }
    }

    private static void add(Scanner scanner) {
        System.out.println("Enter the Employee ID :");
        int empid = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the Employee Name :");
        String empname = scanner.nextLine();
        System.out.println("Enter the Employee Salary :");
        long empsalary = Long.parseLong(scanner.nextLine());
        System.out.println("Enter the Employee Department :");
        String  empdept =scanner.nextLine();

        if(!EmployeeManager.getEmployeeHashMap().containsKey(empid)){
            EmployeeManager.getEmployeeHashMap().put(empid,new Employee(empid,empname,empsalary,empdept));
            System.out.println("Employee added successfully !");
        }
    }


}

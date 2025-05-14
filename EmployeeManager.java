import java.util.HashMap;

public class EmployeeManager {

    private static HashMap<Integer,Employee> employeeHashMap = new HashMap<>();

    public static HashMap<Integer,Employee> getEmployeeHashMap(){
        return employeeHashMap;
    }

}

package Model;

import java.io.Serializable;

public class Employee  implements Serializable{
    public int EmployeeId;
    public String EmployeeUsername;
    public String EmployeePasswod;

    public Employee(int EmployeeId,String EmployeeUsername,String EmployeePassword){
        this.EmployeeId = EmployeeId;
        this.EmployeeUsername = EmployeeUsername;
        this.EmployeePasswod = EmployeePassword;
    }
}

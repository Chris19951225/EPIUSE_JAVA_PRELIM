/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;
import java.util.Date;

/**
 *
 * @author Hristian Vitrychenko
 */
public class Worker implements Comparable 
{
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Class Setup     
    public enum Roles
    {
        TRAINEE("Trainee"), EMPLOYEE("Employee"), MANAGER("Manager");
        
        private final String text; 
        
        private Roles(final String text) 
        {
            this.text = text;
        }
        
        @Override
        public String toString() 
        {
            return text;
        }
    }
    
    private String first_name; 
    private String last_name; 
    private Date date_of_birth; 
    private int employee_num; 
    private double salary; 
    private Roles role; 
    private Worker reports_to; 
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Constructors and beans    
    public Worker()
    {
        first_name = ""; 
        last_name = ""; 
        date_of_birth = null; 
        employee_num = 0; 
        salary = 0; 
        role = null; 
        reports_to = null; 
    }
    
    public Worker(String first_name, String last_name, Date date_of_birth, int employee_num, double salary, Roles role, Worker reports_to)
    {
        this.first_name = first_name; 
        this.last_name = last_name; 
        this.date_of_birth = date_of_birth; 
        this.employee_num = employee_num; 
        this.salary = salary; 
        this.role = role; 
        this.reports_to = reports_to; 
    }
    
    public String getFirstName()
    {
        return first_name; 
    }
    
    public void setFirstName(String first_name)
    {
        this.first_name = first_name; 
    }
    
    public String getLastName()
    {
        return last_name; 
    }
    
    public void setLastName(String last_name)
    {
        this.last_name = last_name; 
    }
    
    public Date getBirthDate()
    {
        return date_of_birth; 
    }
    
    public void setBirthDate(Date date_of_birth)
    {
        this.date_of_birth = date_of_birth; 
    }
    
    public int getEmployeeNum()
    {
        return employee_num; 
    }
    
    public void setEmployeeNum(int employee_num)
    {
        this.employee_num = employee_num; 
    }
    
    public double getSalary()
    {
        return salary; 
    }
    
    public void setSalar(double salary)
    {
        this.salary = salary; 
    }
    
    public Roles getRole()
    {
        return role;
    }
    
    public void setRole(Roles role)
    {
        this.role = role; 
    }
    
    public Worker getReportsTo()
    {
        return reports_to; 
    }
    
    public void setReportsTo(Worker reports_to)
    {
        this.reports_to = reports_to; 
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Helping methods 
    
    public void printWorker()
    {
        System.out.println(role.toString() + "'s details:");
        System.out.println(); 
        System.out.println("     Name: " + first_name); 
        System.out.println(); 
        System.out.println("     Surname: " + last_name); 
        System.out.println();
        System.out.println("     Date of birth: " + date_of_birth.toString()); 
        System.out.println(); 
        System.out.println("     Employee number: " + employee_num);
        System.out.println(); 
        System.out.println("     Salary: " + salary);
        System.out.println();
        System.out.println("     Role: " + role.toString());
        System.out.println();
        System.out.println("     Reports to: " + reports_to.getRole().toString()+ " " + reports_to.getFirstName() + " " + reports_to.getLastName());
        System.out.println();
    }
    
    public boolean isLessSalary(double salary)
    {   
        return this.salary < salary; 
    }
    
    public boolean isOlder(Date date)
    {
        return this.date_of_birth.compareTo(date) > 0; 
    }
    
    @Override
    public int compareTo(Object worker) throws ClassCastException 
    {
        if (!(worker instanceof Worker))
        {
            throw new ClassCastException("A Worker object expected.");
        }
        
        int result = 0; 
        double otherWorkerSalary = ((Worker) worker).getSalary(); 
        
        if(this.salary < otherWorkerSalary)
        {
            result = -1; 
        }
        else if(this.salary > otherWorkerSalary)
        {
            result = 1; 
        }
        
        return result;     
    }
    
    public boolean isWorker(int employee_num)
    {
        return this.employee_num == employee_num; 
    }
    
    public boolean isWorker(String last_name)
    {
        return this.last_name.equalsIgnoreCase(last_name); 
    }
}

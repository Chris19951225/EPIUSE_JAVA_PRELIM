/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;
import java.util.Date;

/**
 * created 26/08/2017
 * @author Hristian Vitrychenko
 */
public class Worker implements Comparable 
{
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Class Setup
    
    /**
     * Enumerator to ensure no other roles exist 
     */
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
    
    //Worker details 
    private String first_name; 
    private String last_name; 
    private Date date_of_birth; 
    private int employee_num; 
    private double salary; 
    private Roles role; 
    private Worker reports_to; 
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Constructors and beans

    /**
     * Default constructor for Worker 
     */
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
    
    /**
     * Constructor for Worker 
     * @param first_name holds the first name of the Worker 
     * @param last_name holds the last name of the Worker 
     * @param date_of_birth holds the date of birth of the Worker 
     * @param employee_num holds the employee number of the Worker
     * @param salary holds the salary of the Worker 
     * @param role holds the role of the Worker 
     * @param reports_to holds whom the Worker reports to 
     */
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
    
    /**
     * get method for the first name of the worker 
     * @return the first name of the worker 
     */
    public String getFirstName()
    {
        return first_name; 
    }
    
    /**
     * set method for the first name of the Worker 
     * @param first_name to set first name to 
     */
    public void setFirstName(String first_name)
    {
        this.first_name = first_name; 
    }
    
    /**
     * get method for the last name of a Worker 
     * @return the last name of the Worker 
     */
    public String getLastName()
    {
        return last_name; 
    }
    
    /**
     * set method for the last name of the worker 
     * @param last_name to set last name to 
     */
    public void setLastName(String last_name)
    {
        this.last_name = last_name; 
    }
    
    /**
     * get method for the birth date of the worker 
     * @return the birth date of the worker 
     */
    public Date getBirthDate()
    {
        return date_of_birth; 
    }
    
    /**
     * set method for the birth date of the Worker 
     * @param date_of_birth to set birth date to 
     */
    public void setBirthDate(Date date_of_birth)
    {
        this.date_of_birth = date_of_birth; 
    }
    
    /**
     * get method for employee number of Worker 
     * @return the employee number of the Worker 
     */
    public int getEmployeeNum()
    {
        return employee_num; 
    }
    
    /**
     * set method for the employee number of the Worker 
     * @param employee_num to set employee number to 
     */
    public void setEmployeeNum(int employee_num)
    {
        this.employee_num = employee_num; 
    }
    
    /**
     * get method for the salary of Worker 
     * @return the salary of the Worker 
     */
    public double getSalary()
    {
        return salary; 
    }
    
    /**
     * set method for the salary of the Worker 
     * @param salary to set salary to 
     */
    public void setSalary(double salary)
    {
        this.salary = salary; 
    }
    
    /**
     * get method for the role of the Worker 
     * @return the role of the Worker 
     */
    public Roles getRole()
    {
        return role;
    }
    
    /**
     * set method for the role of the Worker 
     * @param role to set role to 
     */
    public void setRole(Roles role)
    {
        this.role = role; 
    }
    
    /**
     * get method for whom the Worker reports to 
     * @return whom the Worker reports to 
     */
    public Worker getReportsTo()
    {
        return reports_to; 
    }
    
    /**
     * set method for whom the Worker reports to 
     * @param reports_to to set whom the Worker reports to 
     */
    public void setReportsTo(Worker reports_to)
    {
        this.reports_to = reports_to; 
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Helping methods 
    
    /**
     * print method for all Worker details 
     */
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
    
    /**
     * boolean method to check whether a worker has less of a salary than the passed parameter 
     * @param salary the compared value 
     * @return boolean of whether salary is less than passed parameter 
     */
    public boolean isLessSalary(double salary)
    {   
        return this.salary < salary; 
    }
    
    /**
     * boolean method to check whether Worker is older than the passed date 
     * @param date the compared date 
     * @return boolean whether Worker is older than the passed date 
     */
    public boolean isOlder(Date date)
    {
        return this.date_of_birth.compareTo(date) > 0; 
    }
    
    /**
     * Overridden worker method 
     * @param worker the Worker that is compared 
     * @return -1 if Worker calling method has less of a salary, 0 if the same, 1 if more 
     * @throws ClassCastException in case of not being compared to a Worker 
     */
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
    
    /**
     * Method to check whether current employee is the one being specified by employee number parameter 
     * @param employee_num used to check whether current employee has this employee number 
     * @return boolean whether employee is the one with passed employee number 
     */
    public boolean isWorker(int employee_num)
    {
        return this.employee_num == employee_num; 
    }
    
    /**
     * Method to check whether current employee is the one being specified by employee last_name parameter 
     * @param last_name used to check whether current employee has this last name 
     * @return boolean whether employee is the one with the passed employee last name 
     */
    public boolean isWorker(String last_name)
    {
        return this.last_name.equalsIgnoreCase(last_name); 
    }
}

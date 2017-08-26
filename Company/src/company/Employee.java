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
public class Employee extends Worker
{
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Class Setup 
    
    //Additionals
    private String office; 
    private int years_worked; 
    private int num_clients; 
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Constructors and beans 

    /**
     * Default constructor of Employee
     */
    public Employee()
    {
        super(); 
        office = ""; 
        years_worked = 0; 
        num_clients = 0; 
    }
    
    /**
     * 
     * @param first_name holds employee first name 
     * @param last_name holds employee last name
     * @param date_of_birth holds date of birth of employee 
     * @param employee_num holds employee number of employee
     * @param salary holds salary of employee
     * @param role holds role of employee
     * @param reports_to holds whom employee reports to 
     * @param office holds office in which employee works 
     * @param years_worked holds the number of years worked by the eployee 
     * @param num_clients holds the number of clients the employee has 
     */
    public Employee(String first_name, String last_name, Date date_of_birth, int employee_num, double salary, Roles role,
            Worker reports_to, String office, int years_worked, int num_clients)
    {
        super(first_name, last_name, date_of_birth, employee_num, salary, role, reports_to); 
        this.office = office; 
        this.years_worked = years_worked; 
        this.num_clients = num_clients; 
    }
    
    /**
     * get method for office 
     * @return office of employee
     */
    public String getOffice()
    {
        return office; 
    }
    
    /**
     * set method for office 
     * @param office to set employee office to 
     */
    public void setOffice(String office)
    {
        this.office = office; 
    }
    
    /**
     * get method for number of years worked by the employee
     * @return number of years worked by the employee
     */
    public int getYearsWorked()
    {
        return years_worked; 
    }
    
    /**
     * set method for the number of years the employee has worked 
     * @param years_worked to set number of years to 
     */
    public void setYearsWorked(int years_worked)
    {
        this.years_worked = years_worked; 
    }
    
    /**
     * get method for the number of clients the employee has 
     * @return the number of clients the employee has 
     */
    public int getNumClients()
    {
        return num_clients; 
    }
    
    /**
     * set method for the number of clients the employee has 
     * @param num_clients to set number of clients to 
     */
    public void setNumClients(int num_clients)
    {
        this.num_clients = num_clients; 
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Helping methods 
    
    /**
     * Overridden print method to display additional fields
     */
    @Override
    public void printWorker()
    {
        super.printWorker();
        System.out.println("     Office: " + office); 
        System.out.println(); 
        System.out.println("     Years worked: " + years_worked); 
        System.out.println(); 
        System.out.println("     Number of clients: " + num_clients); 
        System.out.println(); 
    }
}

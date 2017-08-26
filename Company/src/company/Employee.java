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
public class Employee extends Worker
{
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Class Setup       
    private String office; 
    private int years_worked; 
    private int num_clients; 
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Constructors and beans     
    public Employee()
    {
        super(); 
        office = ""; 
        years_worked = 0; 
        num_clients = 0; 
    }
    
    public Employee(String first_name, String last_name, Date date_of_birth, int employee_num, double salary, Roles role,
            Worker reports_to, String office, int years_worked, int num_clients)
    {
        super(first_name, last_name, date_of_birth, employee_num, salary, role, reports_to); 
        this.office = office; 
        this.years_worked = years_worked; 
        this.num_clients = num_clients; 
    }
    
    public String getOffice()
    {
        return office; 
    }
    
    public void setOffice(String office)
    {
        this.office = office; 
    }
    
    public int getYearsWorked()
    {
        return years_worked; 
    }
    
    public void setYearsWorked(int years_worked)
    {
        this.years_worked = years_worked; 
    }
    
    public int getNumClients()
    {
        return num_clients; 
    }
    
    public void setNumClients(int num_clients)
    {
        this.num_clients = num_clients; 
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Helping methods 
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

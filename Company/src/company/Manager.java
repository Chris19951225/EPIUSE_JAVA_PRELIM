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
public class Manager extends Employee
{
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Class Setup     
    private String secretary; 
    private String branch; 
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Constructors and beans       
    public Manager()
    {
        super(); 
        secretary = ""; 
        branch = ""; 
    }
    
    public Manager(String first_name, String last_name, Date date_of_birth, int employee_num, double salary, Roles role,
            Worker reports_to, String office, int years_worked, int num_clients, String secretary, String branch)
    {
        super(first_name, last_name, date_of_birth, employee_num, salary, role, reports_to, office, years_worked, num_clients);
        this.secretary = secretary; 
        this.branch = branch; 
    }
    
    public String getSecretary()
    {
        return secretary; 
    }
    
    public void setSecretary(String secretary)
    {
        this.secretary = secretary; 
    }
    
    public String getBranch()
    {
        return branch; 
    }
    
    public void setBranch(String branch)
    {
        this.branch = branch; 
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Helping methods
    @Override
    public void printWorker()
    {
        super.printWorker();
        System.out.println("     Secretary: " + secretary);
        System.out.println(); 
        System.out.println("     Branch: " + branch); 
        System.out.println(); 
    }
}

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
public class Manager extends Employee
{
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Class Setup  
    
    //Additionals
    private String secretary; 
    private String branch; 
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Constructors and beans 
    
    /**
     * Default constructor of Manager 
     */
    public Manager()
    {
        super(); 
        secretary = ""; 
        branch = ""; 
    }
    
    /**
     * Constructor of Manager
     * @param first_name holds the first_name of the Manager
     * @param last_name holds the last name of the Manager
     * @param date_of_birth holds the date of birth of the Manager 
     * @param employee_num holds the employee number of the Manager
     * @param salary holds the salary of the Manager
     * @param role holds the role of the Manager 
     * @param reports_to holds whom the Manager reports to 
     * @param office holds the office in which the Manager works 
     * @param years_worked holds the number of years the Manager has worked 
     * @param num_clients holds the number of clients the Manager has 
     * @param secretary holds the name of the managers secretary 
     * @param branch holds the branch at which the manager works 
     */
    public Manager(String first_name, String last_name, Date date_of_birth, int employee_num, double salary, Roles role,
            Worker reports_to, String office, int years_worked, int num_clients, String secretary, String branch)
    {
        super(first_name, last_name, date_of_birth, employee_num, salary, role, reports_to, office, years_worked, num_clients);
        this.secretary = secretary; 
        this.branch = branch; 
    }
    
    /**
     * get method for the Manager's secretary's name 
     * @return the secretary name 
     */
    public String getSecretary()
    {
        return secretary; 
    }
    
    /**
     * set method for the Manager's secretary 
     * @param secretary to set the secretary to 
     */
    public void setSecretary(String secretary)
    {
        this.secretary = secretary; 
    }
    
    /**
     * get method for the Managers branch 
     * @return the branch at which the manager works 
     */
    public String getBranch()
    {
        return branch; 
    }
    
    /**
     * set method for the Manager's branch 
     * @param branch to set the Manager's branch to 
     */
    public void setBranch(String branch)
    {
        this.branch = branch; 
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Helping methods
    
    /**
     * Overridden printWorker method to include additional fields 
     */
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

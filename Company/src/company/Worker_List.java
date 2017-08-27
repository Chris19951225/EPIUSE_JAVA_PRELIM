/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * created 26/08/2017
 * @author Hristian Vitrychenko
 */
public class Worker_List 
{
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Class setup     
    private List<Worker> workers; 
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Constructor and beans  
    
    /**
     * Default constructor for Worker List 
     */
    public Worker_List()
    {
        workers  = new ArrayList<Worker>();
    }
    
    /**
     * Constructor for Worker List
     * @param workers to set Worker List to 
     */
    public Worker_List(ArrayList<Worker> workers)
    {
        this.workers = workers; 
    }
        
    /**
     * get method for Worker List 
     * @return the Worker List 
     */
    public ArrayList<Worker> getWorkerList()
    {
        return (ArrayList<Worker>) workers; 
    }
    
    /**
     * set method for Worker List 
     * @param workers to set Worker List to 
     */
    public void setWorkerList(ArrayList<Worker> workers)
    {
        this.workers = workers; 
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Helping methods
    
    /**
     * Method to check if a Worker exists in Worker List
     * @param last_name to be checked if exists 
     * @return whether a Worker with the given last name exists 
     */
    public boolean workerExists(String last_name)
    {
        boolean exists = false; 
        for(Worker worker : workers)
        {
            if(worker.getLastName().equalsIgnoreCase(last_name))
            {
                exists = true; 
            }
        }
        
        return exists; 
    }
    
    /**
     * Method to check if a worker exists
     * @param employee_num to be checked if exists
     * @return whether a worker with the given employee number exists
     */
    public boolean workerExists(int employee_num)
    {
        boolean exists = false; 
        for(Worker worker : workers)
        {
            if(worker.getEmployeeNum() == employee_num)
            { 
                exists = true; 
            }
        }
        
        return exists; 
    }
    
    /**
     * get method for getting worker 
     * @param last_name to search list with 
     * @return the Worker with the passed last name 
     */
    public Worker getWorker(String last_name)
    {
        for(Worker worker : workers)
        {
            if(worker.getLastName().equalsIgnoreCase(last_name))
            {
                return worker; 
            }
        }
        
        return null; 
    }
    
    /**
     * get method for getting worker 
     * @param employee_num to search list with 
     * @return the Worker with the passed employee number 
     */
    public Worker getWorker(int employee_num)
    {
        for(Worker worker : workers)
        {
            if(worker.getEmployeeNum() == employee_num)
            { 
                return worker; 
            }
        }
        
        return null; 
    }
    
    /**
     * Add method for adding Worker to list 
     * @param worker the Worker to be added 
     */
    public void addWorker(Worker worker)
    {
        workers.add(worker); 
    }
    
    /**
     * delete method for worker in the Worker List 
     * @param last_name the name of the Worker to be deleted 
     * @return boolean whether the worker was deleted 
     */
    public boolean deleteWorker(String last_name)
    {
        for(Worker worker : workers)
        {
            if(worker.getLastName().equalsIgnoreCase(last_name))
            {
                workers.remove(worker); 
                return true; 
            }
        }
        
        return false; 
    }
    
    /**
     * delete method for worker in the Worker List 
     * @param employee_num the employee number of the Worker to be deleted 
     * @return boolean whether the worker was deleted 
     */
    public boolean deleteWorker(int employee_num)
    {
        for(Worker worker : workers)
        {
            if(worker.getEmployeeNum() == employee_num)
            {
                workers.remove(worker); 
                return true; 
            }
        }
        
        return false; 
    }
    
    /**
     * Method to check what Workers in the list are older than the given date 
     * @param date to be compared to the Worker's birth dates 
     */
    public void printOlder(Date date)
    {
        int older = 0; 
        for(Worker worker : workers)
        {
            if(worker.isOlder(date))
            {
                older++;
                System.out.println(worker.getFirstName() + " " + worker.getLastName());
            }
        }
        
        if(older == 0)
        {
            System.out.println("There is no one older than the given date");
        }
    }
    
    /**
     * Method that prints the hierarchy of the company 
     */
    public void printHierarchy()
    {
        for(Worker worker : workers)
        {
            if(worker.getReportsTo() == null)
            {
                printHierarchy(worker, 0); 
            }
        }
    }
    
    /**
     * Recursive method used for printing the company hierarchy 
     * @param worker the Worker passed to be printed 
     * @param spaces the amount of spaces representing the level of the underling
     */
    public void printHierarchy(Worker worker, int spaces)
    {
        if(worker.getRole().toString().equalsIgnoreCase("Manager"))
        {
            System.out.println(worker.getFirstName() + " " + worker.getLastName() + "(Manager)");
        }
        else if(worker.getReportsTo() != null)
        {
            spaces++; 
            System.out.println(worker.getFirstName() + " " + worker.getLastName() + "(" + worker.getRole().toString() + ")");
        }
        
        String currSpaces = ""; 
        
        for(Worker underling : workers)
        {
            for(int i = 0; i < spaces; i++)
            {
                currSpaces += " "; 
            }
            
            if(!underling.getRole().toString().equalsIgnoreCase("Manager"))
            {
                if(underling.getReportsTo().getLastName().equalsIgnoreCase(worker.getLastName()))
                {
                    System.out.println();
                    System.out.println(currSpaces + "|");
                    System.out.println();
                    System.out.println(currSpaces + "|");
                    System.out.println();
                    System.out.print(currSpaces + "--> "); 
                    printHierarchy(underling, spaces); 
                }
            }
        }
        
        System.out.println(); 
    }
    
    /**
     * Method to get the highest earning manager and his salary 
     * @return highest earning manager and salary string 
     */
    public String getHighestEarnerManagers()
    {
        String manager = ""; 
        Worker highest = null; 
        Worker currManager = null; 
        DecimalFormat formatDec = new DecimalFormat(".##");
        
        for(Worker worker : workers)
        {
            if(worker.getRole().toString().equalsIgnoreCase("Manager"))
            {
                currManager = worker; 
                
                if(highest == null)
                {
                    highest = currManager; 
                }
                else
                {
                    if(highest.compareTo(currManager) > 0)
                    {
                        highest = currManager; 
                    }
                }
            }
        }
        
        if(highest != null)
        {
            manager = highest.getFirstName() + " " + highest.getLastName(); 
            return "Managers: " + manager + " - " + "R " + formatDec.format(highest.getSalary()); 
        }
        else
        {
            return "No managers"; 
        }
    }
    
    /**
     * Method to get the highest earning employee and his salary 
     * @return highest earning employee and salary string 
     */
    public String getHighestEarnerEmployees()
    {
        String employee = ""; 
        Worker highest = null; 
        Worker currEmployee = null; 
        DecimalFormat formatDec = new DecimalFormat(".##");
        
        for(Worker worker : workers)
        {
            if(worker.getRole().toString().equalsIgnoreCase("Employee"))
            {
                currEmployee = worker; 
                
                if(highest == null)
                {
                    highest = currEmployee; 
                }
                else
                {
                    if(highest.compareTo(currEmployee) > 0)
                    {
                        highest = currEmployee; 
                    }
                }
            }
        }
        
        if(highest != null)
        {
            employee = highest.getFirstName() + " " + highest.getLastName(); 
            return "Employee: " + employee + " - " + "R " + formatDec.format(highest.getSalary()); 
        }
        else
        {
            return "No employees"; 
        }
    }
    
    /**
     * Method to get the highest earning trainee and his salary 
     * @return highest earning trainee and salary string 
     */
    public String getHighestEarnerTrainees()
    {
        String trainee = ""; 
        Worker highest = null; 
        Worker currTrainee = null; 
        DecimalFormat formatDec = new DecimalFormat(".##");
        
        for(Worker worker : workers)
        {
            if(worker.getRole().toString().equalsIgnoreCase("Trainee"))
            {
                currTrainee = worker; 
                
                if(highest == null)
                {
                    highest = currTrainee; 
                }
                else
                {
                    if(highest.compareTo(currTrainee) > 0)
                    {
                        highest = currTrainee; 
                    }
                }
            }
        }
        
        if(highest != null)
        {
            trainee = highest.getFirstName() + " " + highest.getLastName(); 
            return "Trainee: " + trainee + " - " + "R " + formatDec.format(highest.getSalary()); 
        }
        else
        {
            return "No managers"; 
        }
    }
    
    /**
     * Method to print all Manager in Worker List
     */
    public void printAllManagers()
    {
        for(Worker worker : workers)
        {
            if(worker.getRole().toString().equalsIgnoreCase("Manager"))
            {
                System.out.println(worker.getFirstName() + " " + worker.getLastName()); 
            }
        }
        
        System.out.println(); 
    }
    
    /**
     * Method to print all Employees in Worker List
     */
    public void printAllEmployees()
    {
        for(Worker worker : workers)
        {
            if(worker.getRole().toString().equalsIgnoreCase("Employee"))
            {
                System.out.println(worker.getFirstName() + " " + worker.getLastName()); 
            }
        }
        
        System.out.println(); 
    }
    
    /**
     * Method to print all Trainees in Worker List
     */
    public void printAllTrainees()
    {
        for(Worker worker : workers)
        {
            if(worker.getRole().toString().equalsIgnoreCase("Trainee"))
            {
                System.out.println(worker.getFirstName() + " " + worker.getLastName()); 
            }
        }
        
        System.out.println(); 
    }
    
    /**
     * Method to print all workers in Worker List 
     */
    public void printAllWorkers()
    {
        for(Worker worker : workers)
        {
            worker.printWorker();
        }
    }
    
    /**
     * Method to print all Worker names in Worker List
     */
    public void printAllWorkerNames()
    {
        for(Worker worker : workers)
        {
            System.out.println(worker.getFirstName() + " " + worker.getLastName()); 
        }
    }
}

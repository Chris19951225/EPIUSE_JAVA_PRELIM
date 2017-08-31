/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
                worker.printWorker(); 
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
    
    public void printHighestSalary()
    {
        sortList(); 
        
        
        
        boolean check = true; 
        
        for(int i = 1; i < workers.size(); i++)
        {
            if(workers.get(i).getRole().toString().equalsIgnoreCase("Manager"))
            {
                System.out.println("Managers: " + workers.get(i).getFirstName() + " " + 
                        workers.get(i).getLastName() + " - R" + workers.get(i).getSalary());
                break; 
            }
        }
        System.out.println();
        
        for(int i = 1; i < workers.size(); i++)
        {
            if(workers.get(i).getRole().toString().equalsIgnoreCase("Employee"))
            {
                System.out.println("Employees: " + workers.get(i).getFirstName() + " " + 
                        workers.get(i).getLastName() + " - R" + workers.get(i).getSalary());
                break; 
            }
        }
        System.out.println();
        
        System.out.println("Trainees: " + workers.get(0).getFirstName() + " " + 
                        workers.get(0).getLastName() + " - R" + workers.get(0).getSalary());
        
        System.out.println(); 
    }
    
    /**
     * Method to sort the Worker List 
     */
    public void sortList()
    {
        List<Worker> sorter = new ArrayList<Worker>(); 
        
        int totalWorkers = workers.size();
        int counter = 0; 
        double nextHighest = -1;  
        
        boolean subSort = true; 
        boolean subSub = true;
        
        while(subSort)
        {
            Worker newWorker = null; 
            subSub = true; 
            
            for(int i = 0; i < totalWorkers; i++)
            {
                if(newWorker == null && workers.get(i).getRole().toString().equalsIgnoreCase("Trainee"))
                {
                    newWorker = workers.get(i); 
                    nextHighest = newWorker.getSalary();  
                    subSub = false; 
                }
                else if(newWorker != null && workers.get(i).compareTo(newWorker) > 0 && workers.get(i).getRole().toString().equalsIgnoreCase("Trainee"))
                {
                    newWorker = workers.get(i); 
                    nextHighest = newWorker.getSalary();  
                    subSub = false; 
                }
            }
            
            if(subSub)
            {
                subSort = false; 
               
            }
            else
            {
                sorter.add(counter, newWorker);
                workers.remove(newWorker); 
                nextHighest = -1; 
                totalWorkers--; 
                counter++; 
            }
        }
        
        nextHighest = -1; 
        subSort = true;  
        
        while(subSort)
        {
            Worker newWorker = null; 
            subSub = true; 
            
            for(int i = 0; i < totalWorkers; i++)
            {
                if(newWorker == null && workers.get(i).getRole().toString().equalsIgnoreCase("Employee"))
                {
                    newWorker = workers.get(i); 
                    nextHighest = newWorker.getSalary();  
                    subSub = false; 
                }
                else if(newWorker != null && workers.get(i).compareTo(newWorker) > 0 && workers.get(i).getRole().toString().equalsIgnoreCase("Employee"))
                {
                    newWorker = workers.get(i); 
                    nextHighest = newWorker.getSalary();  
                    subSub = false; 
                }
            }
            
            if(subSub)
            {
                subSort = false; 
            }
            else
            {
                sorter.add(counter, newWorker);
                workers.remove(newWorker); 
                nextHighest = -1; 
                totalWorkers--; 
                counter++; 
            }
        }
        
        
        nextHighest = -1; 
        subSort = true; 
        
        while(subSort)
        {
            Worker newWorker = null; 
            subSub = true; 
            
            for(int i = 0; i < totalWorkers; i++)
            {
                if(newWorker == null && workers.get(i).getRole().toString().equalsIgnoreCase("Manager"))
                {
                    newWorker = workers.get(i); 
                    nextHighest = newWorker.getSalary();  
                    subSub = false; 
                }
                else if(newWorker != null && workers.get(i).compareTo(newWorker) > 0 && workers.get(i).getRole().toString().equalsIgnoreCase("Manager"))
                {
                    newWorker = workers.get(i); 
                    nextHighest = newWorker.getSalary();  
                    subSub = false; 
                }
            }
            
            if(subSub)
            {
                subSort = false; 
            }
            else
            {
                sorter.add(counter, newWorker);
                workers.remove(newWorker); 
                nextHighest = -1; 
                totalWorkers--; 
                counter++; 
            }
        }
        
        workers = sorter; 
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
            if(worker.getRole().toString().equalsIgnoreCase("Employees"))
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
            if(worker.getRole().toString().equalsIgnoreCase("Trainees"))
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
    
    /**
     * Method to print Worker from list with the given full name
     * @param worker the full name of the Worker to be printed 
     * @return whether a worker with given full name exists in the Worker List
     */
    public boolean printWorker(String worker)
    {
        Scanner scanLine = new Scanner(worker); 
        scanLine.useDelimiter(" ");
        
        boolean approved = false; 
        String firstName = "";
        String surname = ""; 
        
        for(int i = 0; i < 2; i++)
        {
            if(scanLine.hasNext() && i == 0)
            {
                firstName = scanLine.next(); 
            }
            else if(scanLine.hasNext() && i == 1)
            {
                surname = scanLine.next();
            } 
        }
       
        for(Worker work : workers)
        {
            if(work.getLastName().equalsIgnoreCase(surname) && work.getFirstName().equalsIgnoreCase(firstName))
            { 
                approved = true; 
                work.printWorker(); 
            }
        }
        
        if(!approved)
        {
            System.out.println("\nSorry, no one is named that here.\n"); 
        }
        
        return approved; 
    }
    
    /**
     * Method to print Worker based on first name 
     * @param firstName name of Worker to be printed 
     * @return whether a Worker with the given first name was found in Worker List 
     */
    public boolean printWorkerByFirstName(String firstName)
    {
 
        boolean approved = false; 

        for(Worker work : workers)
        {
            if(work.getFirstName().equalsIgnoreCase(firstName))
            { 
                approved = true; 
                work.printWorker(); 
            }
        }
        
        if(!approved)
        {
            System.out.println("\nSorry, no one is named that here.\n"); 
        }
        
        return approved; 
    }
    
    /**
     * Method to print Worker based on last name 
     * @param surname of the Worker to be printed 
     * @return whether a Worker with the given last name was found in Worker List
     */
    public boolean printWorkerByLastName(String surname)
    {
 
        boolean approved = false; 

        for(Worker work : workers)
        {
            if(work.getLastName().equalsIgnoreCase(surname))
            { 
                approved = true; 
                work.printWorker(); 
            }
        }
        
        if(!approved)
        {
            System.out.println("\nSorry, no one is named that here.\n"); 
        }
        
        return approved; 
    }
}

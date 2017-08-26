/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import java.util.ArrayList;
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
}

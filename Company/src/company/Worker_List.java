/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hristian Vitrychenko
 */
public class Worker_List 
{
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Class setup     
    private List<Worker> workers; 
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Constructor and beans    
    public Worker_List()
    {
        workers  = new ArrayList<Worker>();
    }
    
    public Worker_List(ArrayList<Worker> workers)
    {
        this.workers = workers; 
    }
        
    public ArrayList<Worker> getWorkerList()
    {
        return (ArrayList<Worker>) workers; 
    }
    
    public void setWorkerList(ArrayList<Worker> workers)
    {
        this.workers = workers; 
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Helping methods

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
    
    public void addWorker(Worker worker)
    {
        workers.add(worker); 
    }
    
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

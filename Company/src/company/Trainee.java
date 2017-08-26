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
public class Trainee extends Worker
{
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Class Setup       
    private Date end_of_training; 
    private boolean part_time; 
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Constructors and beans    
    public Trainee()
    {
        super(); 
        end_of_training = null; 
        part_time = false; 
    }
    
    public Trainee(String first_name, String last_name, Date date_of_birth, int employee_num, double salary, Roles role,
            Worker reports_to, Date end_of_training, boolean part_time)
    {
        super(first_name, last_name, date_of_birth, employee_num, salary, role, reports_to); 
        this.end_of_training = end_of_training; 
        this.part_time = part_time; 
    }
    
    public Date getEndOfTraining()
    {
        return end_of_training; 
    }
    
    public void setEndOfTraining(Date end_of_training)
    {
        this.end_of_training = end_of_training; 
    }
    
    public boolean getPartTime()
    {
        return part_time; 
    }
    
    public void setPartTime(boolean part_time)
    {
        this.part_time = part_time; 
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Helping methods 
    
    public int getDaysLeftUntilDone()
    {
        Date current = new Date(); 
        int days = (int)( (end_of_training.getTime() - current.getTime()) / (1000 * 60 * 60 * 24));
        
        return days; 
    }
}

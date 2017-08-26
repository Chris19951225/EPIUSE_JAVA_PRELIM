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
public class Trainee extends Worker
{
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Class Setup       
    
    //Additional 
    private Date end_of_training; 
    private boolean part_time; 
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Constructors and beans

    /**
     * Default constructor of Trainee
     */
    public Trainee()
    {
        super(); 
        end_of_training = null; 
        part_time = false; 
    }
    
    /**
     * Constructor of Trainee
     * @param first_name holds the name of the Trainee 
     * @param last_name holds the surname of the Trainee
     * @param date_of_birth hols the date of birth of the Trainee
     * @param employee_num hols the employee number of the Trainee 
     * @param salary holds the salary of the Trainee
     * @param role holds the role of the Trainee 
     * @param reports_to holds whom the Trainee reports to 
     * @param end_of_training holds the date of the end of the Trainee's training 
     * @param part_time holds whether the Trainee works part-time 
     */
    public Trainee(String first_name, String last_name, Date date_of_birth, int employee_num, double salary, Roles role,
            Worker reports_to, Date end_of_training, boolean part_time)
    {
        super(first_name, last_name, date_of_birth, employee_num, salary, role, reports_to); 
        this.end_of_training = end_of_training; 
        this.part_time = part_time; 
    }
    
    /**
     * get method for the date of the end of the Trainee's training 
     * @return the date of the end of the Trainee's training 
     */
    public Date getEndOfTraining()
    {
        return end_of_training; 
    }
    
    /**
     * set method for the Trainee's end of training 
     * @param end_of_training to set end of training to 
     */
    public void setEndOfTraining(Date end_of_training)
    {
        this.end_of_training = end_of_training; 
    }
    
    /**
     * get method for whether the Trainee works part-time 
     * @return whether the Trainee works part-time 
     */
    public boolean getPartTime()
    {
        return part_time; 
    }
    
    /**
     * set method for Trainee's work time 
     * @param part_time to set Trainee's part time field to 
     */
    public void setPartTime(boolean part_time)
    {
        this.part_time = part_time; 
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Helping methods 
    
    /**
     * Helper method to see how many days left for the Trainee to end training 
     * @return number of days left for Trainee to finish training 
     */
    public int getDaysLeftUntilDone()
    {
        Date current = new Date(); 
        int days = (int)( (end_of_training.getTime() - current.getTime()) / (1000 * 60 * 60 * 24));
        
        return days; 
    }
    
    /**
     * Overridden printWorker method to include additional fields 
     */
    @Override 
    public void printWorker()
    {
        super.printWorker();
        System.out.println("     End of training: " + end_of_training.toString()); 
        System.out.println(); 
        System.out.println("     Part-time: " + part_time); 
        System.out.println(); 
    }
}

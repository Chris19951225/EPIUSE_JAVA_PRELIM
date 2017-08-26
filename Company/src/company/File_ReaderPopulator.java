/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import static company.Worker.Roles.MANAGER;
import static company.Worker.Roles.TRAINEE;
import static company.Worker.Roles.EMPLOYEE;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * created 26/08/2017
 * @author Hristian Vitrychenko
 */
public class File_ReaderPopulator 
{
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Class Setup       
    private Worker_List list;//List of workers 
    private final String file_path = "Workers.txt";//File path to text file holding worker information 
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Constructors and beans 

    /**
     * Default constructor of File_ReaderPopulator
     */
    public File_ReaderPopulator()
    {
        list = null; 
    }
    
    /**
     * Constructor of File_ReaderPopulator 
     * @param list to set list to 
     */
    public File_ReaderPopulator(Worker_List list)
    {
        this.list = list; 
    }
    
    /**
     * get method for worker list 
     * @return the worker list 
     */
    public Worker_List getList()
    {
        return list; 
    }
    
    /**
     * set method for the worker list 
     * @param list to set worker list to 
     */
    public void setList(Worker_List list)
    {
        this.list = list; 
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Helping methods    
    /**
     * Populate method for worker list 
     * @return the number of lines and thus the number of workers in the file 
     * @throws Exception in case of file reading going wrong 
     */
    public int populateList() throws Exception
    {
        Scanner scanner = new Scanner(file_path);
        Scanner scanLine;
        String line; 
        String currString; 
        int numLines = 0; 
        
        DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
        Date date;
        
        while(scanner.hasNextLine())
        {
            line = scanner.nextLine(); 
            scanLine = new Scanner(line); 
            scanLine.useDelimiter(";"); 
            numLines++; 
            
            currString = scanLine.next();
            
            if(currString.equalsIgnoreCase("manager"))
            {
                Manager newManager = new Manager(); 
                
                currString = scanLine.next(); 
                newManager.setFirstName(currString);
                currString = scanLine.next(); 
                newManager.setLastName(currString);
                currString = scanLine.next();
                date = date_format.parse(currString); 
                newManager.setBirthDate(date); 
                currString = scanLine.next(); 
                newManager.setEmployeeNum(Integer.parseInt(currString)); 
                currString = scanLine.next(); 
                newManager.setSalary(Double.parseDouble(currString)); 
                currString = scanLine.next(); 
                newManager.setReportsTo(null);
                newManager.setRole(MANAGER); 
                    
                currString = scanLine.next(); 
                newManager.setOffice(currString);
                currString = scanLine.next(); 
                newManager.setYearsWorked(Integer.parseInt(currString)); 
                currString = scanLine.next();
                newManager.setNumClients(Integer.parseInt(currString)); 
                currString = scanLine.next(); 
                newManager.setSecretary(currString); 
                currString = scanLine.next(); 
                newManager.setBranch(currString);
                
                list.addWorker(newManager); 
            }
            else if(currString.equalsIgnoreCase("employee"))
            {
                Employee newEmployee = new Employee(); 
                
                currString = scanLine.next(); 
                newEmployee.setFirstName(currString);
                currString = scanLine.next(); 
                newEmployee.setLastName(currString);
                currString = scanLine.next();
                date = date_format.parse(currString); 
                newEmployee.setBirthDate(date); 
                currString = scanLine.next(); 
                newEmployee.setEmployeeNum(Integer.parseInt(currString)); 
                currString = scanLine.next(); 
                newEmployee.setSalary(Double.parseDouble(currString)); 
                currString = scanLine.next(); 
                newEmployee.setReportsTo(list.getWorker(currString));
                newEmployee.setRole(EMPLOYEE); 
                    
                currString = scanLine.next(); 
                newEmployee.setOffice(currString);
                currString = scanLine.next(); 
                newEmployee.setYearsWorked(Integer.parseInt(currString)); 
                currString = scanLine.next();
                newEmployee.setNumClients(Integer.parseInt(currString)); 
                
                list.addWorker(newEmployee); 
            }
            else if(currString.equalsIgnoreCase("trainee"))
            {
                Trainee newTrainee = new Trainee(); 
                
                currString = scanLine.next(); 
                newTrainee.setFirstName(currString);
                currString = scanLine.next(); 
                newTrainee.setLastName(currString);
                currString = scanLine.next();
                date = date_format.parse(currString); 
                newTrainee.setBirthDate(date); 
                currString = scanLine.next(); 
                newTrainee.setEmployeeNum(Integer.parseInt(currString)); 
                currString = scanLine.next(); 
                newTrainee.setSalary(Double.parseDouble(currString)); 
                currString = scanLine.next(); 
                newTrainee.setReportsTo(list.getWorker(currString));
                newTrainee.setRole(TRAINEE); 
                
                currString = scanLine.next(); 
                date = date_format.parse(currString); 
                newTrainee.setEndOfTraining(date); 
                currString = scanLine.next(); 
                
                if(currString.equalsIgnoreCase("false"))
                {
                    newTrainee.setPartTime(false); 
                }
                else
                {
                    newTrainee.setPartTime(true); 
                }
                
                list.addWorker(newTrainee); 
            }
            else
            {
                throw new Exception("Something is wrong in the file"); 
            }
        }
        
        return numLines; 
    }
}

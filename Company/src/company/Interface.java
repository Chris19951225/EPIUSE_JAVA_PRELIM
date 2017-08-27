/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import static company.Worker.Roles.EMPLOYEE;
import static company.Worker.Roles.MANAGER;
import static company.Worker.Roles.TRAINEE;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created 26/08/2017
 * @author Hristian Vitrychenko
 */
public class Interface 
{
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Class Setup      
    private boolean running; 
    private Worker_List list; 
    private File_ReaderPopulator populator; 
    private int numWorkers; 
    private String readLine; 
    private int choice; 
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Constructors and beans 
    /**
     * Default constructor for Interface
     */
    public Interface()
    {
        running = true; 
        list = new Worker_List(); 
        populator = new File_ReaderPopulator(list);
        readLine = ""; 
        choice = 0; 
        
        try
        {
            numWorkers = populator.populateList(); 
        }
        catch(Exception ex)
        {
            System.out.println("Something went wrong: " + ex); 
        }
    } 

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Helping methods
    
    /**
     * Method for choice 2 which is to list employees older than a specified date 
     * @throws ParseException in case date given cannot be parsed
     */
    public void choice2() throws ParseException
    {
        Scanner scanner = new Scanner(System.in);
        boolean keepAsking = true; 
        DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
        Date date;
        
        while(keepAsking)
        {
            System.out.println("Please type in the date (dd-MM-yyyy): "); 
            String reg = "[0-9]{2}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{4}";
            Pattern pat = Pattern.compile(reg);

            readLine = scanner.nextLine(); 
            Matcher match = pat.matcher(readLine);

            if(!match.find())
            {
                System.out.println("Please input the date in the correct format (dd-MM-yyyy"); 
            }
            else
            {
                date = date_format.parse(readLine);
                System.out.println(); 
                list.printOlder(date);
                System.out.println(); 
                keepAsking = false;
            }
        }
    }
    
    /**
     * Method for choice 4 which is to list highest earner in each tier 
     */
    public void choice4() 
    {
        String curr = ""; 
        curr = list.getHighestEarnerManagers(); 
        System.out.println(curr); 
        System.out.println(); 
        curr = list.getHighestEarnerEmployees(); 
        System.out.println(curr);
        System.out.println(); 
        curr = list.getHighestEarnerTrainees(); 
        System.out.println(curr); 
        System.out.println(); 
    }
    
    /**
     * Method for choice 5 which is to add a new employee
     * @throws ParseException in case date cannot be parsed 
     */
    public void choice5() throws ParseException
    {
        Scanner scanner = new Scanner(System.in);
        boolean run = true; 
        String reader = ""; 
        int decision = 0; 
        
            Worker newWorker = null; 
            System.out.println(); 
            System.out.println("Please specify the new type of worker (1-Manager, 2-Employee, 3-Trainee): "); 
            
            reader = scanner.nextLine(); 
            
            try
            {
                decision = Integer.parseInt(reader); 
            }
            catch(Exception ex)
            {
                System.out.println("Please type in a number between 1-3"); 
            }
            
            if(decision < 0 || decision > 3)
            {
                System.out.println("Please type in a number between 1-3");
            }
            else
            {
                DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
               
                String fname; 
                String lname; 
                String read; 
                Date dob = null; 
                Date det = null; 
                int emp_num = -1; 
                double sal = -1.0;  
                String reports = ""; 
                String office; 
                int y_worked = -1; 
                int clients = -1; 
                String secretary; 
                String branch; 
                boolean loop = true; 
                boolean part_time = false; 
                
                String reg = "[0-9]{2}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{4}";
                Pattern pat = Pattern.compile(reg);
                
                System.out.println("Please type in the new first name: "); 
                fname = scanner.nextLine();  
                System.out.println("Please type in the new surname: "); 
                lname = scanner.nextLine(); 
                    
                while(loop)
                {
                    System.out.println("Please type in the new date of birth (dd-MM-yyyy): "); 
                    read = scanner.nextLine();  
                    Matcher match = pat.matcher(read);
                    
                    if(!match.find())
                    {
                        System.out.println("Please type in the date in the specified format(dd-MM-yyyy): ");
                    }
                    else
                    {
                        dob = date_format.parse(read);
                        loop = false; 
                    }
                }
                    
                loop = true; 
                    
                while(loop)
                {
                    System.out.println("Please type in the new employee number: "); 
                    read = scanner.nextLine(); 
                        
                    try
                    {
                        emp_num = Integer.parseInt(read); 
                    }
                    catch(Exception ex)
                    {
                        System.out.println("Please type in a number for the employee number"); 
                    }
                        
                    if(emp_num > 0 && emp_num < 300)
                    {       
                        if(!list.workerExists(emp_num))
                        {
                            loop = false; 
                        }
                        else
                        {
                            System.out.println("This employee number already exists, please try a different one"); 
                        }
                    }
                }
                
                loop = true; 
                
                while(loop)
                {
                    System.out.println("Please type in the new salary: "); 
                    read = scanner.nextLine();  
                        
                    try
                    {
                        sal = Double.parseDouble(read); 
                    }
                    catch(Exception ex)
                    {
                        System.out.println("Please type in an appropriate number for the salary"); 
                    }
                    
                    if(sal > 0)
                    {
                        loop = false; 
                    }
                    else
                    {
                        System.out.println("Please type in an appropriate number for the salary"); 
                    }
                }
                
                loop = true; 
                
                while(loop)
                {
                    System.out.println("Please type in the last name of the person the new worker reports to: ");
                    read = scanner.nextLine();  
                    
                    if(list.workerExists(read))
                    {
                        loop = false; 
                        reports = read; 
                    }
                    else
                    {
                        System.out.println("A worker with that last name does not exist "); 
                        System.out.println("Here are all the poeple available to report to, please choose one of their last names: ");
                        list.printAllWorkerNames(); 
                    }
                }
                
                 Worker reporter = list.getWorker(reports); 
                
                if(decision == 1 || decision == 2)
                {
                    System.out.println("Please type in the new office: "); 
                    office = scanner.nextLine();  
                    
                    loop = true; 
                    
                    while(loop)
                    {
                        System.out.println("Please type in the new number of years worked: "); 
                        read = scanner.nextLine(); 

                        try
                        {
                            y_worked = Integer.parseInt(read); 
                        }
                        catch(Exception ex)
                        {
                            System.out.println("Please type in a number for the employee number"); 
                        }

                        if(y_worked > 0)
                        {       
                            loop = false; 
                        }
                        else
                        {
                            System.out.println("Please type in an appropriate number for the new years worked"); 
                        }
                    }
                    
                    loop = true; 
                    
                    while(loop)
                    {
                        System.out.println("Please type in the new number of clients: "); 
                        read = scanner.nextLine();  

                        try
                        {
                            clients = Integer.parseInt(read); 
                        }
                        catch(Exception ex)
                        {
                            System.out.println("Please type in a number for the new clients"); 
                        }

                        if(clients > 0)
                        {       
                            loop = false; 
                        }
                        else
                        {
                            System.out.println("Please type in an appropriate number for the new years worked"); 
                        }
                    }
                    
                    if(decision == 2)
                    {
                        newWorker = new Employee(fname, lname, dob, emp_num, sal, EMPLOYEE, reporter, office, y_worked, clients); 
                    }
                    else
                    {
                        System.out.println("Please type in a name for the new secretary: "); 
                        secretary = scanner.nextLine();  
                        System.out.println("Please type in a name for the new branch: "); 
                        branch = scanner.nextLine(); 
                        
                        newWorker = new Manager(fname, lname, dob, emp_num, sal, MANAGER, reporter, office, y_worked, clients, secretary, branch); 
                    } 
                }
                else
                {
                    loop = true; 
                    
                    while(loop)
                    {
                        System.out.println("Please type in the new date of birth (dd-MM-yyyy): "); 
                        read = scanner.nextLine(); 
                        Matcher match = pat.matcher(readLine);

                        if(!match.find())
                        {
                            System.out.println("Please type in the date in the specified format(dd-MM-yyyy): ");
                        }
                        else
                        {
                            det = date_format.parse(read);
                            loop = false; 
                        }
                    }
                    
                    loop = false; 
                    
                    while(loop)
                    {
                        System.out.println("Is the trainee working part-time? (Y/N): "); 
                        read = scanner.nextLine();  
                        if(read.equalsIgnoreCase("y") || read.equalsIgnoreCase("n"))
                        {
                            if(read.equalsIgnoreCase("y"))
                            {
                                part_time = true; 
                            }
                        }
                        else
                        {
                             System.out.println("Please type in either 'Y' for yes or 'N' for no: ");
                        }
                    }
                    
                    newWorker = new Trainee(fname, lname, dob, emp_num, sal, TRAINEE, reporter, det, part_time); 
                }
            }
            
            if(newWorker!=null)
            {
                 list.addWorker(newWorker);
            }
    }
    
    /**
     * Method for choice 6 which is to delete a Worker
     */
    public void choice6()
    {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true; 
        String reader; 
        int emp_num = -1; 
        
        while(loop)
        {
            System.out.println("Please type in either the last name or employee number of the worker you wish to delete"); 
            reader = scanner.nextLine(); 

            if(reader.equalsIgnoreCase("quit"))
            {
                System.out.println("Going back to main menu"); 
                System.out.println(); 
                loop = false; 
            }
            else if(list.workerExists(reader))
            {
                list.deleteWorker(reader); 
                System.out.println("Worker has been deleted from the list"); 
                System.out.println(); 
                loop = false; 
            }
            else
            {
                try
                {
                    emp_num = Integer.parseInt(reader); 
                    
                    if(list.workerExists(emp_num))
                    {
                        list.deleteWorker(emp_num); 
                        System.out.println("Worker has been deleted from the list"); 
                        System.out.println(); 
                        loop = false; 
                    }
                    else
                    {
                        System.out.println("You did not input an appropriate last name or employee number, please try again or type quit to go back to "
                            + "main menu"); 
                    }
                }
                catch(Exception ex)
                {
                    System.out.println("You did not input an appropriate last name or employee number, please try again or type quit to go back to "
                            + "main menu"); 
                }
            }
        }
    }
    
    /**
     * Method to run the Interface
     * @throws ParseException in case date cannot be parsed 
     */
    public void runInterface() throws ParseException
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to my company!"); 
        System.out.println(); 
        System.out.println("Here's what you can do (please type in the number of the operation you would like to carry out): ");
        System.out.println(); 
        
        while(running)
        {
            System.out.println("Preliminary Assignment operations: ");
            System.out.println(); 
            System.out.println("    1. Print employee records");
            System.out.println("    2. List employees older than a date");
            System.out.println("    3. Print full organizational structure");
            System.out.println("    4. Print highest earning workers per tier");
            System.out.println();
            System.out.println("Addtional operations: ");
            System.out.println();
            System.out.println("    5. Add worker to current list (note, this won't update the text file)");
            System.out.println("    6. Delete worker from current list (note, this won't update the text file)");
            System.out.println("    7. List all managers in the company");
            System.out.println("    8. List all the employees in the company");
            System.out.println("    9. List all trainees in the company");
            System.out.println("    10. Quit Compnay program");
            System.out.println("Please type in your choice (number): "); 
            
            readLine = scanner.nextLine();  
            
            try
            {
                choice = Integer.parseInt(readLine); 
            }
            catch(Exception ex)
            {
                System.out.println("Please input the number of your choice (has to be a number)"); 
            }
            
            if(choice < 1 || choice > 10)
            {
                System.out.println("Please input a number in the range of choices (1-10)"); 
            }
            else
            {
                System.out.println(); 
                
                switch(choice)
                {
                    case 1: 
                        list.printAllWorkers();
                        break;
                    case 2: 
                        choice2();
                        break; 
                    case 3: 
                        list.printHierarchy();
                        break; 
                    case 4: 
                        choice4();
                        break; 
                    case 5: 
                        choice5(); 
                        break; 
                    case 6: 
                        choice6(); 
                        break; 
                    case 7: 
                        list.printAllManagers();
                        break; 
                    case 8: 
                        list.printAllEmployees();
                        break; 
                    case 9: 
                        list.printAllTrainees();
                        break; 
                    case 10: 
                        running = false; 
                        break; 
                    default: 
                        System.out.println("Hello there!"); 
                        break; 
                }
            }
        }
    }
}

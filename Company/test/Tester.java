
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * created 27/08/2017
 * @author Hristian Vitrychenko
 */
public class Tester 
{
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Main Method   
    public static void main(String[] args)
    {
        testInputDate(); 
        testEmployeeNumber(); 
        testSalary(); 
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Tester Methods    
    
    /**
     * Method to test date inputs 
     */
    public static void testInputDate()
    {
        System.out.println("Testing input validation for date"); 
        
        String[] tests = {"1990-01-02","     ","","Hello There","123-01-1990","01-123-1994","02-1993-23","10-34-21","67-12-1992","12-01-1994"}; 
        String reg = "[0-9]{2}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{4}";
        Pattern pat = Pattern.compile(reg);
        Matcher match; 
        
        for(int i = 0; i < 10; i ++)
        {
            match = pat.matcher(tests[i]);
            
            if(!match.find())
            {
                System.out.println("Test at position " + i + " failed. Wrong input: " + tests[i]); 
            }
            else
            {
                System.out.println("Test at position " + i + " passed. Correct input: " + tests[i]);
            }
        }
        
        System.out.println(); 
    }
    
    /**
     * Method to test employee number inputs 
     */
    public static void testEmployeeNumber()
    {
        System.out.println("Testing Employee Number"); 
        
        String[] tests = {"","     ","1.00","Hello There","-17","2but","-1.00","300","301","3"}; 
        int emp_num = 0; 
        
        for(int i = 0; i < 10; i ++)
        {
            try
            {
                emp_num = Integer.parseInt(tests[i]); 
            }
            catch(Exception ex)
            {
                 System.out.println("Test at position " + i + " failed. Wrong input: " + tests[i]);
            }
            
            if(emp_num < 0 || emp_num > 300)
            {
                System.out.println("Test at position " + i + " failed. Wrong input: " + tests[i]);
            }
            else
            {
                System.out.println("Test at position " + i + " passed. Correct input: " + tests[i]);
            }
        }
        
        System.out.println(); 
    }
    
    /**
     * Method to test salary inputs 
     */
    public static void testSalary()
    {
        System.out.println("Testing Salary values"); 
        
        String[] tests = {"","     ","@#$%","Hello There","-17","2but","-1.00","19-01-2017","3","3.00"}; 
        double sal = 0; 
        
        for(int i = 0; i < 10; i ++)
        {
            try
            {
                sal = Double.parseDouble(tests[i]); 
            }
            catch(Exception ex)
            {
                 System.out.println("Test at position " + i + " failed. Wrong input: " + tests[i]);
            }
            
            if(sal < 0)
            {
                System.out.println("Test at position " + i + " failed. Wrong input: " + tests[i]);
            }
            else
            {
                System.out.println("Test at position " + i + " passed. Correct input: " + tests[i]);
            }
        }
        
        System.out.println();
    }
}

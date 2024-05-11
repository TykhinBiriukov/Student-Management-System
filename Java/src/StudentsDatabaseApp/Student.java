package StudentsDatabaseApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Student
{
    private String firstName;
    private String lastName;
    private int eduYear;
    private String studentID;
    private ArrayList<String> courses = new ArrayList<String>();
    private int balance;
    private static int cost = 600;
    private static int id = 1000;

    public Student()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\nPlease enter student's first name: ");
        this.firstName = in.nextLine();

        System.out.print("Please enter student's last name: ");
        this.lastName = in.nextLine();

        System.out.print("\nPlease enter student's year of education:\n1 - Freshman;\n2 - Sophmore;\n3 - Junior;\n4 - Senior;\n");
            System.out.print("Student's year is: ");
            int temp = 0;
            while (temp == 0)
            {
                try
                {
                    eduYear = Integer.parseInt(in.nextLine());
                    if (eduYear < 1 || eduYear > 4)
                    {
                        while (eduYear < 1 || eduYear > 4)
                        {
                            System.out.print("Error! Please enter number from 1 to 4: ");
                            this.eduYear = in.nextInt();
                        }
                    }
                    temp = 1;
                }
                catch (Exception e)
                {
                    System.out.print("Please enter a number: ");
                }
            }    
        System.out.println("");
        setStudentID();
        in.close();
    }

    private void setStudentID()
    {
        id++;
        this.studentID = eduYear + "" + id;
    }

    public void enroll()
    {
        Scanner in = new Scanner(System.in);
        do
        {
            System.out.print("Please enter course to enroll or Q to quit: ");
            String course = in.nextLine();
            if (!course.equals("Q") && !course.equals("q"))
            {
                courses.add(course);
                balance += cost;
            }
            else 
            {
                System.out.println("Selection completed.\n");
                break;
            }
        } while (1 != 0);
        in.close();
    }

    public void viewBalance()
    {
        System.out.println("Student's debt is: " + balance + "$");
    }

    public void coursesPayment()
    {
        int temp =0;
        viewBalance();
        if (balance < 600)
        {
            System.out.println("Student has no debts.");
        }
        else
        {
            System.out.print("Please enter sum student want to pay: ");
            while (temp == 0)
            {
                try
                {
                    Scanner in = new Scanner(System.in);
                    int payment = Integer.parseInt(in.nextLine());
                    if (payment > balance)
                    {
                        while (payment > balance)
                        {
                            System.out.print("Please enter number less than your debt: ");
                            payment = Integer.parseInt(in.nextLine());
                        }
                    }
                    else if (payment <= -1)
                    {
                        while (payment < 0)
                        {
                            System.out.print("Please enter positive number: ");
                            payment = Integer.parseInt(in.nextLine());
                        }
                    }
                    balance -= payment;
                    System.out.print("Thank you for your payment!\nYour new balance is: ");
                    viewBalance();
                    temp = 1;
                    in.close();
                }
                catch (Exception e)
                {
                    System.out.print("Please enter sum you want to pay: ");
                }
            }  
        }
    }

    public String showInfo()
    {
        return "\n~~~Student Information~~~" + "\nName: " + firstName + " " + lastName + ";" + "\nStudent ID: " + studentID + ";" + "\nCourses enrolled: " + courses + "\nYour debt: " + balance + "$";
    }
}
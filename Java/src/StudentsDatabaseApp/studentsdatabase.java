package StudentsDatabaseApp;

import java.util.Scanner;

public class studentsdatabase 
{
    public static void main(String[] args)
    {
        System.out.print("Please enter number of new students to enroll: ");
        Scanner in = new Scanner(System.in);
        int numOfStudents = 0;
        Student[] students = new Student[0];
        int temp = 0;
        while (temp == 0)
        {
            try
            {
                numOfStudents = Integer.parseInt(in.nextLine());
                if (numOfStudents < 1)
                {
                    while (numOfStudents < 1)
                    {
                        System.out.print("Please enter positive number: ");
                        numOfStudents = Integer.parseInt(in.nextLine());
                    }
                }
                students = new Student[numOfStudents];
                temp = 1;
            }
            catch (Exception e)
            {
                System.out.print("Please enter a number: ");
            }    
        }
        for (int i = 0; i <= numOfStudents-1; i++)
        {
            students[i] = new Student();
            students[i].enroll();
            students[i].coursesPayment();
            System.out.println(students[i].showInfo());
        }
        in.close();
    }
}

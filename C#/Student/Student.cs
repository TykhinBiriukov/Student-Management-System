using System.Collections;

class Student
{
    private string firstName;
    private string lastName;
    private int eduYear;
    private string studentId;
    private ArrayList courses = new ArrayList();
    private int balance;
    private int cost = 600;
    private int id = 1000;
    bool temp = true;

    public Student()
    {
        Console.WriteLine("Please enter student's first name: ");
        this.firstName = Console.ReadLine();
        Console.WriteLine("Please enter student's last name: ");
        this.lastName = Console.ReadLine();
        Console.WriteLine("\nPlease enter student's year of education:\n1 - Freshman;\n2 - Sophmore;\n3 - Junior;\n4 - Senior;\n");
        Console.WriteLine("Student's year is: ");
        while (temp == true)
        {
            try
            {   
                eduYear = Int32.Parse(Console.ReadLine());
                switch (eduYear, eduYear, eduYear, eduYear)
                {
                    case (1, 2, 3, 4):
                        temp = false;
                        break;
                    default:
                        Console.WriteLine("Please enter number from 1 to 4: ");
                        break;
                }
            }
            catch (Exception e)
            {
                Console.WriteLine("Please enter a number: ");
            }
        }
        setStudentId();
    }

    private void setStudentId()
    {
        id++; 
        this.studentId = eduYear + "" + id;
    } 
    
    public void enroll()
    {
        do 
        {
            Console.WriteLine("Please enter course to enroll or Q to quit: ");
            string course = Console.ReadLine();
            if (course != "q" || course != "Q")
            {
                courses.Add(course);
                balance += cost;
            }
            else
            {
                Console.WriteLine("Selection completed.\n");
                temp = false;
            }
        }
        while(temp == true);
    }

    public void viewBalance()
    {
        Console.WriteLine("Student's debt is: " + balance + "$");
    }

    public void coursesPayment()
    {
        viewBalance();
        if (balance < 600)
        {
            Console.WriteLine("Student has no debts.");
        }
        else
        {
            Console.WriteLine("Please enter sum student want to pay: ");
            while (temp == true)
            {
                try
                {
                    int payment = Int32.Parse(Console.ReadLine());
                    if (payment > balance)
                    {
                        while (payment > balance)
                        {
                            Console.WriteLine("Please enter number less than your debt: ");
                            payment = Int32.Parse(Console.ReadLine());
                        }
                    }
                    else if (payment <= -1)
                    {
                        while (payment < 0)
                        {
                            Console.WriteLine("Please enter positive number: ");
                            payment = Int32.Parse(Console.ReadLine());
                        }
                    }
                    balance -= payment;
                    Console.WriteLine("Thank you for your payment!\nYour new balance is: ");
                    viewBalance();
                    temp = false;
                }
                catch (Exception e)
                {
                    Console.WriteLine("Please enter sum you want to pay: ");
                }
            }  
        }
    }

    public String showInfo()
    {
        return "\n~~~Student Information~~~" + "\nName: " + firstName + " " + lastName + ";" + "\nStudent ID: " + studentId + ";" + "\nCourses enrolled: " + courses + "\nYour debt: " + balance + "$";
    }
}